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
        if (columns.isEmpty()) {
            throw new RuntimeException("Index must reference at least one column");
        }
        boolean isUnique = ctx.UNIQUE() != null;
        return new CreateIndexStatement(indexName, tableName, columns, isUnique);
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
