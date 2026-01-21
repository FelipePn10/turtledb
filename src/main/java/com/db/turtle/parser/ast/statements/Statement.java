package com.db.turtle.parser.ast.statements;

import com.db.turtle.parser.ast.denominator.AstNode;

/**
 * Representa comandos de alto nível, que produzem efeito no banco de dados
 *
 * @author Felipe Panosso
 * */
public interface Statement extends AstNode {
    // SelectStatement
    // InsertStatement
    // UpdateStatement
    // DeleteStatement
    // CreateTableStatement
}
