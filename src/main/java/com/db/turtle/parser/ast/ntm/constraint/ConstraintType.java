package com.db.turtle.parser.ast.ntm.constraint;

/**
 * Representa os tipos de Constraint(s) aceito(s) conforme a gramática
 * */
public enum ConstraintType {
    NOT_NULL,
    NULL,
    PRIMARY_KEY,
    UNIQUE,
    AUTO_INCREMENT,
    DEFAULT
}
