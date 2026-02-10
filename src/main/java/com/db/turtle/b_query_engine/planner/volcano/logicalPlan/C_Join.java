package com.db.turtle.b_query_engine.planner.volcano.logicalPlan;

import java.util.List;

/*
* O método C_Join é responsável por combinar duas relações. Ele declara relacionamento lógico e define condições de igualdade/predicado.
* */
public record C_Join(
        LogicalPlan left,
        LogicalPlan right,
        List<D_joinCondition> on
) implements LogicalPlan {
    @Override
    public List<LogicalPlan> children() {
        return List.of(left, right);
    }
}
