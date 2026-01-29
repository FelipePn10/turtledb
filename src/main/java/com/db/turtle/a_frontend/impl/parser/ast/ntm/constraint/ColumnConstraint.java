package com.db.turtle.a_frontend.impl.parser.ast.ntm.constraint;

import com.db.turtle.a_frontend.common.denominator.A_AstNode;

/**
 * Representação do tipo da constraint de uma determinada coluna.
 * Utiliza {@code ConstraintType} para saber o tipo.
 *
 * */
public abstract class ColumnConstraint implements A_AstNode {
    private final ConstraintType type;

    protected ColumnConstraint(ConstraintType type) {
        this.type = type;
    }

    public ConstraintType getType() {
        return type;
    }

    public abstract String toSql();

    @Override
    public String toString() {
        return toSql();
    }
}
