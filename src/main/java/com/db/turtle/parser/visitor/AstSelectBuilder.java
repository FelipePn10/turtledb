package com.db.turtle.parser.visitor;

import com.db.turtle.parser.antlr.statement.dml.select.SelectBaseVisitor;
import com.db.turtle.parser.antlr.statement.dml.select.SelectParser;
import com.db.turtle.parser.ast.denominator.AstNode;
import com.db.turtle.parser.ast.denominator.Expression;
import com.db.turtle.parser.ast.statements.SelectStatement;
import com.db.turtle.parser.ast.ntm.TableName;
import com.db.turtle.parser.ast.expression.*;

import java.util.List;
import java.util.Optional;


/**
 * Visita a parse tree do ANTLR
 * <p>
 * Converte cada parte em objetos de domínio e traduz SQL para modelo interno
 * </p>
 * */
public class AstSelectBuilder extends SelectBaseVisitor<AstNode> {

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
    public AstNode visitSelectStatement(SelectParser.SelectStatementContext ctx) {
        List<Expression> projection = ctx.projection()
                .column()
                .stream()
                // Nós Parse Tree (ANTLR) -> Nós AST Semântica
                .map(c -> (Expression) visit(c))
                .toList();

        TableName table = (TableName) visitTableName(ctx.tableName());
        Optional<Expression> where = ctx.whereClause() == null
                ? Optional.empty()
                : Optional.of(
                (Expression) visit(
                        ctx.whereClause().booleanExpression()
                ));


        return new SelectStatement(projection, table, where);
    }

    /**
     * Traduz uma comparação textual da Parse Tree numa operação lógica executável da AST
     * <p>
     *     Utiliza o método from de {@link ComparisonOperator} para conversão.
     * </p>
     * */
    @Override
    public AstNode visitPredicate(SelectParser.PredicateContext ctx) {
        Expression left = (Expression) visit(ctx.column());
        ComparisonOperator operator =
                ComparisonOperator.from(ctx.comparisonOperator().getText());
        Expression right = (Expression) visit(ctx.literal());

        // Operação lógica AST
        return new BinaryExpression(left, operator, right);
    }

    @Override
    public AstNode visitTableName(SelectParser.TableNameContext ctx) {
        return new TableName(ctx.IDENTIFIER().getText());
    }

    @Override
    public AstNode visitColumn(SelectParser.ColumnContext ctx) {
        return new ColumnExpression(ctx.IDENTIFIER().getText());
    }

    /**
     * Visita o contexto de um literal e retorna uma LiteralExpression.
     *
     * Converte tokens da gramática (NUMBER, STRING, NULL) em valores Java apropriado:
     * - NUMBER: Integer ou Double dependendo se tem ponto decimal
     * - STRING: String com aspas removidas e escapes processados
     * - NULL: null
     * Sem esse método não é possível verificar o tipo de dado que está entrando.
     *
     * @param ctx O contexto do literal
     * @return Uma instância de LiteralExpression contendo o valor parseado
     */
    @Override
    public AstNode visitLiteral(SelectParser.LiteralContext ctx) {
        if (ctx.NUMBER() != null) {
            return new LiteralExpression(
                    // Texto -> Double
                    Double.parseDouble(ctx.NUMBER().getText())
            );
        }

        if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            return new LiteralExpression(
                    //    "\"Nome\" -> Nome
                    text.substring(1, text.length() - 1)
            );
        }

        return new LiteralExpression(null);
    }

}
