// Generated from src/main/java/com/db/turtle/parser/antlr/statement/dml/insert/Insert.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.insert;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InsertParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InsertVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InsertParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(InsertParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link InsertParser#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(InsertParser.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link InsertParser#columnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnList(InsertParser.ColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link InsertParser#valueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueList(InsertParser.ValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link InsertParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(InsertParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link InsertParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(InsertParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link InsertParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(InsertParser.LiteralContext ctx);
}