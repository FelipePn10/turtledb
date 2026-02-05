// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/alter/table/rename/AlterRenameTable.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.table.rename;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlterRenameTableParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlterRenameTableVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlterRenameTableParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AlterRenameTableParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterRenameTableParser#alterRenameTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterRenameTable(AlterRenameTableParser.AlterRenameTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterRenameTableParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(AlterRenameTableParser.TableNameContext ctx);
}