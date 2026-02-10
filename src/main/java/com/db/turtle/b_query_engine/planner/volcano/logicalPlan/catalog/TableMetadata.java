package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

import java.util.List;
import java.util.Optional;

public class TableMetadata {
    private final String schemaName;  // "public", "dbo", etc
    private final TableName tableName;   // "usuarios"
    private final List<ColumnMetadata> columns;

    public TableMetadata(String schemaName, TableName tableName, List<ColumnMetadata> columns) {
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.columns = List.copyOf(columns); // imutável
    }

    /**
     * Busca uma coluna pelo nome (case-insensitive)
     */
    public Optional<ColumnMetadata> getColumn(ColumnName columnName) {
        return columns.stream()
                .filter(col -> col.name().equalsIgnoreCase(columnName))
                .findFirst();
    }

    /**
     * Retorna todas as colunas
     */
    public List<ColumnMetadata> getAllColumns() {
        return columns;
    }

    public String getFullName() {
        return schemaName + "." + tableName;
    }

    // getters...
}
