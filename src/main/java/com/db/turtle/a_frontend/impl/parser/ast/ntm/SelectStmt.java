package com.db.turtle.a_frontend.impl.parser.ast.ntm;

import com.db.turtle.a_frontend.common.denominator.B_Expression;
import com.db.turtle.a_frontend.common.denominator.C_Statement;

import java.util.List;
import java.util.Optional;

public record SelectStmt(
        List<B_Expression> projection,
        C_Statement from,
        Optional<B_Expression> where
) implements C_Statement {}
