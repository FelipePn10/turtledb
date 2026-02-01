grammar DropIndex;

@header {
package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.drop.index;
}

// DROP INDEX name_indice
statement
    : dropIndex EOF
    ;

dropIndex
    : DROP INDEX indexName
    ;

indexName
    : IDENTIFIER
    ;

DROP     : D R O P;
INDEX    : I N D E X;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

fragment D : [dD];
fragment R : [rR];
fragment O : [oO];
fragment P : [pP];
fragment I : [iI];
fragment N : [nN];
fragment E : [eE];
fragment X : [xX];
