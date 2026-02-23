package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.ntm;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundExpression;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.ColumnMetadata;

import java.util.Objects;

/*
* Representa uma coluna validada gramaticamente e semanticamente
* */
public record BoundColumnRef(
        TableName tableName,
        ColumnName columnName,
        DataType type,
        int columnPosition
) implements BoundExpression {

    public static BoundColumnRef from(
            TableName tableName,
            ColumnMetadata col) {
        return new BoundColumnRef(
                tableName,
                col.getName(),
                col.getType(),
                col.getPosition()
        );
    }

    @Override
    public DataType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoundColumnRef other)) return false;
        return columnPosition == other.columnPosition
                && Objects.equals(tableName, other.tableName)
                && Objects.equals(columnName, other.columnName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableName, columnName, columnPosition);
    }

    @Override
    public String toString() {
        return tableName + "." + columnName + " : " + type;
    }
}