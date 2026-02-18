package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound;

import com.db.turtle.a_frontend.common.denominator.E_BinaryOperator;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;

// Representação de uma expressão binária já validada semanticamente pelo Binder.
public record BoundBinaryExpression(
        BoundExpression left,
        BoundExpression right,
        E_BinaryOperator symbol,
        DataType type
) implements BoundExpression {

    @Override
    public DataType getType() {
        return type;
    }
}


// SELECT price * 10:
//        (*)
//       /   \
//    price   10
// type é para representação lógico do resultado.

