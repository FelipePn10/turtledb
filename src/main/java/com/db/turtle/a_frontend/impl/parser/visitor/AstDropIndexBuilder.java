package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.common.commands_ast.statements.DropIndexStatement;
import com.db.turtle.a_frontend.common.denominator.A_AstNode;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.drop.index.DropIndexBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.drop.index.DropIndexParser;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.IndexName;

/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos DROP INDEX.
 */
public class AstDropIndexBuilder extends DropIndexBaseVisitor<A_AstNode> {
    @Override
    public A_AstNode visitDropIndex(DropIndexParser.DropIndexContext ctx) {
        IndexName index = buildIndexName(ctx.indexName());

        return new DropIndexStatement(index);
    }

    /**
     * Constrói um IndexName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador do indice
     * @return IndexName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private IndexName buildIndexName(DropIndexParser.IndexNameContext ctx) {
        return new IndexName(ctx.IDENTIFIER().getText());
    }
}
