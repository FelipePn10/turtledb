// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/truncate/Truncate.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.truncate;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TruncateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TruncateVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TruncateParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TruncateParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TruncateParser#truncate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruncate(TruncateParser.TruncateContext ctx);
	/**
	 * Visit a parse tree produced by {@link TruncateParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(TruncateParser.TableNameContext ctx);
}