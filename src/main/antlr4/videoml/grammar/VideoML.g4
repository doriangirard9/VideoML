grammar VideoML;

/******************
 ** Parser rules **
 ******************/

root            :   declaration sources EOF;

declaration     :   'project' name=IDENTIFIER;

sources         :   source+;
    source             :   'import' name=IDENTIFIER path=PATH;

/*****************
 ** Lexer rules **
 *****************/

PATH            :   (LOWERCASE | UPPERCASE)+;
IDENTIFIER      :   LOWERCASE (LOWERCASE|UPPERCASE)+;
INTEGER         :   [0-9]+;
FLOAT           :   [0-9]+ '.' [0-9]+;

/*************
 ** Helpers **
 *************/

fragment LOWERCASE  : [a-z];
fragment UPPERCASE  : [A-Z];
NEWLINE             : ('\r'? '\n' | '\r')+      -> skip;
WS                  : ((' ' | '\t')+)           -> skip;
COMMENT             : '#' ~( '\r' | '\n' )*     -> skip;

