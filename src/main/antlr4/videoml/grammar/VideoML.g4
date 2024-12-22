grammar VideoML;

// Parser Rules
root          : projectName statements EOF;

projectName     : 'Project' IDENTIFIER;

statements      : statement+;

statement       : caption
                | combine
                | cut
                | stack
                | transition
                | overlay
                | adjustVolume
                | crop
                | freeze
                | concatenate
                ;

caption         : 'caption' STRING ('on' IDENTIFIER)? (duration | offset)? ;
duration        : 'for' time ;
offset          : 'from' time 'to' time
                | NUMBER 's' ('after' STRING | 'before' IDENTIFIER)? ;

combine         : 'combine' STRING ('and' STRING)+ ;

cut             : 'cut' STRING 'from' time 'to' time 'as' IDENTIFIER ;

stack           : 'stack' STRING 'on' STRING 'at' '(' position ',' position ')' ('scale' NUMBER)? 'as' IDENTIFIER ;

transition      : 'transition' STRING 'on' IDENTIFIER 'duration' time ;

overlay         : 'overlay' IDENTIFIER 'on' STRING 'at' timestamp ('as' IDENTIFIER)? ;

time             : NUMBER 's' ;
timestamp        : TIME ;

adjustVolume    : 'adjust' 'volume' 'of' STRING 'to' NUMBER ;

crop            : 'crop' ('top' | 'bottom' | 'left' | 'right') NUMBER '%' ('of' STRING)+ 'as' IDENTIFIER ;

freeze          : 'freeze' IDENTIFIER 'at' timestamp 'for' time ;

concatenate     : 'concatenate' STRING ('and' STRING)+ ('as' IDENTIFIER)? ;

// Lexer Rules
IDENTIFIER      : [a-zA-Z_][a-zA-Z0-9_]* ;
STRING          : '"' (~["])* '"' ;
TIME            : DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ;
NUMBER          : DIGIT+ ;
NEWLINE         : ('\r'? '\n' | '\r')+      -> skip;
WS              : ((' ' | '\t')+)           -> skip;
COMMENT         : '#' ~( '\r' | '\n' )*     -> skip;
DIGIT           : [0-9] ;
position        : 'top' | 'bottom' | 'left' | 'right' ;
