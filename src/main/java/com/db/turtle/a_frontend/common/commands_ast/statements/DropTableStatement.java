package com.db.turtle.a_frontend.common.commands_ast.statements;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

/**
 * Representação de um comando DROP TABLE em Nó do AST.
 * */
public record DropTableStatement(
        TableName tableName
) implements C_Statement {

}
