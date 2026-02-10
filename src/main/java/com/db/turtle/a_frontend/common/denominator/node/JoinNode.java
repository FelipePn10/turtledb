package com.db.turtle.a_frontend.common.denominator.node;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.D_joinCondition;

import java.util.List;

public record JoinNode(
        C_Statement left,
        C_Statement right,
        List<D_joinCondition> on
) implements C_Statement {}


// Future JoinConditionAst










