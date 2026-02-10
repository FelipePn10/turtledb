package com.db.turtle.b_query_engine.planner.volcano.logicalPlan;

import java.util.List;

// Representa uma operação relacional.
public sealed interface LogicalPlan
        permits A_Scan, B_Project, C_Join {

   List<LogicalPlan> children();
}
