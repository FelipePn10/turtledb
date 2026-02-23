package com.db.turtle.binder;

import com.db.turtle.a_frontend.common.denominator.B_Expression;
import com.db.turtle.a_frontend.common.denominator.E_BinaryOperator;
import com.db.turtle.a_frontend.impl.parser.ast.expression.BinaryExpression;
import com.db.turtle.a_frontend.impl.parser.ast.expression.ComparisonOperator;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.*;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.*;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.Binder;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.*;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.exception.BindExceptionApplication;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.ntm.BoundColumnRef;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.operator.ArithmeticOperator;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.operator.LogicOperator;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.ColumnMetadata;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.InMemoryCatalog;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.TableMetadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

/**
 * Testes de unidade para o {@link Binder}.
 *
 * <p><b>Estratégia:</b>
 * <ul>
 *   <li>{@link InMemoryCatalog} e {@link TableMetadata} são instâncias reais com dados
 *       controlados — sem mocks, sem acoplamento à implementação interna.</li>
 *   <li>Cada grupo de cenários isolado via {@code @Nested} por responsabilidade.</li>
 *   <li>Foco nas funcionalidades recém-adicionadas:
 *       <b>WHERE com {@link ComparisonOperator}</b> e
 *       <b>projeção aritmética com {@link ArithmeticOperator}</b>.</li>
 * </ul>
 */
@DisplayName("Binder")
class BinderTest {

    private static final String SCHEMA       = "public";
    private static final String TABLE        = "orders";

    private static final String COL_QUANTITY = "quantity";  // IntegerType       pos=0
    private static final String COL_PRICE    = "price";     // DecimalType(10,2) pos=1
    private static final String COL_DISCOUNT = "discount";  // IntegerType       pos=2
    private static final String COL_ACTIVE   = "active";    // BooleanType       pos=3

    private Binder binder;

    @BeforeEach
    void setUp() {
        ColumnMetadata quantity = new ColumnMetadata(new ColumnName(COL_QUANTITY), new IntegerType(),      false, 0);
        ColumnMetadata price    = new ColumnMetadata(new ColumnName(COL_PRICE),    new DecimalType(10, 2), false, 1);
        ColumnMetadata discount = new ColumnMetadata(new ColumnName(COL_DISCOUNT), new IntegerType(),      false, 2);
        ColumnMetadata active   = new ColumnMetadata(new ColumnName(COL_ACTIVE),   new BooleanType(),      false, 3);

        TableMetadata ordersTable = new TableMetadata(
                SCHEMA,
                new TableName(TABLE),
                List.of(quantity, price, discount, active)
        );

        InMemoryCatalog catalog = new InMemoryCatalog();
        catalog.registerTable(ordersTable);

        binder = new Binder(catalog);
    }

    @Nested
    @DisplayName("SELECT — projeção")
    class Projection {

        @Test
        @DisplayName("SELECT * expande todas as colunas da tabela")
        void starProjection_expandsAllColumns() {
            BoundSelectStmt result = bind(selectStar());

            assertThat(result.projection())
                    .hasSize(4)
                    .allMatch(e -> e instanceof BoundColumnRef);
        }

        @Test
        @DisplayName("SELECT coluna única resolve nome e tipo corretamente")
        void singleColumn_resolvesNameAndType() {
            BoundSelectStmt result = bind(selectWith(List.of(col(COL_PRICE))));

            assertThat(result.projection()).hasSize(1);
            BoundColumnRef ref = (BoundColumnRef) result.projection().getFirst();
            assertThat(ref.columnName().getName()).isEqualTo(COL_PRICE);
            assertThat(ref.getType()).isInstanceOf(DecimalType.class);
        }

        @Test
        @DisplayName("SELECT múltiplas colunas preserva ordem de declaração")
        void multipleColumns_preservesDeclarationOrder() {
            BoundSelectStmt result = bind(selectWith(List.of(col(COL_DISCOUNT), col(COL_QUANTITY))));

            assertThat(result.projection()).hasSize(2);
            assertThat(columnNameAt(result, 0)).isEqualTo(COL_DISCOUNT);
            assertThat(columnNameAt(result, 1)).isEqualTo(COL_QUANTITY);
        }

        @Test
        @DisplayName("Coluna inexistente lança BindExceptionApplication com o nome da coluna")
        void unknownColumn_throwsWithColumnName() {
            assertThatThrownBy(() -> binder.bind(selectWith(List.of(col("ghost_column")))))
                    .isInstanceOf(BindExceptionApplication.class)
                    .hasMessageContaining("ghost_column");
        }
    }

    @Nested
    @DisplayName("FROM — resolução de tabela")
    class TableResolution {

        @Test
        @DisplayName("Tabela inexistente lança BindExceptionApplication com o nome da tabela")
        void tableNotFound_throwsWithTableName() {
            SelectStmt stmt = new SelectStmt(
                    List.of(col(COL_QUANTITY)),
                    new TableRef(Optional.empty(), new TableName("ghost_table"), Optional.empty()),
                    Optional.empty()
            );

            assertThatThrownBy(() -> binder.bind(stmt))
                    .isInstanceOf(BindExceptionApplication.class)
                    .hasMessageContaining("ghost_table");
        }

        @Test
        @DisplayName("Sem alias, o nome da tabela é usado como alias padrão")
        void noAlias_tableNameUsedAsDefault() {
            BoundSelectStmt result = bind(selectStar());

            assertThat(result.from().alias()).isEqualTo(TABLE);
        }

        @Test
        @DisplayName("Alias personalizado é preservado no BoundTableRef")
        void customAlias_isPreserved() {
            SelectStmt stmt = new SelectStmt(
                    List.of(col(COL_QUANTITY)),
                    new TableRef(Optional.empty(), new TableName(TABLE), Optional.of("o")),
                    Optional.empty()
            );

            BoundSelectStmt result = bind(stmt);

            assertThat(result.from().alias()).isEqualTo("o");
        }
    }

    @Nested
    @DisplayName("WHERE — ComparisonOperator")
    class WhereComparisonOperator {

        @Test
        @DisplayName("WHERE ausente produz Optional vazio")
        void noWhereClause_producesEmptyOptional() {
            assertThat(bind(selectStar()).where()).isEmpty();
        }

        @Test
        @DisplayName("WHERE price > discount  →  BoundBinaryExpression do tipo Boolean")
        void greaterThan_numericOperands_returnsBooleanType() {
            SelectStmt stmt = selectStarWithWhere(bin(col(COL_PRICE), ComparisonOperator.GT, col(COL_DISCOUNT)));

            BoundSelectStmt result = bind(stmt);

            assertThat(result.where()).isPresent();
            assertThat(result.where().get().getType()).isInstanceOf(BooleanType.class);
        }

        @Test
        @DisplayName("WHERE quantity = discount  ->  BooleanType (mesmo tipo numérico)")
        void equality_sameNumericType_returnsBooleanType() {
            SelectStmt stmt = selectStarWithWhere(bin(col(COL_QUANTITY), ComparisonOperator.EQ, col(COL_DISCOUNT)));

            BoundSelectStmt result = bind(stmt);

            assertThat(result.where()).isPresent();
            assertThat(result.where().get().getType()).isInstanceOf(BooleanType.class);
        }

        @Test
        @DisplayName("WHERE price <= discount  ->  BooleanType e operandos left/right preservados")
        void lessThanOrEqual_preservesLeftAndRightOperands() {
            SelectStmt stmt = selectStarWithWhere(bin(col(COL_PRICE), ComparisonOperator.LE, col(COL_DISCOUNT)));

            BoundBinaryExpression boundWhere = whereExpr(bind(stmt));

            assertThat(boundWhere.getType()).isInstanceOf(BooleanType.class);
            assertThat(((BoundColumnRef) boundWhere.left()).columnName().getName()).isEqualTo(COL_PRICE);
            assertThat(((BoundColumnRef) boundWhere.right()).columnName().getName()).isEqualTo(COL_DISCOUNT);
        }

        @ParameterizedTest(name = "ComparisonOperator.{0} com operandos numéricos → BooleanType")
        @EnumSource(ComparisonOperator.class)
        @DisplayName("Todos os operadores de comparação numérica produzem BooleanType")
        void allComparisonOperators_numericOperands_returnBoolean(ComparisonOperator op) {
            SelectStmt stmt = selectStarWithWhere(bin(col(COL_QUANTITY), op, col(COL_DISCOUNT)));

            BoundSelectStmt result = bind(stmt);

            assertThat(result.where()).isPresent();
            assertThat(result.where().get().getType()).isInstanceOf(BooleanType.class);
        }

        @Test
        @DisplayName("WHERE com expressão aritmética (Decimal, não Boolean) lança BindExceptionApplication")
        void whereWithArithmeticResult_notBoolean_throws() {
            // price + discount -> DecimalType, não BooleanType -> deve ser rejeitado
            SelectStmt stmt = selectStarWithWhere(bin(col(COL_PRICE), ArithmeticOperator.ADD, col(COL_DISCOUNT)));

            assertThatThrownBy(() -> binder.bind(stmt))
                    .isInstanceOf(BindExceptionApplication.class)
                    .hasMessageContaining("BOOLEAN");
        }

        @Test
        @DisplayName("WHERE com tipos incompatíveis (Boolean > Integer) lança exception")
        void incompatibleTypes_throwsException() {
            SelectStmt stmt = selectStarWithWhere(bin(col(COL_ACTIVE), ComparisonOperator.GT, col(COL_QUANTITY)));

            assertThatThrownBy(() -> binder.bind(stmt))
                    .isInstanceOf(RuntimeException.class);
        }
    }

    @Nested
    @DisplayName("Expressões aritméticas — ArithmeticOperator")
    class ArithmeticExpressions {

        @Test
        @DisplayName("ADD: Integer + Integer → IntegerType")
        void add_integerPlusInteger_resolvesToInteger() {
            BoundBinaryExpression bound = bindSingleExpr(bin(col(COL_QUANTITY), ArithmeticOperator.ADD, col(COL_DISCOUNT)));

            assertThat(bound.getType()).isInstanceOf(IntegerType.class);
        }

        @Test
        @DisplayName("ADD: Decimal + Integer → DecimalType (widening)")
        void add_decimalPlusInteger_resolvesToDecimal() {
            BoundBinaryExpression bound = bindSingleExpr(bin(col(COL_PRICE), ArithmeticOperator.ADD, col(COL_DISCOUNT)));

            assertThat(bound.getType()).isInstanceOf(DecimalType.class);
        }

        @Test
        @DisplayName("SUB: Decimal - Integer → DecimalType (widening)")
        void sub_decimalMinusInteger_resolvesToDecimal() {
            BoundBinaryExpression bound = bindSingleExpr(bin(col(COL_PRICE), ArithmeticOperator.SUB, col(COL_DISCOUNT)));

            assertThat(bound.getType()).isInstanceOf(DecimalType.class);
        }

        @Test
        @DisplayName("MUL: Decimal * Integer → DecimalType")
        void mul_decimalTimesInteger_resolvesToDecimal() {
            BoundBinaryExpression bound = bindSingleExpr(bin(col(COL_PRICE), ArithmeticOperator.MUL, col(COL_QUANTITY)));

            assertThat(bound.getType()).isInstanceOf(DecimalType.class);
        }

        @Test
        @DisplayName("DIV: Decimal(10,2) / Integer → DecimalType com scale=13, precision=21")
        void div_decimalDivideInteger_calculatesCorrectScaleAndPrecision() {
            // scale     = max(6, s1 + p2 + 1) = max(6, 2 + 10 + 1) = 13
            // precision = (p1 - s1) + s2 + scale = (10 - 2) + 0 + 13 = 21
            BoundBinaryExpression bound = bindSingleExpr(bin(col(COL_PRICE), ArithmeticOperator.DIV, col(COL_QUANTITY)));

            assertThat(bound.getType()).isInstanceOf(DecimalType.class);
            DecimalType result = (DecimalType) bound.getType();
            assertThat(result.getScale()).isEqualTo(13);
            assertThat(result.getPrecision()).isEqualTo(21);
        }

        @Test
        @DisplayName("MOD: Integer % Integer → IntegerType")
        void mod_integerModInteger_resolvesToInteger() {
            BoundBinaryExpression bound = bindSingleExpr(bin(col(COL_QUANTITY), ArithmeticOperator.MOD, col(COL_DISCOUNT)));

            assertThat(bound.getType()).isInstanceOf(IntegerType.class);
        }

        @Test
        @DisplayName("MOD com Decimal lança BindExceptionApplication com mensagem 'integer'")
        void mod_withDecimalOperand_throws() {
            assertThatThrownBy(() ->
                    binder.bind(selectWith(List.of(bin(col(COL_PRICE), ArithmeticOperator.MOD, col(COL_DISCOUNT))))))
                    .isInstanceOf(BindExceptionApplication.class)
                    .hasMessageContaining("integer");
        }

        @Test
        @DisplayName("Aritmética com Boolean lança BindExceptionApplication com mensagem 'numeric'")
        void arithmetic_withBooleanOperand_throws() {
            assertThatThrownBy(() ->
                    binder.bind(selectWith(List.of(bin(col(COL_ACTIVE), ArithmeticOperator.ADD, col(COL_QUANTITY))))))
                    .isInstanceOf(BindExceptionApplication.class)
                    .hasMessageContaining("numeric");
        }

        @Test
        @DisplayName("DIV preserva operandos esquerdo e direito inalterados")
        void div_preservesLeftAndRightOperands() {
            BoundBinaryExpression bound = bindSingleExpr(bin(col(COL_PRICE), ArithmeticOperator.DIV, col(COL_QUANTITY)));

            assertThat(((BoundColumnRef) bound.left()).columnName().getName()).isEqualTo(COL_PRICE);
            assertThat(((BoundColumnRef) bound.right()).columnName().getName()).isEqualTo(COL_QUANTITY);
        }

        @Test
        @DisplayName("Aninhado: price * (quantity + discount) — binding recursivo preserva tipos em cada nível")
        void nestedExpression_bindsRecursively() {
            BinaryExpression inner = bin(col(COL_QUANTITY), ArithmeticOperator.ADD, col(COL_DISCOUNT));
            BinaryExpression outer = bin(col(COL_PRICE),    ArithmeticOperator.MUL, inner);

            BoundBinaryExpression boundOuter = bindSingleExpr(outer);

            // Nó raiz: MUL com resultado Decimal (widening)
            assertThat(boundOuter.symbol()).isEqualTo(ArithmeticOperator.MUL);
            assertThat(boundOuter.getType()).isInstanceOf(DecimalType.class);

            // Nó filho direito: ADD com Integer
            BoundBinaryExpression boundInner = (BoundBinaryExpression) boundOuter.right();
            assertThat(boundInner.symbol()).isEqualTo(ArithmeticOperator.ADD);
            assertThat(boundInner.getType()).isInstanceOf(IntegerType.class);
        }

        @Test
        @DisplayName("Profundamente aninhado: (price + discount) * (quantity - discount) — árvore completa")
        void deeplyNested_bindsFullTree() {
            BinaryExpression left  = bin(col(COL_PRICE),    ArithmeticOperator.ADD, col(COL_DISCOUNT));
            BinaryExpression right = bin(col(COL_QUANTITY), ArithmeticOperator.SUB, col(COL_DISCOUNT));
            BinaryExpression root  = bin(left, ArithmeticOperator.MUL, right);

            BoundBinaryExpression bound = bindSingleExpr(root);

            assertThat(bound.getType()).isInstanceOf(DecimalType.class);
            assertThat(bound.left()).isInstanceOf(BoundBinaryExpression.class);
            assertThat(bound.right()).isInstanceOf(BoundBinaryExpression.class);
        }
    }

    @Nested
    @DisplayName("Combinação: projeção aritmética + WHERE comparison")
    class CombinedScenarios {

        @Test
        @DisplayName("SELECT price * quantity WHERE price > discount — bind completo e correto")
        void fullSelect_arithmeticProjection_comparisonWhere() {
            SelectStmt stmt = new SelectStmt(
                    List.of(bin(col(COL_PRICE), ArithmeticOperator.MUL, col(COL_QUANTITY))),
                    tableRef(),
                    Optional.of(bin(col(COL_PRICE), ComparisonOperator.GT, col(COL_DISCOUNT)))
            );

            BoundSelectStmt result = bind(stmt);

            assertThat(result.projection()).hasSize(1);
            assertThat(result.projection().getFirst().getType()).isInstanceOf(DecimalType.class);
            assertThat(result.where()).isPresent();
            assertThat(result.where().get().getType()).isInstanceOf(BooleanType.class);
        }

        @Test
        @DisplayName("SELECT * WHERE quantity <= price — tipos numéricos cruzados no WHERE")
        void crossNumericTypes_comparison_bindsSuccessfully() {
            SelectStmt stmt = selectStarWithWhere(bin(col(COL_QUANTITY), ComparisonOperator.LE, col(COL_PRICE)));

            BoundSelectStmt result = bind(stmt);

            assertThat(result.where()).isPresent();
            assertThat(result.where().get().getType()).isInstanceOf(BooleanType.class);
            assertThat(result.projection()).hasSize(4);
        }

        @Test
        @DisplayName("Bind idempotente: mesmo statement bound duas vezes produz resultados equivalentes")
        void bindIsIdempotent() {
            SelectStmt stmt = selectStarWithWhere(bin(col(COL_PRICE), ComparisonOperator.GT, col(COL_DISCOUNT)));

            BoundSelectStmt first  = bind(stmt);
            BoundSelectStmt second = bind(stmt);

            assertThat(first.projection()).hasSameSizeAs(second.projection());
            assertThat(first.where().isPresent()).isEqualTo(second.where().isPresent());
        }

        @Test
        @DisplayName("SELECT price * quantity WHERE (price > discount) AND (quantity > discount) — aritmética + lógica")
        void arithmeticProjection_withLogicWhere() {
            BinaryExpression cmp1 = bin(col(COL_PRICE),    ComparisonOperator.GT, col(COL_DISCOUNT));
            BinaryExpression cmp2 = bin(col(COL_QUANTITY), ComparisonOperator.GT, col(COL_DISCOUNT));
            BinaryExpression and  = bin(cmp1, LogicOperator.AND, cmp2);

            SelectStmt stmt = new SelectStmt(
                    List.of(bin(col(COL_PRICE), ArithmeticOperator.MUL, col(COL_QUANTITY))),
                    tableRef(),
                    Optional.of(and)
            );

            BoundSelectStmt result = bind(stmt);

            assertThat(result.projection().getFirst().getType()).isInstanceOf(DecimalType.class);
            assertThat(result.where()).isPresent();
            assertThat(result.where().get().getType()).isInstanceOf(BooleanType.class);
        }
    }

    @Nested
    @DisplayName("WHERE — LogicOperator")
    class WhereLogicOperator {

        @Test
        @DisplayName("AND entre dois Boolean → BooleanType")
        void and_booleanOperands_returnsBooleanType() {
            // (price > discount) AND (quantity > discount)
            BinaryExpression left  = bin(col(COL_PRICE),    ComparisonOperator.GT, col(COL_DISCOUNT));
            BinaryExpression right = bin(col(COL_QUANTITY), ComparisonOperator.GT, col(COL_DISCOUNT));
            BinaryExpression and   = bin(left, LogicOperator.AND, right);

            BoundSelectStmt result = bind(selectStarWithWhere(and));

            assertThat(result.where()).isPresent();
            assertThat(result.where().get().getType()).isInstanceOf(BooleanType.class);
        }

        @Test
        @DisplayName("OR entre dois Boolean → BooleanType")
        void or_booleanOperands_returnsBooleanType() {
            // (price > discount) OR (quantity = discount)
            BinaryExpression left  = bin(col(COL_PRICE),    ComparisonOperator.GT, col(COL_DISCOUNT));
            BinaryExpression right = bin(col(COL_QUANTITY), ComparisonOperator.EQ, col(COL_DISCOUNT));
            BinaryExpression or    = bin(left, LogicOperator.OR, right);

            BoundSelectStmt result = bind(selectStarWithWhere(or));

            assertThat(result.where()).isPresent();
            assertThat(result.where().get().getType()).isInstanceOf(BooleanType.class);
        }

        @Test
        @DisplayName("AND preserva operandos esquerdo e direito")
        void and_preservesLeftAndRightOperands() {
            BinaryExpression left  = bin(col(COL_PRICE),    ComparisonOperator.GT, col(COL_DISCOUNT));
            BinaryExpression right = bin(col(COL_QUANTITY), ComparisonOperator.EQ, col(COL_DISCOUNT));
            BinaryExpression and   = bin(left, LogicOperator.AND, right);

            BoundBinaryExpression bound = whereExpr(bind(selectStarWithWhere(and)));

            assertThat(bound.symbol()).isEqualTo(LogicOperator.AND);
            assertThat(bound.left()).isInstanceOf(BoundBinaryExpression.class);
            assertThat(bound.right()).isInstanceOf(BoundBinaryExpression.class);
        }

        @Test
        @DisplayName("AND aninhado: (a > b) AND (c > d) AND (a = c) — três níveis")
        void and_tripleNested_bindsRecursively() {
            BinaryExpression cmp1  = bin(col(COL_PRICE),    ComparisonOperator.GT, col(COL_DISCOUNT));
            BinaryExpression cmp2  = bin(col(COL_QUANTITY), ComparisonOperator.GT, col(COL_DISCOUNT));
            BinaryExpression cmp3  = bin(col(COL_PRICE),    ComparisonOperator.EQ, col(COL_QUANTITY));
            BinaryExpression inner = bin(cmp1, LogicOperator.AND, cmp2);
            BinaryExpression outer = bin(inner, LogicOperator.AND, cmp3);

            BoundSelectStmt result = bind(selectStarWithWhere(outer));

            assertThat(result.where()).isPresent();
            assertThat(result.where().get().getType()).isInstanceOf(BooleanType.class);
        }

        @ParameterizedTest(name = "LogicOperator.{0} entre Booleans → BooleanType")
        @EnumSource(value = LogicOperator.class, names = {"AND", "OR"})
        @DisplayName("AND e OR com operandos Boolean produzem BooleanType")
        void andOr_booleanOperands_returnBoolean(LogicOperator op) {
            BinaryExpression left  = bin(col(COL_PRICE),    ComparisonOperator.GT, col(COL_DISCOUNT));
            BinaryExpression right = bin(col(COL_QUANTITY), ComparisonOperator.EQ, col(COL_DISCOUNT));
            BinaryExpression expr  = bin(left, op, right);

            BoundSelectStmt result = bind(selectStarWithWhere(expr));

            assertThat(result.where()).isPresent();
            assertThat(result.where().get().getType()).isInstanceOf(BooleanType.class);
        }

        @Test
        @DisplayName("AND com lado esquerdo não-Boolean (aritmético) lança exception no WHERE")
        void and_leftNotBoolean_throwsOnWhereValidation() {
            // price + discount → Decimal, não Boolean → WHERE deve rejeitar
            BinaryExpression arithmetic = bin(col(COL_PRICE), ArithmeticOperator.ADD, col(COL_DISCOUNT));
            BinaryExpression right      = bin(col(COL_QUANTITY), ComparisonOperator.GT, col(COL_DISCOUNT));
            BinaryExpression and        = bin(arithmetic, LogicOperator.AND, right);

            assertThatThrownBy(() -> binder.bind(selectStarWithWhere(and)))
                    .isInstanceOf(RuntimeException.class);
        }
    }

    // =========================================================================
    // 7. ArithmeticOperator — lógica interna isolada
    // =========================================================================

    @Nested
    @DisplayName("ArithmeticOperator — lógica interna")
    class ArithmeticOperatorUnit {

        @Test
        @DisplayName("fromSymbol(\"+\") → ADD")
        void fromSymbol_plus_returnsAdd() {
            assertThat(ArithmeticOperator.fromSymbol("+")).isEqualTo(ArithmeticOperator.ADD);
        }

        @Test
        @DisplayName("fromSymbol(\"%\") → MOD")
        void fromSymbol_percent_returnsMod() {
            assertThat(ArithmeticOperator.fromSymbol("%")).isEqualTo(ArithmeticOperator.MOD);
        }

        @Test
        @DisplayName("fromSymbol símbolo desconhecido lança BindExceptionApplication")
        void fromSymbol_unknown_throwsBindException() {
            assertThatThrownBy(() -> ArithmeticOperator.fromSymbol("^"))
                    .isInstanceOf(BindExceptionApplication.class);
        }

        @Test
        @DisplayName("DIV.resolveResultType(Decimal(10,2), Integer) — scale=13 e precision=21")
        void div_resolveResultType_calculatesScaleAndPrecision() {
            DataType result = ArithmeticOperator.DIV.resolveResultType(new DecimalType(10, 2), new IntegerType());

            assertThat(result).isInstanceOf(DecimalType.class);
            assertThat(((DecimalType) result).getScale()).isEqualTo(13);
            assertThat(((DecimalType) result).getPrecision()).isEqualTo(21);
        }

        @Test
        @DisplayName("ADD.validate(Integer, Integer) não lança exception (tipos válidos)")
        void add_validate_integerOperands_doesNotThrow() {
            // Verifica que nenhuma exception é lançada para tipos numéricos válidos
            try {
                ArithmeticOperator.ADD.validate(new IntegerType(), new IntegerType());
            } catch (Exception e) {
                fail("Não deveria lançar exception para Integer + Integer, mas lançou: " + e.getMessage());
            }
        }

        @Test
        @DisplayName("MOD.validate(Decimal, Integer) lança BindExceptionApplication com mensagem 'integer'")
        void mod_validate_decimalOperand_throwsWithMessage() {
            assertThatThrownBy(() ->
                    ArithmeticOperator.MOD.validate(new DecimalType(10, 2), new IntegerType()))
                    .isInstanceOf(BindExceptionApplication.class)
                    .hasMessageContaining("integer");
        }

        @Test
        @DisplayName("ADD.validate(Boolean, Integer) lança BindExceptionApplication com mensagem 'numeric'")
        void add_validate_booleanOperand_throwsWithMessage() {
            assertThatThrownBy(() ->
                    ArithmeticOperator.ADD.validate(new BooleanType(), new IntegerType()))
                    .isInstanceOf(BindExceptionApplication.class)
                    .hasMessageContaining("numeric");
        }
    }

    /**
     * Constrói um {@link ColumnRef}.
     * Assinatura real: ColumnRef(Optional<String> qualifier, ColumnName name)
     */
    private static ColumnRef col(String name) {
        return new ColumnRef(Optional.empty(), new ColumnName(name));
    }

    /**
     * Constrói um {@link TableRef} para a tabela padrão.
     * Assinatura real: TableRef(Optional<String> schema, TableName name, Optional<String> alias)
     */
    private static TableRef tableRef() {
        return new TableRef(Optional.empty(), new TableName(TABLE), Optional.empty());
    }

    /**
     * Constrói um {@link BinaryExpression}.
     * Assinatura real: BinaryExpression(B_Expression left, E_BinaryOperator operator, B_Expression right)
     */
    private static BinaryExpression bin(B_Expression left, E_BinaryOperator op, B_Expression right) {
        return new BinaryExpression(left, op, right);
    }

    /**
     * SELECT * FROM orders (sem WHERE).
     * Cast seguro: StarProjection implementa B_Expression em runtime.
     */
    @SuppressWarnings("unchecked")
    private static SelectStmt selectStar() {
        return new SelectStmt(
                (List<B_Expression>) (List<?>) List.of(new StarProjection()),
                tableRef(),
                Optional.empty()
        );
    }

    /** SELECT &lt;exprs&gt; FROM orders (sem WHERE). */
    private static SelectStmt selectWith(List<B_Expression> projection) {
        return new SelectStmt(projection, tableRef(), Optional.empty());
    }

    /** SELECT * FROM orders WHERE &lt;where&gt;. */
    @SuppressWarnings("unchecked")
    private static SelectStmt selectStarWithWhere(B_Expression where) {
        return new SelectStmt(
                (List<B_Expression>) (List<?>) List.of(new StarProjection()),
                tableRef(),
                Optional.of(where)
        );
    }

    /** Faz o bind e devolve {@link BoundSelectStmt}. */
    private BoundSelectStmt bind(SelectStmt stmt) {
        return (BoundSelectStmt) binder.bind(stmt);
    }

    /**
     * Faz o bind de um SELECT com uma única expressão na projeção
     * e retorna o {@link BoundBinaryExpression} resultante.
     */
    private BoundBinaryExpression bindSingleExpr(B_Expression expr) {
        return (BoundBinaryExpression) bind(selectWith(List.of(expr))).projection().getFirst();
    }

    /**
     * Extrai o {@link BoundBinaryExpression} da cláusula WHERE.
     * Falha explicitamente com mensagem clara se o WHERE estiver ausente.
     */
    private static BoundBinaryExpression whereExpr(BoundSelectStmt result) {
        assertThat(result.where()).as("WHERE clause deve estar presente").isPresent();
        return (BoundBinaryExpression) result.where().get();
    }

    /** Extrai o nome da coluna da projeção pelo índice. */
    private static String columnNameAt(BoundSelectStmt result, int index) {
        return ((BoundColumnRef) result.projection().get(index)).columnName().getName();
    }
}