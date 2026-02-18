package com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.ntm;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundExpression;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.ColumnMetadata;

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
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}