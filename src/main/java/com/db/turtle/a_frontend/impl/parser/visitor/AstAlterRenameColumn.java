package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.common.commands_ast.statements.AlterRenameColumnStatement;
import com.db.turtle.a_frontend.common.denominator.A_AstNode;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.rename.AlterRenameColumnBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.rename.AlterRenameColumnParser;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnRename;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos ALTER TABLE tableName RENAME COLUMN oldNameColumn TO newNameColumn;
 */
public class AstAlterRenameColumn extends AlterRenameColumnBaseVisitor<A_AstNode> {
    @Override
    public A_AstNode visitAlterRenameColumn(AlterRenameColumnParser.AlterRenameColumnContext ctx) {
        TableName tableName = buildTableName(ctx.tableName());
        ColumnName from = buildColumnName(ctx.columnName(0));
        ColumnName to   = buildColumnName(ctx.columnName(1));

        return new AlterRenameColumnStatement(tableName,
                new ColumnRename(from, to));
    }

    /**
     * Constrói um TableName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da tabela
     * @return TableName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private TableName buildTableName(AlterRenameColumnParser.TableNameContext ctx) {
        return new TableName(ctx.IDENTIFIER().getText());
    }

    /**
     * Constrói um ColumnName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da coluna
     * @return ColumnName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private ColumnName buildColumnName(AlterRenameColumnParser.ColumnNameContext ctx) {
        return new ColumnName(ctx.IDENTIFIER().getText());
    }
}
