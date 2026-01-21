package com.db.turtle.parser.visitor;

import com.db.turtle.parser.antlr.statement.SelectBaseVisitor;
import com.db.turtle.parser.antlr.statement.SelectParser;
import com.db.turtle.parser.ast.denominator.AstNode;
import com.db.turtle.parser.ast.statements.SelectStatement;
import com.db.turtle.parser.ast.ntm.TableName;
import com.db.turtle.parser.ast.expression.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Optional;


/**
 * Visita a parse tree do ANTLR
 * <p>
 * Converte cada parte em objetos de domínio e traduz SQL para modelo interno
 * </p>
 *
 * @author Felipe Panosso
 * */
public class AstBuilder extends SelectBaseVisitor<AstNode> {

    /**
     * Transforma o contexto de uma regra de seleção da árvore de parsing em um nó da AST.
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

    @Override
    public AstNode visitPredicate(SelectParser.PredicateContext ctx) {
        Expression left = (Expression) visit(ctx.column());
        ComparisonOperator operator =
                ComparisonOperator.from(ctx.comparisonOperator().getText());
        Expression right = (Expression) visit(ctx.literal());

        return new BinaryExpression(left, operator, right);
    }

    @Override
    public AstNode visitTableName(SelectParser.TableNameContext ctx) {
        return new TableName(ctx.IDENTIFIER().getText());
    }
}
