package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.operator;

import com.db.turtle.a_frontend.common.denominator.E_BinaryOperator;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DecimalType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.IntegerType;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.exception.BindExceptionApplication;


/*
* Representa uma regra semântica de linguagem. É a definição comportamental do operador.
* Encapsula a regra de validação, a regra de inferência de tipo e a identidade do operador.
* */
public enum ArithmeticOperator implements E_BinaryOperator {

    ADD("+") {
        @Override
        public void validate(DataType left, DataType right) {
            requireNumeric(left, right);
        }

        @Override
        public DataType resolveResultType(DataType left, DataType right) {
            return TypeResolver.resolveArithmeticResult(left, right);
        }
    },

    SUB("-") {
        @Override
        public void validate(DataType left, DataType right) {
            requireNumeric(left, right);
        }

        @Override
        public DataType resolveResultType(DataType left, DataType right) {
            return TypeResolver.resolveArithmeticResult(left, right);
        }
    },

    MUL("*") {
        @Override
        public void validate(DataType left, DataType right) {
            requireNumeric(left, right);
        }

        @Override
        public DataType resolveResultType(DataType left, DataType right) {
            return TypeResolver.resolveArithmeticResult(left, right);
        }
    },

    DIV("/") {
        @Override
        public void validate(DataType left, DataType right) {
            requireNumeric(left, right);
        }

        @Override
        public DataType resolveResultType(DataType left, DataType right) {

            DecimalType d1 = toDecimal(left);
            DecimalType d2 = toDecimal(right);

            int p1 = d1.getPrecision();
            int s1 = d1.getScale();

            int p2 = d2.getPrecision();
            int s2 = d2.getScale();

            int scale = Math.max(6, s1 + p2 + 1);
            int precision = (p1 - s1) + s2 + scale;

            return new DecimalType(precision, scale);
        }

    },

    MOD("%") {
        @Override
        public void validate(DataType left, DataType right) {

            if (!(left instanceof IntegerType) ||
                    !(right instanceof IntegerType)) {

                throw new BindExceptionApplication(
                        "Operator '%' requires integer operands"
                );
            }
        }

        @Override
        public DataType resolveResultType(DataType left, DataType right) {
            return new IntegerType();
        }
    };

    private final String symbol;

    ArithmeticOperator(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

    public abstract DataType resolveResultType(DataType left, DataType right);

    protected static void requireNumeric(DataType left, DataType right) {
        if (!left.isNumeric() || !right.isNumeric()) {
            throw new BindExceptionApplication(
                    "Arithmetic operators require numeric operands"
            );
        }
    }

    private static DecimalType toDecimal(DataType type) {

        if (type instanceof DecimalType d) {
            return d;
        }

        if (type instanceof IntegerType) {
            // INTEGER tratado como DECIMAL(p, 0)
            // Assumi precisão padrão 10
            return new DecimalType(10, 0);
        }

        throw new BindExceptionApplication(
                "Unsupported numeric type for division"
        );
    }


    public static ArithmeticOperator fromSymbol(String symbol) {
        for (ArithmeticOperator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }

        throw new BindExceptionApplication(
                "Unsupported arithmetic operator: " + symbol
        );
    }
}