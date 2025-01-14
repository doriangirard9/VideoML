grammar VideoML;

// Parser Rules
root          : projectName statements EOF;

projectName     : 'Project' IDENTIFIER ('at' NUMBER 'fps')? ('resolution' dimensions)?;

statements      : statement+;

statement       : caption
                | combine
                | add
                | cut
                | stack
                | transition
                | overlay
                | adjustVolume
                | crop
                | freeze
                | resize
                | rotate
                | slow
                | accelerate
                | preview
                ;

time             : NUMBER 's' ;
timestamp        : TIME ;

variable        : STRING 
                | IDENTIFIER ;

// VIDEO
add             : 'add' video ('and' video)* ;

video           : STRING ('as' IDENTIFIER)? ;

caption         : 'caption' STRING (offset | duration) ('as' IDENTIFIER)? ;

offset          : 'on' variable ('wait' time)? (duration)? ;

duration        : 'for' time ;

combine         : 'combine' variable ('and' variable)+ 'as' IDENTIFIER ;

cut             : 'cut' variable 'from' time 'to' time ('as' name=IDENTIFIER)? ;

stack           : 'stack' variable 'on' variable ('at' '(' position ',' position ')')? ('scale' FLOAT)? ;

preview         : 'preview' (IDENTIFIER)? ;

// Audio
overlay         : 'overlay' IDENTIFIER 'on' STRING 'at' timestamp ('as' IDENTIFIER)? ;

adjustVolume    : 'adjust' 'volume' 'of' STRING 'to' NUMBER ;

// Effects
transition      : 'transition' (fadeIn='fadeIn' | fadeOut='fadeOut') 'on' IDENTIFIER 'duration' time ;

crop            : 'crop' cropOptions 'of' IDENTIFIER ;

cropOptions     : all=percentage
                | leftRight=percentage topBottom=percentage
                | left=percentage top=percentage right=percentage bottom=percentage ;

freeze          : 'freeze' IDENTIFIER 'at' start=time 'for' effect_duration=time ;

resize          : 'resize' IDENTIFIER 'to' (dimensions | percentage) ;

dimensions      : width=NUMBER 'x' height=NUMBER ;

percentage      : NUMBER '%' ;

rotate          : 'rotate' IDENTIFIER 'by' NUMBER ;

slow            : 'slow' IDENTIFIER 'by' percentage ;

accelerate      : 'accelerate' IDENTIFIER 'by' percentage ;

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
