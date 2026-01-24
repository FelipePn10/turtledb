// Generated from src/main/java/com/db/turtle/parser/antlr/ddl/create/table/CreateTable.g4 by ANTLR 4.13.1

package com.db.turtle.parser.antlr.statement.ddl.create.table;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CreateTableParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CreateTableVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#statementddl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementddl(CreateTableParser.StatementddlContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#createTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTable(CreateTableParser.CreateTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#columnDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDef(CreateTableParser.ColumnDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(CreateTableParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(CreateTableParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(CreateTableParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#columnConstraints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnConstraints(CreateTableParser.ColumnConstraintsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnConstraint(CreateTableParser.ColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(CreateTableParser.DefaultValueContext ctx);
}