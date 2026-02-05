// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/alter/column/rename/AlterRenameColumn.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.rename;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlterRenameColumnParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlterRenameColumnVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlterRenameColumnParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AlterRenameColumnParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterRenameColumnParser#alterRenameColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterRenameColumn(AlterRenameColumnParser.AlterRenameColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterRenameColumnParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(AlterRenameColumnParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterRenameColumnParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(AlterRenameColumnParser.ColumnNameContext ctx);
}