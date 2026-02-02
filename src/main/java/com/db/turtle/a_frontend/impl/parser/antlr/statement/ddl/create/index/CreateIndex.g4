grammar CreateIndex;

@header {
package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.index;
}

/*
 * Entry point
 */
statement
    : createIndex EOF
    ;

/*
 * CREATE [UNIQUE] INDEX index_name ON table_name (col1, col2, ...)
 */
createIndex
    : CREATE UNIQUE? INDEX indexName ON tableName LPAREN columnName (COMMA columnName)* RPAREN
    ;

indexName
    : IDENTIFIER
    ;

tableName
    : IDENTIFIER
    ;

columnName
    : IDENTIFIER
    ;

CREATE  : C R E A T E;
INDEX   : I N D E X;
UNIQUE  : U N I Q U E;
ON      : O N;

LPAREN  : '(';
RPAREN  : ')';
COMMA   : ',';

IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;
WS
    : [ \t\r\n]+ -> skip
    ;

fragment A : [aA];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment I : [iI];
fragment N : [nN];
fragment O : [oO];
fragment Q : [qQ];
fragment R : [rR];
fragment T : [tT];
fragment U : [uU];
fragment X : [xX];
