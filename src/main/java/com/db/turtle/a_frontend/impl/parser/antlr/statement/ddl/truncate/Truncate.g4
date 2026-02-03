grammar Truncate;

// TRUNCATE TABLE nome_da_tabela;
@header {
package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.truncate;
}

statement
    : truncate EOF
    ;

truncate
    : TRUNCATE TABLE tableName
    ;

// Futuro:
//truncate
//    : TRUNCATE (TABLE)? tableName (COMMA tableName)* truncateOption?
//    ;


tableName
    : IDENTIFIER
    ;

TRUNCATE    : T R U N C A T E;
TABLE       : T A B L E;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

// Whitespace
WS
    : [ \t\r\n]+ -> skip
    ;

fragment T : [tT];
fragment R : [rR];
fragment U : [uU];
fragment N : [nN];
fragment C : [cC];
fragment A : [aA];
fragment E : [eE];
fragment B : [bB];
fragment L : [lL];

