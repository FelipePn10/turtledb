// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/create/index/CreateIndex.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.index;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CreateIndexParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CreateIndexVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CreateIndexParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CreateIndexParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateIndexParser#createIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateIndex(CreateIndexParser.CreateIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateIndexParser#indexName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexName(CreateIndexParser.IndexNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateIndexParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(CreateIndexParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateIndexParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(CreateIndexParser.ColumnNameContext ctx);
}