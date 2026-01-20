package com.db.turtle.parser.ast;

import com.db.turtle.parser.ast.expression.Expression;

import java.util.List;

public class SelectStatement implements Statement {
    public final List<String> columns;
    public final String table;
    public final Expression where;

    public SelectStatement(
            List<String> columns,
            String table,
            Expression where
    ) {
        this.columns = columns;
        this.table = table;
        this.where = where;
    }
}
