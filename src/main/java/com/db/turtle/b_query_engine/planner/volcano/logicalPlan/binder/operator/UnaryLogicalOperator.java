package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.operator;

import com.db.turtle.a_frontend.common.denominator.E_BinaryOperator;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.exception.BindExceptionApplication;

public enum UnaryLogicalOperator implements E_BinaryOperator {

    NOT("NOT") {
        @Override
        public void validate(DataType operand) {
            if (!operand.isBoolean()) {
                throw new BindExceptionApplication(
                        "NOT requires boolean operand"
                );
            }
        }
    };
    private final String symbol;

    UnaryLogicalOperator(String symbol) {
        this.symbol = symbol;
    }
    public String symbol() {
        return symbol;
    }

    public abstract void validate(DataType operand);
}
