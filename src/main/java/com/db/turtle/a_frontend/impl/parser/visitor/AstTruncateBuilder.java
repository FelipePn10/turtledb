package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.common.commands_ast.statements.TruncateStatement;
import com.db.turtle.a_frontend.common.denominator.A_AstNode;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.truncate.TruncateBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.truncate.TruncateParser;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos TRUNCATE TABLE x .
 */
public class AstTruncateBuilder  extends TruncateBaseVisitor<A_AstNode> {
    @Override
    public A_AstNode visitTruncate(TruncateParser.TruncateContext ctx) {
        TableName tableName = buildTableName(ctx.tableName());

        return new TruncateStatement(tableName);
    }

    private TableName buildTableName(TruncateParser.TableNameContext ctx) {
        return new TableName(ctx.IDENTIFIER().getText());
    }
}
