package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.select.SelectBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.select.SelectParser;
import com.db.turtle.a_frontend.impl.parser.ast.denominator.AstNode;
import com.db.turtle.a_frontend.impl.parser.ast.denominator.Expression;
import com.db.turtle.a_frontend.impl.parser.ast.expression.BinaryExpression;
import com.db.turtle.a_frontend.impl.parser.ast.expression.ColumnExpression;
import com.db.turtle.a_frontend.impl.parser.ast.expression.ComparisonOperator;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.BooleanLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.NullLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.NumberLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.StringLiteral;
import com.db.turtle.parser.ast.expression.literal.*;
import com.db.turtle.a_frontend.impl.parser.ast.statements.SelectStatement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.parser.ast.expression.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigDecimal;
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