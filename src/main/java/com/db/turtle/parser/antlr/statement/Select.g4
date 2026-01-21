grammar Select;

@header {
package com.db.turtle.parser.antlr.statement;
}

/*
 * ENTRY POINT
 */
statement
    : selectStatement EOF
    ;

/*
 * SELECT STATEMENT
 */
selectStatement
    : SELECT projection FROM tableName whereClause?
    ;

/*
 * PROJECTION
 */
projection
    : STAR
    | column (COMMA column)*
    ;

column
    : IDENTIFIER
    ;

/*
 * FROM
 */
tableName
    : IDENTIFIER
    ;

/*
 * WHERE
 */
whereClause
    : WHERE booleanExpression
    ;

/*
 * BOOLEAN EXPRESSIONS
 */
booleanExpression
    : booleanExpression OR booleanTerm
    | booleanTerm
    ;

booleanTerm
    : booleanTerm AND booleanFactor
    | booleanFactor
    ;

booleanFactor
    : LEFT_PAREN booleanExpression RIGHT_PAREN
    | predicate
    ;

predicate
    : column comparisonOperator literal
    ;

/*
 * OPERATORS
 */
comparisonOperator
    : EQ
    | GT
    | GE
    | LT
    | LE
    | NE
    ;

/*
 * LITERALS
 */
literal
    : NUMBER
    | STRING
    | NULL
    ;

/*
 * KEYWORDS
 */
SELECT : 'SELECT';
FROM   : 'FROM';
WHERE  : 'WHERE';
AND    : 'AND';
OR     : 'OR';
NULL   : 'NULL';

/*
 * SYMBOLS
 */
STAR  : '*';
COMMA : ',';
LEFT_PAREN  : '(';
RIGHT_PAREN : ')';

EQ : '=';
GT : '>';
GE : '>=';
LT : '<';
LE : '<=';
NE : '!=';

/*
 * IDENTIFIERS & VALUES
 */
IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

STRING
    : '\'' ( ~('\'' | '\\') | '\\' . )* '\''
    ;

/*
 * WHITESPACE
 */
WS
    : [ \t\r\n]+ -> skip
    ;
