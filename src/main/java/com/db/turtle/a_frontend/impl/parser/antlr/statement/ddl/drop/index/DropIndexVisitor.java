// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/drop/index/DropIndex.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.drop.index;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DropIndexParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DropIndexVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DropIndexParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DropIndexParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DropIndexParser#dropIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropIndex(DropIndexParser.DropIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link DropIndexParser#indexName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexName(DropIndexParser.IndexNameContext ctx);
}