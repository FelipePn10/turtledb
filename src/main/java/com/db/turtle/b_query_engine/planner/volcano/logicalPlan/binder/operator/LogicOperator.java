package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.operator;

import com.db.turtle.a_frontend.common.denominator.E_BinaryOperator;
import com.db.turtle.a_frontend.impl.parser.ast.expression.ComparisonOperator;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;

public enum LogicOperator implements E_BinaryOperator {
    AND("AND"),
    OR("OR"),
    NOT("NOT");

    private final String symbol;

    LogicOperator(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

    @Override
    public void validate(DataType left, DataType right) {

        if (left == null || right == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        if (!left.isComparableWith(right)) {
            throw new IllegalArgumentException(
                    "Operator " +
                            " not supported between " + left + " and " + right
            );
        }
    }
    public static LogicOperator from(String symbol) {
        for (LogicOperator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }
}
