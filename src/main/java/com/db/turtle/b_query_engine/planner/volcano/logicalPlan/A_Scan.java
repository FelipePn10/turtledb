package com.db.turtle.b_query_engine.planner.volcano.logicalPlan;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

import java.util.List;

/*
* A_Scan é um método do tipo record que auxilia na leitura de dados de uma relação base.
* Sua responsabilidade lógica é definir a(s) tabelas de origem e opcionalmente declara quais colunas são necessárias (projection pushdown)
* */
public record A_Scan(
    TableName table,
    List<String> projection
) implements LogicalPlan {
    @Override
    public List<LogicalPlan> children() {
        return List.of();
    }
}
