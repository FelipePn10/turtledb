package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.common.commands_ast.statements.DropTableStatement;
import com.db.turtle.a_frontend.common.denominator.A_AstNode;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.table.CreateTableParser;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.drop.table.DropTableBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.drop.table.DropTableParser;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos DROP TABLE.
 */
public class AstDropTableVisitor extends DropTableBaseVisitor<A_AstNode> {
    @Override
    public A_AstNode visitDropTable(DropTableParser.DropTableContext ctx) {
        TableName table = buildTableName(ctx.tableName());

        return new DropTableStatement(table);
    }

    /**
     * Constrói um TableName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da tabela
     * @return TableName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private TableName buildTableName(DropTableParser.TableNameContext ctx) {
        return new TableName(ctx.IDENTIFIER().getText());
    }
}
