package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;

// Representação de um valor fixo escrito no SQL
public record BoundLiteral(
        Object value,
        DataType type
) implements BoundExpression {

    @Override
    public DataType getType() {
        return type;
    }
}

