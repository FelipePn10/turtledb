grammar Insert;

@header {
package com.db.turtle.parser.antlr.statement.insert;
}

/**
* Atualmente a gramática está na sua primeira versão. Portanto temos as seguintes ressalvas de escopo:
*.
* 1. INSERT INTO users                = OK
* INSERT INTO public.users            = erro
*
* 2. INSERT INTO table DEFAULT VALUES = erro
*    INSERT INTO table SELECT ...     = erro
*
* 3. INSERT OR IGNORE INTO ...        = erro
*    INSERT LOW_PRIORITY INTO ...     = erro
*
* Atualizações futuras virão para que isso seja suportado.
* Ass: Felipe Panosso - TurtleDB
*/
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