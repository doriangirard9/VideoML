grammar VideoML;

/******************
 ** Parser rules **
 ******************/

root            :   declaration sources EOF;

declaration     :   'project' name=IDENTIFIER;

sources         :   source+;
    source             :   'import' name=IDENTIFIER path=STRING;

/*****************
 ** Lexer rules **
 *****************/

STRING          :   '"' (LOWERCASE | UPPERCASE | DIGIT | '/' | '.' | '_')+ '"';
IDENTIFIER      :   (LOWERCASE | UPPERCASE | DIGIT | '_')+;
DIGIT           :   [0-9];
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

