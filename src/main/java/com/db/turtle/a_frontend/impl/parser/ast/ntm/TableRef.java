package com.db.turtle.a_frontend.impl.parser.ast.ntm;

import com.db.turtle.a_frontend.common.denominator.C_Statement;

import java.util.Optional;

public record TableRef(
        Optional<String> schema,
        TableName name,
        Optional<String> alias
) implements C_Statement {
    public static TableRef of(TableName name) {
        return new TableRef(
                Optional.empty(),
                name,
                Optional.empty()
        );
    }
}


