package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCatalog implements Catalog {

    // schema.table -> TableMetadata
    private final Map<String, TableMetadata> tables = new ConcurrentHashMap<>();

    @Override
    public Optional<TableMetadata> getTable(String schema, String tableName) {
        String key = schema + "." + tableName;
        return Optional.ofNullable(tables.get(key));
    }

    @Override
    public List<TableMetadata> listTables(String schema) {
        return tables.values()
                .stream()
                .filter(t -> t.getSchemaName().equals(schema))
                .toList();
    }

    // Método auxiliar para adicionar tabelas manualmente (para testes)
    public void registerTable(TableMetadata table) {
        String key = table.getSchemaName() + "." + table.getTableName();
        tables.put(key, table);
    }
}
