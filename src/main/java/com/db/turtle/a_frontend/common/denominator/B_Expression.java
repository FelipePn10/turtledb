package com.db.turtle.a_frontend.common.denominator;

import com.db.turtle.a_frontend.impl.parser.ast.expression.BinaryExpression;

/**
 * Usado para avaliar um valor
 * <p>
 *     Não existem sozinhos, precisa sempre de um contexto e são avaliados num statement.
 *     Exemplo: {@link BinaryExpression}
 * </p>
 * */
public interface B_Expression extends A_AstNode {
}
