package com.db.turtle.parser.ast.statements;

import com.db.turtle.parser.ast.denominator.Statement;
import com.db.turtle.parser.ast.denominator.Expression;
import com.db.turtle.parser.ast.ntm.TableName;

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
}
