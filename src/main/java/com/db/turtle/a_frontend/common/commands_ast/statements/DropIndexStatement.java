package com.db.turtle.a_frontend.common.commands_ast.statements;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.IndexName;

public record DropIndexStatement(
        IndexName indexName
) implements C_Statement {
}
