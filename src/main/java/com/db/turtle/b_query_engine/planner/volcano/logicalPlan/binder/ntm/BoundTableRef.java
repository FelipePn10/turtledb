package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.ntm;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.TableMetadata;

// Tabela validada
public record BoundTableRef(
        TableMetadata metadata,
        String alias
) {
    public TableName getTableName() {
        return metadata.getTableName();
    }
}