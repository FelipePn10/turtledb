grammar AlterRenameTable;

@header {
package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.table.rename;
}

statement
    : alterRenameTable EOF
    ;

// ALTER TABLE old_table_name RENAME TO new_table_name;
alterRenameTable
    : ALTER TABLE tableName RENAME TO tableName
    ;

tableName
    : IDENTIFIER
    ;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

// Whitespace
WS
    : [ \t\r\n]+ -> skip
    ;

ALTER           : A L T E R;
TABLE           : T A B L E;
RENAME          : R E N A M E;
TO              : T O;

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