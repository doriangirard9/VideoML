// Generated from /Users/doriangirard/Documents/sse/ing-modeles/VideoML/src/main/antlr4/videoml/grammar/VideoML.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class VideoMLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, IDENTIFIER=43, STRING=44, TIME=45, 
		NUMBER=46, FLOAT=47, NEWLINE=48, WS=49, COMMENT=50, DIGIT=51;
	public static final int
		RULE_root = 0, RULE_projectName = 1, RULE_statements = 2, RULE_statement = 3, 
		RULE_time = 4, RULE_timestamp = 5, RULE_variable = 6, RULE_add = 7, RULE_video = 8, 
		RULE_caption = 9, RULE_offset = 10, RULE_duration = 11, RULE_combine = 12, 
		RULE_cut = 13, RULE_stack = 14, RULE_overlay = 15, RULE_adjustVolume = 16, 
		RULE_transition = 17, RULE_crop = 18, RULE_cropOptions = 19, RULE_freeze = 20, 
		RULE_resize = 21, RULE_dimensions = 22, RULE_percentage = 23, RULE_rotate = 24, 
		RULE_slow = 25, RULE_accelerate = 26, RULE_position = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "projectName", "statements", "statement", "time", "timestamp", 
			"variable", "add", "video", "caption", "offset", "duration", "combine", 
			"cut", "stack", "overlay", "adjustVolume", "transition", "crop", "cropOptions", 
			"freeze", "resize", "dimensions", "percentage", "rotate", "slow", "accelerate", 
			"position"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Project'", "'at'", "'fps'", "'resolution'", "'s'", "'add'", "'and'", 
			"'as'", "'caption'", "'on'", "'wait'", "'for'", "'combine'", "'cut'", 
			"'from'", "'to'", "'stack'", "'('", "','", "')'", "'scale'", "'overlay'", 
			"'adjust'", "'volume'", "'of'", "'transition'", "'fadeIn'", "'fadeOut'", 
			"'duration'", "'crop'", "'freeze'", "'resize'", "'x'", "'%'", "'rotate'", 
			"'by'", "'slow'", "'accelerate'", "'top'", "'bottom'", "'left'", "'right'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "IDENTIFIER", "STRING", "TIME", 
			"NUMBER", "FLOAT", "NEWLINE", "WS", "COMMENT", "DIGIT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "VideoML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VideoMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public ProjectNameContext projectName() {
			return getRuleContext(ProjectNameContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(VideoMLParser.EOF, 0); }
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			projectName();
			setState(57);
			statements();
			setState(58);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProjectNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public TerminalNode NUMBER() { return getToken(VideoMLParser.NUMBER, 0); }
		public DimensionsContext dimensions() {
			return getRuleContext(DimensionsContext.class,0);
		}
		public ProjectNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projectName; }
	}

	public final ProjectNameContext projectName() throws RecognitionException {
		ProjectNameContext _localctx = new ProjectNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_projectName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__0);
			setState(61);
			match(IDENTIFIER);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(62);
				match(T__1);
				setState(63);
				match(NUMBER);
				setState(64);
				match(T__2);
				}
			}

			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(67);
				match(T__3);
				setState(68);
				dimensions();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				statement();
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 454272639552L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public CaptionContext caption() {
			return getRuleContext(CaptionContext.class,0);
		}
		public CombineContext combine() {
			return getRuleContext(CombineContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public CutContext cut() {
			return getRuleContext(CutContext.class,0);
		}
		public StackContext stack() {
			return getRuleContext(StackContext.class,0);
		}
		public TransitionContext transition() {
			return getRuleContext(TransitionContext.class,0);
		}
		public OverlayContext overlay() {
			return getRuleContext(OverlayContext.class,0);
		}
		public AdjustVolumeContext adjustVolume() {
			return getRuleContext(AdjustVolumeContext.class,0);
		}
		public CropContext crop() {
			return getRuleContext(CropContext.class,0);
		}
		public FreezeContext freeze() {
			return getRuleContext(FreezeContext.class,0);
		}
		public ResizeContext resize() {
			return getRuleContext(ResizeContext.class,0);
		}
		public RotateContext rotate() {
			return getRuleContext(RotateContext.class,0);
		}
		public SlowContext slow() {
			return getRuleContext(SlowContext.class,0);
		}
		public AccelerateContext accelerate() {
			return getRuleContext(AccelerateContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				caption();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				combine();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				add();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				cut();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				stack();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				transition();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
				overlay();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 8);
				{
				setState(83);
				adjustVolume();
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 9);
				{
				setState(84);
				crop();
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 10);
				{
				setState(85);
				freeze();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 11);
				{
				setState(86);
				resize();
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 12);
				{
				setState(87);
				rotate();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 13);
				{
				setState(88);
				slow();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 14);
				{
				setState(89);
				accelerate();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(VideoMLParser.NUMBER, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(NUMBER);
			setState(93);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimestampContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(VideoMLParser.TIME, 0); }
		public TimestampContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timestamp; }
	}

	public final TimestampContext timestamp() throws RecognitionException {
		TimestampContext _localctx = new TimestampContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_timestamp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(TIME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(VideoMLParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddContext extends ParserRuleContext {
		public List<VideoContext> video() {
			return getRuleContexts(VideoContext.class);
		}
		public VideoContext video(int i) {
			return getRuleContext(VideoContext.class,i);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__5);
			setState(100);
			video();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(101);
				match(T__6);
				setState(102);
				video();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VideoContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(VideoMLParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public VideoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_video; }
	}

	public final VideoContext video() throws RecognitionException {
		VideoContext _localctx = new VideoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_video);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(STRING);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(109);
				match(T__7);
				setState(110);
				match(IDENTIFIER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaptionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(VideoMLParser.STRING, 0); }
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public CaptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caption; }
	}

	public final CaptionContext caption() throws RecognitionException {
		CaptionContext _localctx = new CaptionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_caption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__8);
			setState(114);
			match(STRING);
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				{
				setState(115);
				offset();
				}
				break;
			case T__11:
				{
				setState(116);
				duration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(119);
				match(T__7);
				setState(120);
				match(IDENTIFIER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OffsetContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public OffsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset; }
	}

	public final OffsetContext offset() throws RecognitionException {
		OffsetContext _localctx = new OffsetContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_offset);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__9);
			setState(124);
			variable();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(125);
				match(T__10);
				setState(126);
				time();
				}
			}

			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(129);
				duration();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DurationContext extends ParserRuleContext {
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public DurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration; }
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_duration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__11);
			setState(133);
			time();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CombineContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public CombineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_combine; }
	}

	public final CombineContext combine() throws RecognitionException {
		CombineContext _localctx = new CombineContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_combine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__12);
			setState(136);
			variable();
			setState(139); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(137);
				match(T__6);
				setState(138);
				variable();
				}
				}
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
			setState(143);
			match(T__7);
			setState(144);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CutContext extends ParserRuleContext {
		public Token name;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<TimeContext> time() {
			return getRuleContexts(TimeContext.class);
		}
		public TimeContext time(int i) {
			return getRuleContext(TimeContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public CutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cut; }
	}

	public final CutContext cut() throws RecognitionException {
		CutContext _localctx = new CutContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cut);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__13);
			setState(147);
			variable();
			setState(148);
			match(T__14);
			setState(149);
			time();
			setState(150);
			match(T__15);
			setState(151);
			time();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(152);
				match(T__7);
				setState(153);
				((CutContext)_localctx).name = match(IDENTIFIER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StackContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<PositionContext> position() {
			return getRuleContexts(PositionContext.class);
		}
		public PositionContext position(int i) {
			return getRuleContext(PositionContext.class,i);
		}
		public TerminalNode FLOAT() { return getToken(VideoMLParser.FLOAT, 0); }
		public StackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stack; }
	}

	public final StackContext stack() throws RecognitionException {
		StackContext _localctx = new StackContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stack);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__16);
			setState(157);
			variable();
			setState(158);
			match(T__9);
			setState(159);
			variable();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(160);
				match(T__1);
				setState(161);
				match(T__17);
				setState(162);
				position();
				setState(163);
				match(T__18);
				setState(164);
				position();
				setState(165);
				match(T__19);
				}
			}

			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(169);
				match(T__20);
				setState(170);
				match(FLOAT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OverlayContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(VideoMLParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(VideoMLParser.IDENTIFIER, i);
		}
		public TerminalNode STRING() { return getToken(VideoMLParser.STRING, 0); }
		public TimestampContext timestamp() {
			return getRuleContext(TimestampContext.class,0);
		}
		public OverlayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overlay; }
	}

	public final OverlayContext overlay() throws RecognitionException {
		OverlayContext _localctx = new OverlayContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_overlay);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__21);
			setState(174);
			match(IDENTIFIER);
			setState(175);
			match(T__9);
			setState(176);
			match(STRING);
			setState(177);
			match(T__1);
			setState(178);
			timestamp();
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(179);
				match(T__7);
				setState(180);
				match(IDENTIFIER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdjustVolumeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(VideoMLParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(VideoMLParser.NUMBER, 0); }
		public AdjustVolumeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adjustVolume; }
	}

	public final AdjustVolumeContext adjustVolume() throws RecognitionException {
		AdjustVolumeContext _localctx = new AdjustVolumeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_adjustVolume);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__22);
			setState(184);
			match(T__23);
			setState(185);
			match(T__24);
			setState(186);
			match(STRING);
			setState(187);
			match(T__15);
			setState(188);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TransitionContext extends ParserRuleContext {
		public Token fadeIn;
		public Token fadeOut;
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__25);
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				{
				setState(191);
				((TransitionContext)_localctx).fadeIn = match(T__26);
				}
				break;
			case T__27:
				{
				setState(192);
				((TransitionContext)_localctx).fadeOut = match(T__27);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(195);
			match(T__9);
			setState(196);
			match(IDENTIFIER);
			setState(197);
			match(T__28);
			setState(198);
			time();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CropContext extends ParserRuleContext {
		public CropOptionsContext cropOptions() {
			return getRuleContext(CropOptionsContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public CropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crop; }
	}

	public final CropContext crop() throws RecognitionException {
		CropContext _localctx = new CropContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_crop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__29);
			setState(201);
			cropOptions();
			setState(202);
			match(T__24);
			setState(203);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CropOptionsContext extends ParserRuleContext {
		public PercentageContext all;
		public PercentageContext leftRight;
		public PercentageContext topBottom;
		public PercentageContext left;
		public PercentageContext top;
		public PercentageContext right;
		public PercentageContext bottom;
		public List<PercentageContext> percentage() {
			return getRuleContexts(PercentageContext.class);
		}
		public PercentageContext percentage(int i) {
			return getRuleContext(PercentageContext.class,i);
		}
		public CropOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cropOptions; }
	}

	public final CropOptionsContext cropOptions() throws RecognitionException {
		CropOptionsContext _localctx = new CropOptionsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cropOptions);
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				((CropOptionsContext)_localctx).all = percentage();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				((CropOptionsContext)_localctx).leftRight = percentage();
				setState(207);
				((CropOptionsContext)_localctx).topBottom = percentage();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				((CropOptionsContext)_localctx).left = percentage();
				setState(210);
				((CropOptionsContext)_localctx).top = percentage();
				setState(211);
				((CropOptionsContext)_localctx).right = percentage();
				setState(212);
				((CropOptionsContext)_localctx).bottom = percentage();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FreezeContext extends ParserRuleContext {
		public TimeContext start;
		public TimeContext effect_duration;
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public List<TimeContext> time() {
			return getRuleContexts(TimeContext.class);
		}
		public TimeContext time(int i) {
			return getRuleContext(TimeContext.class,i);
		}
		public FreezeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_freeze; }
	}

	public final FreezeContext freeze() throws RecognitionException {
		FreezeContext _localctx = new FreezeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_freeze);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__30);
			setState(217);
			match(IDENTIFIER);
			setState(218);
			match(T__1);
			setState(219);
			((FreezeContext)_localctx).start = time();
			setState(220);
			match(T__11);
			setState(221);
			((FreezeContext)_localctx).effect_duration = time();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResizeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public DimensionsContext dimensions() {
			return getRuleContext(DimensionsContext.class,0);
		}
		public PercentageContext percentage() {
			return getRuleContext(PercentageContext.class,0);
		}
		public ResizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resize; }
	}

	public final ResizeContext resize() throws RecognitionException {
		ResizeContext _localctx = new ResizeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_resize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__31);
			setState(224);
			match(IDENTIFIER);
			setState(225);
			match(T__15);
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(226);
				dimensions();
				}
				break;
			case 2:
				{
				setState(227);
				percentage();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DimensionsContext extends ParserRuleContext {
		public Token width;
		public Token height;
		public List<TerminalNode> NUMBER() { return getTokens(VideoMLParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(VideoMLParser.NUMBER, i);
		}
		public DimensionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimensions; }
	}

	public final DimensionsContext dimensions() throws RecognitionException {
		DimensionsContext _localctx = new DimensionsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_dimensions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			((DimensionsContext)_localctx).width = match(NUMBER);
			setState(231);
			match(T__32);
			setState(232);
			((DimensionsContext)_localctx).height = match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PercentageContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(VideoMLParser.NUMBER, 0); }
		public PercentageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_percentage; }
	}

	public final PercentageContext percentage() throws RecognitionException {
		PercentageContext _localctx = new PercentageContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_percentage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(NUMBER);
			setState(235);
			match(T__33);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RotateContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public TerminalNode NUMBER() { return getToken(VideoMLParser.NUMBER, 0); }
		public RotateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotate; }
	}

	public final RotateContext rotate() throws RecognitionException {
		RotateContext _localctx = new RotateContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_rotate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__34);
			setState(238);
			match(IDENTIFIER);
			setState(239);
			match(T__35);
			setState(240);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SlowContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public PercentageContext percentage() {
			return getRuleContext(PercentageContext.class,0);
		}
		public SlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slow; }
	}

	public final SlowContext slow() throws RecognitionException {
		SlowContext _localctx = new SlowContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_slow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(T__36);
			setState(243);
			match(IDENTIFIER);
			setState(244);
			match(T__35);
			setState(245);
			percentage();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccelerateContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public PercentageContext percentage() {
			return getRuleContext(PercentageContext.class,0);
		}
		public AccelerateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accelerate; }
	}

	public final AccelerateContext accelerate() throws RecognitionException {
		AccelerateContext _localctx = new AccelerateContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_accelerate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__37);
			setState(248);
			match(IDENTIFIER);
			setState(249);
			match(T__35);
			setState(250);
			percentage();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PositionContext extends ParserRuleContext {
		public PositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_position; }
	}

	public final PositionContext position() throws RecognitionException {
		PositionContext _localctx = new PositionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_position);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8246337208320L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00013\u00ff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001B\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001F\b\u0001\u0001\u0002\u0004\u0002I\b\u0002\u000b"+
		"\u0002\f\u0002J\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003[\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007h\b"+
		"\u0007\n\u0007\f\u0007k\t\u0007\u0001\b\u0001\b\u0001\b\u0003\bp\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\tv\b\t\u0001\t\u0001\t\u0003\tz\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u0080\b\n\u0001\n\u0003\n\u0083\b\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0004"+
		"\f\u008c\b\f\u000b\f\f\f\u008d\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u009b\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00a8"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ac\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00b6\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00c2\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00d7\b\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u00e5\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0000\u0000\u001c\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.0246\u0000\u0002\u0001\u0000+,\u0001\u0000\'*\u0101\u00008\u0001"+
		"\u0000\u0000\u0000\u0002<\u0001\u0000\u0000\u0000\u0004H\u0001\u0000\u0000"+
		"\u0000\u0006Z\u0001\u0000\u0000\u0000\b\\\u0001\u0000\u0000\u0000\n_\u0001"+
		"\u0000\u0000\u0000\fa\u0001\u0000\u0000\u0000\u000ec\u0001\u0000\u0000"+
		"\u0000\u0010l\u0001\u0000\u0000\u0000\u0012q\u0001\u0000\u0000\u0000\u0014"+
		"{\u0001\u0000\u0000\u0000\u0016\u0084\u0001\u0000\u0000\u0000\u0018\u0087"+
		"\u0001\u0000\u0000\u0000\u001a\u0092\u0001\u0000\u0000\u0000\u001c\u009c"+
		"\u0001\u0000\u0000\u0000\u001e\u00ad\u0001\u0000\u0000\u0000 \u00b7\u0001"+
		"\u0000\u0000\u0000\"\u00be\u0001\u0000\u0000\u0000$\u00c8\u0001\u0000"+
		"\u0000\u0000&\u00d6\u0001\u0000\u0000\u0000(\u00d8\u0001\u0000\u0000\u0000"+
		"*\u00df\u0001\u0000\u0000\u0000,\u00e6\u0001\u0000\u0000\u0000.\u00ea"+
		"\u0001\u0000\u0000\u00000\u00ed\u0001\u0000\u0000\u00002\u00f2\u0001\u0000"+
		"\u0000\u00004\u00f7\u0001\u0000\u0000\u00006\u00fc\u0001\u0000\u0000\u0000"+
		"89\u0003\u0002\u0001\u00009:\u0003\u0004\u0002\u0000:;\u0005\u0000\u0000"+
		"\u0001;\u0001\u0001\u0000\u0000\u0000<=\u0005\u0001\u0000\u0000=A\u0005"+
		"+\u0000\u0000>?\u0005\u0002\u0000\u0000?@\u0005.\u0000\u0000@B\u0005\u0003"+
		"\u0000\u0000A>\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BE\u0001"+
		"\u0000\u0000\u0000CD\u0005\u0004\u0000\u0000DF\u0003,\u0016\u0000EC\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u0003\u0001\u0000\u0000"+
		"\u0000GI\u0003\u0006\u0003\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000"+
		"\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\u0005"+
		"\u0001\u0000\u0000\u0000L[\u0003\u0012\t\u0000M[\u0003\u0018\f\u0000N"+
		"[\u0003\u000e\u0007\u0000O[\u0003\u001a\r\u0000P[\u0003\u001c\u000e\u0000"+
		"Q[\u0003\"\u0011\u0000R[\u0003\u001e\u000f\u0000S[\u0003 \u0010\u0000"+
		"T[\u0003$\u0012\u0000U[\u0003(\u0014\u0000V[\u0003*\u0015\u0000W[\u0003"+
		"0\u0018\u0000X[\u00032\u0019\u0000Y[\u00034\u001a\u0000ZL\u0001\u0000"+
		"\u0000\u0000ZM\u0001\u0000\u0000\u0000ZN\u0001\u0000\u0000\u0000ZO\u0001"+
		"\u0000\u0000\u0000ZP\u0001\u0000\u0000\u0000ZQ\u0001\u0000\u0000\u0000"+
		"ZR\u0001\u0000\u0000\u0000ZS\u0001\u0000\u0000\u0000ZT\u0001\u0000\u0000"+
		"\u0000ZU\u0001\u0000\u0000\u0000ZV\u0001\u0000\u0000\u0000ZW\u0001\u0000"+
		"\u0000\u0000ZX\u0001\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[\u0007"+
		"\u0001\u0000\u0000\u0000\\]\u0005.\u0000\u0000]^\u0005\u0005\u0000\u0000"+
		"^\t\u0001\u0000\u0000\u0000_`\u0005-\u0000\u0000`\u000b\u0001\u0000\u0000"+
		"\u0000ab\u0007\u0000\u0000\u0000b\r\u0001\u0000\u0000\u0000cd\u0005\u0006"+
		"\u0000\u0000di\u0003\u0010\b\u0000ef\u0005\u0007\u0000\u0000fh\u0003\u0010"+
		"\b\u0000ge\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000ij\u0001\u0000\u0000\u0000j\u000f\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000lo\u0005,\u0000\u0000mn\u0005\b\u0000\u0000"+
		"np\u0005+\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"p\u0011\u0001\u0000\u0000\u0000qr\u0005\t\u0000\u0000ru\u0005,\u0000\u0000"+
		"sv\u0003\u0014\n\u0000tv\u0003\u0016\u000b\u0000us\u0001\u0000\u0000\u0000"+
		"ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wx\u0005\b\u0000\u0000"+
		"xz\u0005+\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000"+
		"z\u0013\u0001\u0000\u0000\u0000{|\u0005\n\u0000\u0000|\u007f\u0003\f\u0006"+
		"\u0000}~\u0005\u000b\u0000\u0000~\u0080\u0003\b\u0004\u0000\u007f}\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0082\u0001"+
		"\u0000\u0000\u0000\u0081\u0083\u0003\u0016\u000b\u0000\u0082\u0081\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0015\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005\f\u0000\u0000\u0085\u0086\u0003\b"+
		"\u0004\u0000\u0086\u0017\u0001\u0000\u0000\u0000\u0087\u0088\u0005\r\u0000"+
		"\u0000\u0088\u008b\u0003\f\u0006\u0000\u0089\u008a\u0005\u0007\u0000\u0000"+
		"\u008a\u008c\u0003\f\u0006\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0005\b\u0000\u0000\u0090\u0091\u0005+\u0000\u0000\u0091\u0019"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u000e\u0000\u0000\u0093\u0094"+
		"\u0003\f\u0006\u0000\u0094\u0095\u0005\u000f\u0000\u0000\u0095\u0096\u0003"+
		"\b\u0004\u0000\u0096\u0097\u0005\u0010\u0000\u0000\u0097\u009a\u0003\b"+
		"\u0004\u0000\u0098\u0099\u0005\b\u0000\u0000\u0099\u009b\u0005+\u0000"+
		"\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000"+
		"\u0000\u009b\u001b\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u0011\u0000"+
		"\u0000\u009d\u009e\u0003\f\u0006\u0000\u009e\u009f\u0005\n\u0000\u0000"+
		"\u009f\u00a7\u0003\f\u0006\u0000\u00a0\u00a1\u0005\u0002\u0000\u0000\u00a1"+
		"\u00a2\u0005\u0012\u0000\u0000\u00a2\u00a3\u00036\u001b\u0000\u00a3\u00a4"+
		"\u0005\u0013\u0000\u0000\u00a4\u00a5\u00036\u001b\u0000\u00a5\u00a6\u0005"+
		"\u0014\u0000\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0005\u0015\u0000\u0000\u00aa\u00ac\u0005"+
		"/\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ac\u001d\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0016"+
		"\u0000\u0000\u00ae\u00af\u0005+\u0000\u0000\u00af\u00b0\u0005\n\u0000"+
		"\u0000\u00b0\u00b1\u0005,\u0000\u0000\u00b1\u00b2\u0005\u0002\u0000\u0000"+
		"\u00b2\u00b5\u0003\n\u0005\u0000\u00b3\u00b4\u0005\b\u0000\u0000\u00b4"+
		"\u00b6\u0005+\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b6\u001f\u0001\u0000\u0000\u0000\u00b7\u00b8"+
		"\u0005\u0017\u0000\u0000\u00b8\u00b9\u0005\u0018\u0000\u0000\u00b9\u00ba"+
		"\u0005\u0019\u0000\u0000\u00ba\u00bb\u0005,\u0000\u0000\u00bb\u00bc\u0005"+
		"\u0010\u0000\u0000\u00bc\u00bd\u0005.\u0000\u0000\u00bd!\u0001\u0000\u0000"+
		"\u0000\u00be\u00c1\u0005\u001a\u0000\u0000\u00bf\u00c2\u0005\u001b\u0000"+
		"\u0000\u00c0\u00c2\u0005\u001c\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c4\u0005\n\u0000\u0000\u00c4\u00c5\u0005+\u0000\u0000"+
		"\u00c5\u00c6\u0005\u001d\u0000\u0000\u00c6\u00c7\u0003\b\u0004\u0000\u00c7"+
		"#\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u001e\u0000\u0000\u00c9\u00ca"+
		"\u0003&\u0013\u0000\u00ca\u00cb\u0005\u0019\u0000\u0000\u00cb\u00cc\u0005"+
		"+\u0000\u0000\u00cc%\u0001\u0000\u0000\u0000\u00cd\u00d7\u0003.\u0017"+
		"\u0000\u00ce\u00cf\u0003.\u0017\u0000\u00cf\u00d0\u0003.\u0017\u0000\u00d0"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d1\u00d2\u0003.\u0017\u0000\u00d2\u00d3"+
		"\u0003.\u0017\u0000\u00d3\u00d4\u0003.\u0017\u0000\u00d4\u00d5\u0003."+
		"\u0017\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00cd\u0001\u0000"+
		"\u0000\u0000\u00d6\u00ce\u0001\u0000\u0000\u0000\u00d6\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d7\'\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u001f\u0000"+
		"\u0000\u00d9\u00da\u0005+\u0000\u0000\u00da\u00db\u0005\u0002\u0000\u0000"+
		"\u00db\u00dc\u0003\b\u0004\u0000\u00dc\u00dd\u0005\f\u0000\u0000\u00dd"+
		"\u00de\u0003\b\u0004\u0000\u00de)\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0005 \u0000\u0000\u00e0\u00e1\u0005+\u0000\u0000\u00e1\u00e4\u0005\u0010"+
		"\u0000\u0000\u00e2\u00e5\u0003,\u0016\u0000\u00e3\u00e5\u0003.\u0017\u0000"+
		"\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e5+\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005.\u0000\u0000\u00e7\u00e8"+
		"\u0005!\u0000\u0000\u00e8\u00e9\u0005.\u0000\u0000\u00e9-\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0005.\u0000\u0000\u00eb\u00ec\u0005\"\u0000"+
		"\u0000\u00ec/\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005#\u0000\u0000\u00ee"+
		"\u00ef\u0005+\u0000\u0000\u00ef\u00f0\u0005$\u0000\u0000\u00f0\u00f1\u0005"+
		".\u0000\u0000\u00f11\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005%\u0000"+
		"\u0000\u00f3\u00f4\u0005+\u0000\u0000\u00f4\u00f5\u0005$\u0000\u0000\u00f5"+
		"\u00f6\u0003.\u0017\u0000\u00f63\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005"+
		"&\u0000\u0000\u00f8\u00f9\u0005+\u0000\u0000\u00f9\u00fa\u0005$\u0000"+
		"\u0000\u00fa\u00fb\u0003.\u0017\u0000\u00fb5\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\u0007\u0001\u0000\u0000\u00fd7\u0001\u0000\u0000\u0000\u0012AE"+
		"JZiouy\u007f\u0082\u008d\u009a\u00a7\u00ab\u00b5\u00c1\u00d6\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}