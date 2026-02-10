package com.db.turtle.a_frontend.common.denominator.node;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;

import java.util.List;

public record SelectNode(
        List<ColumnName> fields,
        C_Statement from
) implements C_Statement {}
