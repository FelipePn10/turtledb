package com.db.turtle.parser.ast.ntm.constraint;

/**
 * Representação do tipo da constraint de uma determinada coluna.
 * Utiliza {@code ConstraintType} para saber o tipo.
 *
 * */
public abstract class ColumnConstraint {
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
