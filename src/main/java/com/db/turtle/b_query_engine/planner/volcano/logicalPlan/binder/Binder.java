package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder;

import com.db.turtle.a_frontend.common.denominator.B_Expression;
import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.common.denominator.E_BinaryOperator;
import com.db.turtle.a_frontend.impl.parser.ast.expression.BinaryExpression;
import com.db.turtle.a_frontend.impl.parser.ast.expression.ComparisonOperator;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.*;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.BooleanType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundBinaryExpression;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundExpression;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundSelectStmt;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundStatement;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.exception.BindExceptionApplication;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.ntm.BoundColumnRef;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.ntm.BoundTableRef;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.operator.ArithmeticOperator;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.Catalog;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.ColumnMetadata;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.TableMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
* Responsável por produzir uma representação semântica tipada da query para o planejamento lógico
* */
public class Binder {
    private final Catalog catalog;

    public Binder(Catalog catalog) {
        this.catalog = catalog;
    }

    /**
     * Valida o statement e retorna versão "bound"
     */
    public BoundStatement bind(C_Statement statement) {
        return switch (statement) {
            case SelectStmt selectStmt -> bindSelect(selectStmt);
            default -> throw new BindExceptionApplication(
                    "Statement not yet supported: " + statement.getClass()
            );
        };
    }

    private BoundStatement bindSelect(SelectStmt select) {
        BoundTableRef boundTable = switch (select.from()) {
            case TableRef tableRef -> bindTableRef(tableRef);
            case JoinStmt joinStmt -> throw new BindExceptionApplication(
                    "JOIN not implemented"
            );
            default -> throw new BindExceptionApplication(
                    "FROM not yet supported: " + select.from().getClass()
            );
        };

        List<BoundExpression> boundProjection =
                bindProjection(select.projection(), boundTable);

        BoundExpression boundWhere = null;

        if (select.where().isPresent()) {
            boundWhere = bindExpression(
                    select.where().get(),
                    boundTable
            );

            if (!(boundWhere.getType() instanceof BooleanType)) {
                throw new BindExceptionApplication(
                        "WHERE clause must evaluate to BOOLEAN"
                );
            }
        }

        return new BoundSelectStmt(
                boundProjection,
                boundTable,
                Optional.ofNullable(boundWhere)
        );
    }

    /**
     * Valida a projeção
     */
    private List<BoundExpression> bindProjection(
            List<B_Expression> projection,
            BoundTableRef table
    ) {
        // SELECT *
        if (projection.size() == 1 && projection.getFirst() instanceof StarProjection) {
            return table.metadata().getAllColumns()
                    .stream()
                    .map(col ->
                            BoundColumnRef.from(table.getTableName(), col))
                    .collect(Collectors.toList());
        }

        List<BoundExpression> boundProjection = new ArrayList<>();

        for (B_Expression expr : projection) {
            BoundExpression bound =
                    bindExpression(expr, table);

            boundProjection.add(bound);
        }

        return boundProjection;
    }

    /*
    * Método central de binding de expressões.
    * bindExpression realiza um wal recursivo na árvore, sendo um tree visitor implícito via pattern matching suportando profundidade arbitrária de expressão, veja:
    * price * (quantity + tax) / discount
    */
    private BoundExpression bindExpression(
            B_Expression expr,
            BoundTableRef table
    ) {
        return switch (expr) {

            case ColumnRef colRef ->
                    bindColumnRef(colRef, table);

            case BinaryExpression binExpr -> {
                BoundExpression left =
                        bindExpression(binExpr.left, table);

                BoundExpression right =
                        bindExpression(binExpr.right, table);

                yield bindBinaryOperation(
                        left,
                        right,
                        binExpr.operator
                );
            }

            default -> throw new BindExceptionApplication(
                    "Expression not supported: " + expr.getClass()
            );
        };
    }

    /**
     * Valida operações aritméticas para comandos SELECT.
     */
    private BoundExpression bindBinaryOperation(
            BoundExpression left,
            BoundExpression right,
            E_BinaryOperator symbol
    ) {

        if (symbol instanceof ArithmeticOperator arithmetic) {

            arithmetic.validate(left.getType(), right.getType());

            DataType resultType =
                    arithmetic.resolveResultType(left.getType(), right.getType());

            return new BoundBinaryExpression(
                    left,
                    right,
                    symbol,
                    resultType
            );
        }

        if (symbol instanceof ComparisonOperator comparison) {

            comparison.validate(left.getType(), right.getType());

            DataType resultType = BooleanType.INSTANCE;

            return new BoundBinaryExpression(
                    left,
                    right,
                    symbol,
                    resultType
            );
        }

        throw new BindExceptionApplication(
                "Unsupported operator: " + symbol
        );
    }

    /**
     * Valida uma referência de coluna
     */
    private BoundColumnRef bindColumnRef(ColumnRef colRef, BoundTableRef table) {
        String columnName = colRef.name().getName();

        Optional<ColumnMetadata> colMeta = table.metadata()
                .getColumn(new ColumnName(columnName));

        if (colMeta.isEmpty()) {
            throw new BindExceptionApplication(
                    "Column not found: " + columnName +
                            " in table " + table.getTableName()
            );
        }

        return BoundColumnRef.from(table.getTableName(), colMeta.get());
    }

    private BoundTableRef bindTableRef(TableRef tableRef) {
        String schema = tableRef.schema().orElse("public");
        String tableName = tableRef.name().getName();

        Optional<TableMetadata> tableMeta = catalog.getTable(schema, tableName);

        if (tableMeta.isEmpty()) {
            throw new BindExceptionApplication(
                    "Table not found: " + schema + "." + tableName
            );
        }

        return new BoundTableRef(
                tableMeta.get(),
                tableRef.alias().orElse(tableName)
        );
    }
}
