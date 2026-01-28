package com.db.turtle.parser.visitor;

import com.db.turtle.parser.antlr.statement.dml.select.SelectBaseVisitor;
import com.db.turtle.parser.antlr.statement.dml.select.SelectParser;
import com.db.turtle.parser.ast.denominator.AstNode;
import com.db.turtle.parser.ast.denominator.Expression;
import com.db.turtle.parser.ast.expression.literal.*;
import com.db.turtle.parser.ast.statements.SelectStatement;
import com.db.turtle.parser.ast.ntm.TableName;
import com.db.turtle.parser.ast.expression.*;

import java.util.List;
import java.util.Optional;


/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos SELECT.
 */
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
    public AstNode visitLiteral(SelectParser.LiteralContext ctx) {
        // NUMBER -> NumberLiteral (preserva precisão passando String para BigDecimal)
        if (ctx.NUMBER() != null) {
            return new NumberLiteral(ctx.NUMBER().getText());
        }

        // STRING -> StringLiteral (remove aspas)
        if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            String unquoted = text.substring(1, text.length() - 1);
            return new StringLiteral(unquoted);
        }

        // NULL -> NullLiteral (singleton)
        if (ctx.NULL() != null) {
            return NullLiteral.INSTANCE;
        }

        if (ctx.TRUE() != null) {
            return BooleanLiteral.TRUE;
        }
        if (ctx.FALSE() != null) {
            return BooleanLiteral.FALSE;
        }

        throw new IllegalArgumentException("Unknown literal type: " + ctx.getText());
    }
}
