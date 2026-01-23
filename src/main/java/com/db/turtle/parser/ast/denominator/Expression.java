package com.db.turtle.parser.ast.denominator;

import com.db.turtle.parser.ast.expression.BinaryExpression;

/**
 * Usado para avaliar um valor
 * <p>
 *     Não existem sozinhos, precisa sempre de um contexto e são avaliados num statement.
 *     Exemplo: {@link BinaryExpression}
 * </p>
 * */
public interface Expression extends AstNode {
}
