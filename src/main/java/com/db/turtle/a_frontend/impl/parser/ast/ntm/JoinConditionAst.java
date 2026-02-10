package com.db.turtle.a_frontend.impl.parser.ast.ntm;

import com.db.turtle.a_frontend.common.denominator.B_Expression;

public record JoinConditionAst(
        B_Expression left,
        B_Expression right
) {}
