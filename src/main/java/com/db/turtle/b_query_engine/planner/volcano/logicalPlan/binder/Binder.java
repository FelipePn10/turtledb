package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder;

import com.db.turtle.a_frontend.common.denominator.B_Expression;
import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.Literal;
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
    private List<BoundExpression> bindProjection(
            List<B_Expression> projection,
            BoundTableRef table
    ) {
        if (projection.size() == 1 && projection.getFirst() instanceof StarProjection) {
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
                        "Projeção não suportada: " + expr.getClass()
                );
            };
            boundProjection.add(bound);
        }

        return boundProjection;
    }

    private BoundColumnRef bindColumnRef(ColumnRef colRef, BoundTableRef table) {
        String columnName = colRef.name().getName();

        Optional<ColumnMetadata> colMeta = table.metadata()
                .getColumn(new ColumnName(columnName));

        if (colMeta.isEmpty()) {
            throw new BindExceptionApplication(
                    "Coluna não encontrada: " + columnName +
                            " na tabela " + table.getTableName()
            );
        }

        return BoundColumnRef.from(table.getTableName(), colMeta.get());
    }

    private Optional<BoundExpression> bindWhere(
            Optional<B_Expression> where,
            BoundTableRef table
    ) {
        if (where.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(bindExpression(where.getFirst(), table));
    }

    private BoundExpression bindExpression(B_Expression expr, BoundTableRef table) {
        return switch (expr) {
            case ColumnRef col -> bindColumnRef(col, table);
            case BinaryOp op -> bindBinaryOp(op, table);
            case Literal lit -> bindLiteral(lit, table);
            default -> throw new BindExceptionApplication(
                    "Expression not yet supported: " + expr.getClass()
            );
        };
    }

    private BoundBinaryOp bindBinaryOp(BinaryOP op, BoundTableRef) {
        BoundExpression left = bindExpression(op.left(), table);
        BoundExpression right = bindExpression(op.right(), table);

        validateTypeCompatibility(left, right, op.operator());

        return new BoundBinaryOp(left, op.operator(), right);
    }


    private BoundStatement bindSelect(SelectStmt select) {
        // Valida a tabela do FROM
        BoundTableRef boundTable = switch (select.from()) {
            case TableRef tableRef -> bindTableRef(tableRef);
            case JoinStmt joinStmt -> throw new BindExceptionApplication(
                    "JOIN ainda não implementado"
            );

            default -> throw new BindExceptionApplication(
                    "FROM not support: " + select.from().getClass()
            );
        };

        List<BoundExpression> boundProjection =
                bindProjection(select.projection(), boundTable);

        return new BoundSelectStmt(
                boundProjection,
                boundTable,
                Optional.empty()     // WHERE vazio por enquanto
        );
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