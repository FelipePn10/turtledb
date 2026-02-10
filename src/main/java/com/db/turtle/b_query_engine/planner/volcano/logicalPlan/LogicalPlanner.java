package com.db.turtle.b_query_engine.planner.volcano.logicalPlan;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.JoinStmt;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.SelectStmt;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableRef;

import java.util.List;

//public LogicalPlan toPlan(C_Statement stmt) {
//
//    return switch (stmt) {
//
//        case TableRef t ->
//                new A_Scan(
//                        resolveTable(t),
//                        List.of()
//                );
//
//        case JoinStmt j ->
//                new C_Join(
//                        toPlan(j.left()),
//                        toPlan(j.right()),
//                        bindJoinConditions(j.conditions())
//                );
//
//        case SelectStmt s ->
//                new B_Project(
//                        bindProjection(s.projection()),
//                        toPlan(s.from())
//                );
//    };
//}
