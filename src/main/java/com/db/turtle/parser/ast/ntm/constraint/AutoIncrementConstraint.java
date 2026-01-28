package com.db.turtle.parser.ast.ntm.constraint;

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
