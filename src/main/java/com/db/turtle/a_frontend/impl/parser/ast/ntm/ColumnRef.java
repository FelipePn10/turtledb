package com.db.turtle.a_frontend.impl.parser.ast.ntm;

import com.db.turtle.a_frontend.common.denominator.B_Expression;

import java.util.Optional;

public record ColumnRef(
        Optional<String> qualifier, // Table or Alias
        ColumnName name
) implements B_Expression {
    public static ColumnRef of(ColumnName name) {
        return new ColumnRef(
                Optional.empty(),
                name
        );
    }
}
