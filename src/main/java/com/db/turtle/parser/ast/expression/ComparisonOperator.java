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

