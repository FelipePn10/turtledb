package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.SelectStmt;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableRef;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundSelectStmt;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundStatement;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.exception.BindExceptionApplication;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.ntm.BoundTableRef;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.Catalog;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.TableMetadata;

import java.util.List;
import java.util.Optional;

public class Binder {
    private final Catalog catalog;
    public Binder(Catalog catalog) {
        this.catalog = catalog;
    }

    /*
    * Valida o statement e retorna versão "bound"
    * */
    public BoundStatement bind(C_Statement statement) {
        return switch (statement) {
            case SelectStmt selectStmt -> bindSelect((SelectStmt) statement);
            // futuros casos
            default -> throw new BindExceptionApplication("Statement not yet supported." + statement.getClass());
        };
    }

    private BoundStatement bindSelect(SelectStmt select) {
        // Valida a tabela do from
        TableRef tableRef = (TableRef) select.from();

        // SELECT * FROM usuarios → schema = "public" (padrão)
        // SELECT * FROM admin.usuarios → schema = "admin"
        String schema = tableRef.schema().orElse("public");
        String tableName = tableRef.name().getName();

        // Busca no catálogo
        Optional<TableMetadata> tableMeta = catalog.getTable(schema, tableName);

        if (tableMeta.isEmpty()) {
            throw new BindExceptionApplication(
                    "Table " + tableName + " not found."
            );
        }

        // Por enquanto, só retorna a tabela validada
        BoundTableRef boundTable = new BoundTableRef(
                tableMeta.get(),
                tableRef.alias().orElse(tableName) // alias ou nome da tabela
        );

        // validar colunas da projeção
        // validar WHERE clause

        return new BoundSelectStmt(
                List.of(), // por quanto projeção vazia
                boundTable,
                Optional.empty() // WHERE também vazio
        );
    }
}
