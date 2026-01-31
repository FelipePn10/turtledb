package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.common.commands_ast.statements.CreateIndexStatement;
import com.db.turtle.a_frontend.common.denominator.A_AstNode;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.index.CreateIndexBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.index.CreateIndexParser;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.IndexName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

import java.util.List;


/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos CREATE UNIQUE? INDEX ... ON ... (...) .
 */
public class AstCreateIndexBuilder extends CreateIndexBaseVisitor<A_AstNode> {
    @Override
    public A_AstNode visitCreateIndex(CreateIndexParser.CreateIndexContext ctx) {
        IndexName indexName = buildIndexName(ctx.indexName());
        TableName tableName = buildTableName(ctx.tableName());
        List<ColumnName> columns = ctx.columnName()
                .stream()
                .map(this::buildColumnName)
                .toList();
        return new CreateIndexStatement(indexName, tableName, columns);
    }

    @Override
    public A_AstNode visitTableName(CreateIndexParser.TableNameContext ctx) {
        return buildTableName(ctx);
    }

    @Override
    public A_AstNode visitIndexName(CreateIndexParser.IndexNameContext ctx) {
        return buildIndexName(ctx);
    }

    @Override
    public A_AstNode visitColumnName(CreateIndexParser.ColumnNameContext ctx) {
        return buildColumnName(ctx);
    }

    private TableName buildTableName(CreateIndexParser.TableNameContext ctx) {
        return new TableName(ctx.IDENTIFIER().getText());
    }

    private IndexName buildIndexName(CreateIndexParser.IndexNameContext ctx) {
        return new IndexName(ctx.IDENTIFIER().getText());
    }

    private ColumnName buildColumnName(CreateIndexParser.ColumnNameContext ctx) {
        return new ColumnName(ctx.IDENTIFIER().getText());
    }
}
