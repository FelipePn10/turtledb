package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.operator;

import com.db.turtle.a_frontend.common.denominator.E_BinaryOperator;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.exception.BindExceptionApplication;

/*
 * Representa uma regra semântica de linguagem. É a definição comportamental AND, OR ou NOT.
 * Encapsula a regra de validação, a regra de inferência de tipo e a identidade do operador.
 * */
public enum LogicalExpressions implements E_BinaryOperator {
    AND("AND"){
        @Override
        public void validate(DataType left, DataType right) {
            require(left, right);
        }
    },
    OR("OR"){
        @Override
        public void validate(DataType left, DataType right) {
            require(left, right);
        }
    };

    private final String symbol;

    LogicalExpressions(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

    public abstract void validate(DataType left, DataType right);

    protected static void require(DataType left, DataType right) {
        if (!left.isBoolean() || !right.isBoolean()) {
            throw new BindExceptionApplication(
                    "Logical operators require boolean operands"
            );
        }
    }
}
