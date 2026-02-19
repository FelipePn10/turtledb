package com.db.turtle.a_frontend.impl.parser.ast.expression;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DecimalType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DoubleType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.IntegerType;


public final class ComparisonTypeValidator {

    private ComparisonTypeValidator() {}

    public static void validate(
            DataType left,
            DataType right,
            ComparisonOperator operator
    ) {

        if (left == null || right == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        if (left.equals(right)) {
            return;
        }

        if (isNumeric(left) && isNumeric(right)) {
            return;
        }

        throw new IllegalArgumentException(
                "Operator " + operator.symbol() +
                        " not supported between types " +
                        left + " and " + right
        );
    }

    private static boolean isNumeric(DataType type) {
        return switch (type) {
            case IntegerType ignored -> true;
            case DecimalType ignored -> true;
            case DoubleType ignored -> true;
            default -> false;
        };
    }
}
