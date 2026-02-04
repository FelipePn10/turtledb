package com.db.turtle.a_frontend.common.commands_ast.statements;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

public record AlterColumnDropStatement(
        TableName tableName,
        ColumnName columnName
) implements C_Statement {
    public AlterColumnDropStatement(
            TableName tableName,
            ColumnName columnName
    ) {
        if (tableName == null || columnName == null) {
            throw new IllegalArgumentException("Table and/or Column cannot be null");
        }

        this.tableName = tableName;
        this.columnName = columnName;
    }
}
