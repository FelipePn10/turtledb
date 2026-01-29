package com.db.turtle.a_frontend.common.commands_ast.statements;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.common.denominator.B_Expression;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public record SelectStatement(
        List<B_Expression> projection,
        TableName table,
        Optional<B_Expression> where
) implements C_Statement {
    public SelectStatement {
        Objects.requireNonNull(projection);
        Objects.requireNonNull(table);

        projection = List.copyOf(projection);

    }

    public List<B_Expression> getProjection() {
        return projection;
    }

    public TableName getTable() {
        return table;
    }

    public Optional<B_Expression> getWhere() {
        return where;
    }
}
