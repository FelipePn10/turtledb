package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder;

import com.db.turtle.a_frontend.common.denominator.B_Expression;
import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.*;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundExpression;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundSelectStmt;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundStatement;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.exception.BindExceptionApplication;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.ntm.BoundColumnRef;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.ntm.BoundTableRef;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.Catalog;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.ColumnMetadata;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.TableMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        // sem WHERE por enquanto
        return new BoundSelectStmt(
                boundProjection,
                boundTable,
                Optional.empty()
        );
    }

    /**
     * Valida a projeção (colunas do SELECT)
     */
    private List<BoundExpression> bindProjection(
            List<B_Expression> projection,
            BoundTableRef table
    ) {
        // SELECT *
        if (projection.size() == 1 && projection.get(0) instanceof StarProjection) {
            return table.metadata().getAllColumns()
                    .stream()
                    .map(col -> BoundColumnRef.from(table.getTableName(), col))
                    .collect(Collectors.toList());
        }

        List<BoundExpression> boundProjection = new ArrayList<>();

        for (B_Expression expr : projection) {
            BoundExpression bound = switch (expr) {
                case ColumnRef colRef -> bindColumnRef(colRef, table);
                default -> throw new BindExceptionApplication(
                        "Projection not yet supported: " + expr.getClass()
                );
            };
            boundProjection.add(bound);
        }

        return boundProjection;
    }

    /**
     * Valida uma referência de coluna
     */
    private BoundColumnRef bindColumnRef(ColumnRef colRef, BoundTableRef table) {
        String columnName = colRef.name().getName();

        // Busca a coluna nos metadados
        Optional<ColumnMetadata> colMeta = table.metadata()
                .getColumn(new ColumnName(columnName));

        if (colMeta.isEmpty()) {
            throw new BindExceptionApplication(
                    "Column not found: " + columnName +
                            " in tableb " + table.getTableName()
            );
        }

        return BoundColumnRef.from(table.getTableName(), colMeta.get());
    }

    /**
     * Valida uma referência de tabela
     */
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