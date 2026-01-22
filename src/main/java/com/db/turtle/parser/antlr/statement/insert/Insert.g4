grammar Insert;

@header {
package com.db.turtle.parser.antlr.statement.insert;
}

statement
    : insertStatement EOF
    ;

insertStatement
    : INSERT INTO tableName columnList? VALUES valueList
    ;

columnList
    : LPAREN column (COMMA column)* RPAREN
    ;

valueList
    : LPAREN literal (COMMA literal)* RPAREN
    ;

column
    : IDENTIFIER
    ;

tableName
    : IDENTIFIER
    ;

literal
    : NUMBER
    | STRING
    | NULL
    ;

INSERT  : 'INSERT';
INTO    :   'INTO';
VALUES  : 'VALUES';
NULL    :   'NULL';

LPAREN  : '(';
RPAREN  : ')';
COMMA   : ',';

IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

STRING
    : '\'' ( ~('\'' | '\\') | '\\' . )* '\''
    ;

WS
    : [ \t\r\n]+ -> skip
    ;