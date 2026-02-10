package com.db.turtle.a_frontend.impl.parser.ast.ntm;

import com.db.turtle.a_frontend.common.denominator.C_Statement;

import java.util.List;

public record JoinStmt(
        C_Statement left,
        C_Statement right,
        List<JoinConditionAst> conditions
) implements C_Statement {}

