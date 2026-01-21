package com.db.turtle.parser.ast.expression;


public enum ComparisonOperator {
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

    public static ComparisonOperator from(String symbol) {
        for (ComparisonOperator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }
}

