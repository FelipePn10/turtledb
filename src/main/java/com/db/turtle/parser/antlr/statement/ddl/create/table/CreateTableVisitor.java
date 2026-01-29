// Generated from src/main/java/com/db/turtle/parser/antlr/statement/ddl/create/table/CreateTable.g4 by ANTLR 4.13.1

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
	 * Visit a parse tree produced by the {@code varcharType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarcharType(CreateTableParser.VarcharTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharType(CreateTableParser.CharTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(CreateTableParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerType(CreateTableParser.IntegerTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bigintType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBigintType(CreateTableParser.BigintTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalType(CreateTableParser.DecimalTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(CreateTableParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleType(CreateTableParser.DoubleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateType(CreateTableParser.DateTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code datetimeType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatetimeType(CreateTableParser.DatetimeTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampType(CreateTableParser.TimestampTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextType(CreateTableParser.TextTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link CreateTableParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(CreateTableParser.BooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CreateTableParser#columnConstraints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnConstraints(CreateTableParser.ColumnConstraintsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notNullConstraint}
	 * labeled alternative in {@link CreateTableParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNullConstraint(CreateTableParser.NotNullConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullConstraint}
	 * labeled alternative in {@link CreateTableParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullConstraint(CreateTableParser.NullConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyConstraint}
	 * labeled alternative in {@link CreateTableParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyConstraint(CreateTableParser.PrimaryKeyConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueConstraint}
	 * labeled alternative in {@link CreateTableParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueConstraint(CreateTableParser.UniqueConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code autoIncrementConstraint}
	 * labeled alternative in {@link CreateTableParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoIncrementConstraint(CreateTableParser.AutoIncrementConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultConstraint}
	 * labeled alternative in {@link CreateTableParser#columnConstraint}.
/**
 * @param ctx the parse tree
 * @return the visitor result
 */
T visitDefaultConstraint(CreateTableParser.DefaultConstraintContext ctx);

/**
 * Visit a parse tree produced by the {@code numberDefault}
 * labeled alternative in {@link CreateTableParser#defaultValue}.
 * @param ctx the parse tree
 * @return the visitor result
 */
T visitNumberDefault(CreateTableParser.NumberDefaultContext ctx);

/**
 * Visit a parse tree produced by the {@code stringDefault}
 * labeled alternative in {@link CreateTableParser#defaultValue}.
 * @param ctx the parse tree
 * @return the visitor result
 */
T visitStringDefault(CreateTableParser.StringDefaultContext ctx);

/**
 * Visit a parse tree produced by the {@code nullDefault}
 * labeled alternative in {@link CreateTableParser#defaultValue}.
 * @param ctx the parse tree
 * @return the visitor result
 */
T visitNullDefault(CreateTableParser.NullDefaultContext ctx);

/**
 * Visit a parse tree produced by the {@code trueDefault}
 * labeled alternative in {@link CreateTableParser#defaultValue}.
 * @param ctx the parse tree
 * @return the visitor result
 */
T visitTrueDefault(CreateTableParser.TrueDefaultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseDefault}
	 * labeled alternative in {@link CreateTableParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseDefault(CreateTableParser.FalseDefaultContext ctx);
}