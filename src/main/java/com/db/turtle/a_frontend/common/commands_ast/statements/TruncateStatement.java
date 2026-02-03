package com.db.turtle.a_frontend.common.commands_ast.statements;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

public record TruncateStatement(
        TableName tableName
) implements C_Statement {
    public TruncateStatement(TableName tableName){
        this.tableName = tableName;
    }

    public TableName getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        return "TRUNCATE TABLE " + tableName;
    }

}
