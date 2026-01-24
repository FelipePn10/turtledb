grammar CreateTable;

@header {
package com.db.turtle.parser.antlr.statement.ddl.create.table;
}

statementddl
    : createTable EOF
    ;

createTable
    : CREATE TABLE tableName LPAREN columnDef (COMMA columnDef)* RPAREN
    ;

columnDef
    : columnName dataType columnConstraints?
    ;

columnName
    : IDENTIFIER
    ;

tableName
    : IDENTIFIER
    ;

dataType
    : VARCHAR LPAREN NUMBER RPAREN                  // VARCHAR(255)
    | CHAR LPAREN NUMBER RPAREN                     // CHAR(10)
    | INT                                           // INT
    | INTEGER                                       // INTEGER
    | BIGINT                                        // BIGINT
    | DECIMAL LPAREN NUMBER (COMMA NUMBER)? RPAREN  // DECIMAL(10,2)
    | FLOAT                                         // FLOAT
    | DOUBLE                                        // DOUBLE
    | DATE                                          // DATE
    | DATETIME                                      // DATETIME
    | TIMESTAMP                                     // TIMESTAMP
    | TEXT                                          // TEXT
    | BOOLEAN                                       // BOOLEAN
    ;

columnConstraints
    : columnConstraint+
    ;

columnConstraint
    : NOT NULL                          // NOT NULL
    | NULL                              // NULL
    | PRIMARY KEY                       // PRIMARY KEY
    | UNIQUE                            // UNIQUE
    | AUTO_INCREMENT                    // AUTO_INCREMENT
    | DEFAULT defaultValue              // DEFAULT valor
    ;

defaultValue
    : NUMBER
    | STRING
    | NULL
    | TRUE
    | FALSE
    ;

// Keywords
CREATE          : C R E A T E;
TABLE           : T A B L E;
VARCHAR         : V A R C H A R;
CHAR            : C H A R;
INT             : I N T;
INTEGER         : I N T E G E R;
BIGINT          : B I G I N T;
DECIMAL         : D E C I M A L;
FLOAT           : F L O A T;
DOUBLE          : D O U B L E;
DATE            : D A T E;
DATETIME        : D A T E T I M E;
TIMESTAMP       : T I M E S T A M P;
TEXT            : T E X T;
BOOLEAN         : B O O L E A N;
NOT             : N O T;
NULL            : N U L L;
PRIMARY         : P R I M A R Y;
KEY             : K E Y;
UNIQUE          : U N I Q U E;
AUTO_INCREMENT  : A U T O '_' I N C R E M E N T;
DEFAULT         : D E F A U L T;
TRUE            : T R U E;
FALSE           : F A L S E;

// Símbolos
LPAREN  : '(';
RPAREN  : ')';
COMMA   : ',';

// Literais
IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

STRING
    : '\'' ( ~('\'' | '\\') | '\\' . )* '\''
    ;

// Whitespace
WS
    : [ \t\r\n]+ -> skip
    ;

// Fragments para case-insensitive keywords
fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

/**
                        -- EXEMPLO --

CREATE TABLE usuarios (
    id      INT          PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(100) NOT NULL,
    email   VARCHAR(255) UNIQUE,
    age     INT          DEFAULT 18,
    active  BOOLEAN      DEFAULT TRUE
)
*/
