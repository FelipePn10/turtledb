package com.db.turtle.a_frontend.impl.parser.ast.expression;


import com.db.turtle.a_frontend.common.denominator.E_BinaryOperator;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;

public enum ComparisonOperator implements E_BinaryOperator {

    EQ("="),
    GT(">"),
    GE(">="),
    LT("<"),
    LE("<="),
    NE("!=");

    private final String symbol;

    ComparisonOperator(String symbol) {
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
                    "Operator " + symbol +
                            " not supported between " + left + " and " + right
            );
        }
    }

    public static ComparisonOperator from(String symbol) {
        for (ComparisonOperator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }
}


