grammar VideoML;

// Parser Rules
root          : projectName statements EOF;

projectName     : 'Project' IDENTIFIER;

statements      : statement+;

statement       : caption
                | combine
                | add
                | cut
                | stack
                | transition
                | overlay
                | adjustVolume
                | blur
                | crop
                | freeze
                | resize
                | concatenate
                ;

add             : 'add' video ('and' video)* ;

video           : STRING ('as' IDENTIFIER)? ;

caption         : 'caption' STRING (offset | duration) ('as' IDENTIFIER)? ;

offset          : 'on' variable ('wait' time)? (duration)? ;

duration        : 'for' time ;

variable        : STRING 
                | IDENTIFIER ;

combine         : 'combine' variable ('and' variable)+ 'as' IDENTIFIER ;

cut             : 'cut' variable 'from' time 'to' time ('as' name=IDENTIFIER)? ;

stack           : 'stack' variable 'on' variable ('at' '(' position ',' position ')')? ('scale' FLOAT)?;

transition      : 'transition' STRING 'on' IDENTIFIER 'duration' time ;

overlay         : 'overlay' IDENTIFIER 'on' STRING 'at' timestamp ('as' IDENTIFIER)? ;

time             : NUMBER 's' ;
timestamp        : TIME ;

adjustVolume    : 'adjust' 'volume' 'of' STRING 'to' NUMBER ;

blur            : 'blur' IDENTIFIER 'at' timestamp 'for' time ;

crop            : 'crop' ('top' | 'bottom' | 'left' | 'right') NUMBER '%' ('of' STRING)+ 'as' IDENTIFIER ;

freeze          : 'freeze' IDENTIFIER 'at' start=time 'for' effect_duration=time ;

resize          : 'resize' IDENTIFIER 'to' (dimensions | percentage) ;

dimensions      : width=NUMBER 'x' height=NUMBER ;

percentage      : NUMBER '%';

concatenate     : 'concatenate' STRING ('and' STRING)+ ('as' IDENTIFIER)? ;

// Lexer Rules
IDENTIFIER      : [a-zA-Z_][a-zA-Z0-9_]* ;
STRING          : '"' (~["])* '"' ;
TIME            : DIGIT DIGIT ':' DIGIT DIGIT (':' DIGIT DIGIT)? ;
NUMBER          : DIGIT+ ;
FLOAT           : DIGIT+ '.' DIGIT+ ;
NEWLINE         : ('\r'? '\n' | '\r')+      -> skip;
WS              : ((' ' | '\t')+)           -> skip;
COMMENT         : '#' ~( '\r' | '\n' )*     -> skip;
DIGIT           : [0-9] ;
position        : 'top' | 'bottom' | 'left' | 'right' ;
