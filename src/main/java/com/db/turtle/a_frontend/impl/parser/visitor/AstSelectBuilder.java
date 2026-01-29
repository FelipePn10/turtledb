package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.common.denominator.D_Projection;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.table.CreateTableParser;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.select.SelectBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.select.SelectParser;
import com.db.turtle.a_frontend.common.denominator.A_AstNode;
import com.db.turtle.a_frontend.common.denominator.B_Expression;
import com.db.turtle.a_frontend.impl.parser.ast.expression.BinaryExpression;
import com.db.turtle.a_frontend.impl.parser.ast.expression.ColumnExpression;
import com.db.turtle.a_frontend.impl.parser.ast.expression.ComparisonOperator;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.BooleanLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.NullLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.NumberLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.StringLiteral;
import com.db.turtle.a_frontend.common.commands_ast.statements.SelectStatement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnListProjection;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.StarProjection;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos SELECT.
 */
public class AstSelectBuilder extends SelectBaseVisitor<A_AstNode> {

    /**
     * Transforma o contexto de uma regra de seleção da árvore de parsing num nó da AST.
     * <p>
     * Este método implementa o padrão Visitor para processar a regra:
     * {@code SELECT columnList FROM tableName whereClause?}
     * </p>
     *
     * @param ctx O contexto da regra de seleção gerado pelo parser.
     * @return Uma instância de {@link SelectStatement} representando o comando SQL mapeado.
     * @see SelectStatement
     */
    @Override
    public A_AstNode visitSelectStatement(SelectParser.SelectStatementContext ctx) {

        D_Projection projection = buildProjection(ctx.projection());

        TableName table = buildTableName(ctx.tableName());

        Optional<B_Expression> where = ctx.whereClause() == null
                ? Optional.empty()
                : Optional.of(
                (B_Expression) visit(ctx.whereClause().booleanExpression())
        );

        return new SelectStatement(projection, table, where);
    }

    private D_Projection buildProjection(SelectParser.ProjectionContext ctx) {
        if (ctx.STAR() != null) {
            return new StarProjection();
        }

        List<ColumnName> columns = ctx.column()
                .stream()
                .map(this::buildColumnName)
                .toList();

        return new ColumnListProjection(columns);
    }

    private TableName buildTableName(SelectParser.TableNameContext ctx) {
        return new TableName(ctx.IDENTIFIER().getText());
    }

    private ColumnName buildColumnName(SelectParser.ColumnContext ctx) {
        return new ColumnName(ctx.IDENTIFIER().getText());
    }

    /**
     * Traduz uma comparação textual da Parse Tree numa operação lógica executável da AST
     * <p>
     *     Utiliza o método from de {@link ComparisonOperator} para conversão.
     * </p>
     * */
    @Override
    public A_AstNode visitPredicate(SelectParser.PredicateContext ctx) {
        B_Expression left = (B_Expression) visit(ctx.column());
        ComparisonOperator operator =
                ComparisonOperator.from(ctx.comparisonOperator().getText());
        B_Expression right = (B_Expression) visit(ctx.literal());

        // Operação lógica AST
        return new BinaryExpression(left, operator, right);
    }

    @Override
    public A_AstNode visitTableName(SelectParser.TableNameContext ctx) {
        return new TableName(ctx.IDENTIFIER().getText());
    }

    @Override
    public A_AstNode visitColumn(SelectParser.ColumnContext ctx) {
        return new ColumnExpression(ctx.IDENTIFIER().getText());
    }

    /**
     * Visita o contexto de um literal e retorna um Literal tipado.
     *
     * Converte tokens da gramática (NUMBER, STRING, NULL) em tipos específicos:
     * - NUMBER: NumberLiteral (BigDecimal internamente para precisão SQL)
     * - STRING: StringLiteral (texto sem aspas)
     * - NULL: NullLiteral.INSTANCE
     *
     * @param ctx O contexto do literal
     * @return Uma instância específica de Literal (StringLiteral, NumberLiteral ou NullLiteral)
     */
    @Override
    public A_AstNode visitLiteral(SelectParser.LiteralContext ctx) {

        TerminalNode node = (TerminalNode) ctx.getChild(0);
        Token token = node.getSymbol();

        return switch (token.getType()) {
            case SelectParser.NUMBER ->
                    new NumberLiteral(new BigDecimal(token.getText()));
            case SelectParser.STRING ->
                    new StringLiteral(unquote(token.getText()));


            case SelectParser.NULL -> NullLiteral.INSTANCE;
            case SelectParser.TRUE -> BooleanLiteral.TRUE;
            case SelectParser.FALSE -> BooleanLiteral.FALSE;

            default -> throw new IllegalArgumentException(
                    "Unknown literal: " + token.getText()
            );
        };
    }

    private static String unquote(String quoted) {
        return quoted.substring(1, quoted.length() - 1)
                .replace("''", "'");
    }
}