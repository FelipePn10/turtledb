grammar AlterColumnDrop;

@header {
package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.drop;
}

statement
    : alterColumnDrop
    ;

//ALTER TABLE tableName DROP COLUMN columnName;
alterColumnDrop
    : ALTER TABLE tableName DROP COLUMN columnName
    ;

tableName
    : IDENTIFIER
    ;

columnName
    : IDENTIFIER
    ;

ALTER           : A L T E R;
TABLE           : T A B L E;
DROP            : D R O P;
COLUMN          : C O L U M N;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;
WS
    : [ \t\r\n]+ -> skip
    ;

fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment R : [rR];
fragment T : [tT];
fragment U : [uU];
