package com.db.turtle.b_query_engine.planner.volcano.logicalPlan;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;

public record D_joinCondition(
     ColumnName left,
     ColumnName right
) {}
