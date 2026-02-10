package com.db.turtle.a_frontend.common.denominator.node;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

public record TableNode(
        TableName table
) implements C_Statement {}