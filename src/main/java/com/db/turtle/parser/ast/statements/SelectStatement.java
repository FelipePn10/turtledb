package com.db.turtle.parser.ast.statements;

import com.db.turtle.parser.ast.denominator.Statement;
import com.db.turtle.parser.ast.denominator.Expression;
import com.db.turtle.parser.ast.ntm.TableName;

import java.util.List;
import java.util.Optional;

public final class SelectStatement implements Statement {

    private final List<Expression> projection;
    private final TableName table;
    private final Optional<Expression> where;

    public SelectStatement(
            List<Expression> projection,
            TableName table,
            Optional<Expression> where
    ) {
        this.projection = projection;
        this.table = table;
        this.where = where;
    }

    public List<Expression> getProjection() {
        return projection;
    }

    public TableName getTable() {
        return table;
    }

    public Optional<Expression> getWhere() {
        return where;
    }
}
