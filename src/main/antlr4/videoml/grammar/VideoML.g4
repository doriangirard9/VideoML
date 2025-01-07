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
                | blur
                | crop
                | freeze
                | resize
                | rotate
                | concatenate
                ;

caption         : 'caption' STRING ('on' IDENTIFIER)? (duration | offset | offsetWithDuration)? ;

duration        : 'for' time ;
offset          : 'from' from=time 'to' to=time
                | NUMBER 's' ('after' after=(IDENTIFIER | STRING) | 'before' before=(IDENTIFIER | STRING))? ;
offsetWithDuration
    : offset duration ;

combine         : 'combine' STRING ('and' STRING)+ ;

cut             : 'cut' STRING 'from' time 'to' time 'as' IDENTIFIER ;

stack           : 'stack' STRING 'on' STRING ('at' '(' position ',' position ')')? ('scale' FLOAT)?;

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

rotate          : 'rotate' IDENTIFIER 'by' NUMBER 'degrees' ;

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
