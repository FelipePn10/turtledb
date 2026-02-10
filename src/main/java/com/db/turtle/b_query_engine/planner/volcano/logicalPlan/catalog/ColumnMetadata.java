package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;

public class ColumnMetadata {
    private ColumnName name;
    private final DataType type;
    private final boolean nullable;
    private final int position; // posição na tabela (0, 1, 2...)

    public ColumnMetadata(ColumnName name, DataType type, boolean nullable, int position) {
        this.name = name;
        this.type = type;
        this.nullable = nullable;
        this.position = position;
    }

    // getters...

    @Override
    public String toString() {
        return name + " " + type + (nullable ? "" : " NOT NULL");
    }
}