package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound;

import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.ntm.BoundTableRef;

import java.util.List;
import java.util.Optional;

// SELECT validado (versão simplificada)
public record BoundSelectStmt(
        List<BoundExpression> projection,
        BoundTableRef from,
        Optional<BoundExpression> where
) implements BoundStatement {
}


// De projection = [ColumnRef("name")]
// Para projection = [BoundColumnRef("users", "name", VARCHAR)]