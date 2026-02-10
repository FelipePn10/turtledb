package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound;

// Interface base para statements "bound"
public sealed interface BoundStatement
        permits BoundSelectStmt {
}
