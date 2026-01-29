package com.db.turtle.a_frontend.impl.parser.ast.ntm.constraint;

public class AutoIncrementConstraint extends ColumnConstraint{
    public AutoIncrementConstraint() {
        super(ConstraintType.AUTO_INCREMENT);
    }

    @Override
    public String toSql() {
        return "AUTO_INCREMENT";
    }

    @Override
    public boolean equals(Object o) {
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return getType().hashCode();
    }
}
