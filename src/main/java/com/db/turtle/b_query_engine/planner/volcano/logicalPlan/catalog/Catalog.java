package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog;

import java.util.List;
import java.util.Optional;

public interface Catalog {
    /**
     * Busca metadados de uma tabela
     * @return Optional.empty() se não existir
     */
    Optional<TableMetadata> getTable(String schemaName, String tableName);

    /**
     * Lista todas as tabelas de um schema
     */
    List<TableMetadata> listTables(String schemaName);
}
