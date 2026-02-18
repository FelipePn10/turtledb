package com.db.turtle.a_frontend.impl.parser.ast.expression;


import com.db.turtle.a_frontend.common.denominator.E_BinaryOperator;

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

    /**
     * Método de busca/conversão
     * <p>
     *     Para cada valor possível do enum ComparisonOperator, será coletado o símbolo da constante e
     *     comparar se é igual ao símbolo que recebeu como parâmetro. Se for igual, irá devolver a constante e encerrar.
     *     Exemplo: {@code ComparisonOperator.GE}
     * </p>
     * */
    public static ComparisonOperator from(String symbol) {
        for (ComparisonOperator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }
}

