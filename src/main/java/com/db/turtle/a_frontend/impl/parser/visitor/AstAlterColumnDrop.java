package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.common.commands_ast.statements.AlterColumnDropStatement;
import com.db.turtle.a_frontend.common.denominator.A_AstNode;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.drop.AlterColumnDropBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.drop.AlterColumnDropParser;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos ALTER TABLE tableName DROP COLUMN columnName
 */
public class AstAlterColumnDrop extends AlterColumnDropBaseVisitor<A_AstNode> {
    @Override
    public A_AstNode visitAlterColumnDrop(AlterColumnDropParser.AlterColumnDropContext ctx) {
        TableName table = buildTableName(ctx.tableName());
        ColumnName column = buildColumn(ctx.columnName());

        return new AlterColumnDropStatement(table, column);
    }

    /**
     * Constrói um TableName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da tabela
     * @return TableName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private TableName buildTableName(AlterColumnDropParser.TableNameContext ctx) {
        return new TableName(ctx.IDENTIFIER().getText());
    }

    /**
     * Constrói um ColumnName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da coluna
     * @return ColumnName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private ColumnName buildColumn(AlterColumnDropParser.ColumnNameContext ctx) {
        return new ColumnName(ctx.IDENTIFIER().getText());
    }
}
