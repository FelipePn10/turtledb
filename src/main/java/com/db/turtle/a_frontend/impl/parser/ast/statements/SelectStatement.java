package com.db.turtle.a_frontend.impl.parser.ast.statements;

import com.db.turtle.a_frontend.impl.parser.ast.denominator.Statement;
import com.db.turtle.a_frontend.impl.parser.ast.denominator.Expression;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public record SelectStatement(
        List<Expression> projection,
        TableName table,
        Optional<Expression> where
) implements Statement {
    public SelectStatement {
        Objects.requireNonNull(projection);
        Objects.requireNonNull(table);

        projection = List.copyOf(projection);

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
