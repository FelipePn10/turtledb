package com.db.turtle.b_query_engine.planner.volcano.logicalPlan;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;

import java.util.List;

/*
* A classe B_Project é responsável por reduzir a largura das tuplas.
* Ele seleciona quais colunas sobrevivem.
* */
public record B_Project (
        List<ColumnName> fields,
        LogicalPlan child
) implements LogicalPlan {
    @Override
    public List<LogicalPlan> children() {
        return List.of(child);
    }

}
