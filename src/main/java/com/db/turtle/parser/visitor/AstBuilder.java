package com.db.turtle.parser.visitor;

import com.db.turtle.parser.antlr.SqlBaseVisitor;
import com.db.turtle.parser.antlr.SqlParser;
import com.db.turtle.parser.ast.AstNode;
import com.db.turtle.parser.ast.SelectStatement;
import com.db.turtle.parser.ast.expression.BinaryExpression;
import com.db.turtle.parser.ast.expression.ColumnExpression;
import com.db.turtle.parser.ast.expression.Expression;
import com.db.turtle.parser.ast.expression.LiteralExpression;

import java.util.List;


/**
 * Visita a parse tree do ANTLR
 * Converte cada parte em objetos de domínio
 * Traduz SQL para modelo interno
 * @author Felipe Panosso
 * */
public class AstBuilder extends SqlBaseVisitor<AstNode> {

    /**
     * Este método é chamado quando o parser encontra uma regra como:
     * SELECT columnList FROM tableName whereClause?
     * Sua função é extrair dados do contexto, criar um SelectStatement e retornar este nó AST
     *
     * @author Felipe Panosso
     * */
    @Override
    public AstNode visitSelectStmt(SqlParser.SelectStmtContext ctx) {
        List<String> columns = ctx.columnList().IDENTIFIER()
                .stream()
                .map(t -> t.getText())
                .toList();

        String table = ctx.IDENTIFIER().getText();
        Expression where = null;

        if (ctx.whereClause() != null) {
            where = (Expression) visit(ctx.whereClause().expression());
        }

        return new SelectStatement(columns, table, where);
    }

    @Override
    public AstNode visitExpression(SqlParser.ExpressionContext ctx) {
        Expression left = new ColumnExpression(ctx.IDENTIFIER().getText());
        String operator = ctx.operator().getText();
        Expression right = new LiteralExpression(ctx.IDENTIFIER().getText());

        return new BinaryExpression(left, operator, right);
    }
}
