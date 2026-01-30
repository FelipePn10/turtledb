grammar DropTable;

// Implementar DROP TABLE IF EXISTS futuramente
@header {
package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.drop.table;
}

statement
    : dropTable EOF
    ;

dropTable
    : DROP TABLE tableName
    ;

tableName
    : IDENTIFIER
    ;


// Keywords
DROP     : D R O P;
TABLE    : T A B L E;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

// Whitespace
WS
    : [ \t\r\n]+ -> skip
    ;

fragment D : [dD];
fragment R : [rR];
fragment O : [oO];
fragment P : [pP];
fragment T : [tT];
fragment A : [aA];
fragment B : [bB];
fragment L : [lL];
fragment E : [eE];