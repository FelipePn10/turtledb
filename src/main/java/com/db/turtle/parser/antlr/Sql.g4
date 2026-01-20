grammar Sql;

statement
    : selectStmt EOF
    ;

selectStmt
    : SELECT columnList FROM IDENTIFIER whereClause?
    ;

columnList
    : STAR
    | IDENTIFIER (',' IDENTIFIER)*
    ;

whereClause
    : WHERE expression
    ;

expression
    : IDENTIFIER operator literal
    ;

operator
    : '=' | '>' | '<'
    ;

literal
    : NUMBER
    | STRING
    ;

SELECT : 'SELECT';
FROM   : 'FROM';
WHERE  : 'WHERE';
STAR   : '*';

IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

NUMBER
    : [0-9]+
    ;

STRING
    : '\'' .*? '\''
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
