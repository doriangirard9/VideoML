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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, IDENTIFIER=44, STRING=45, 
		TIME=46, NUMBER=47, FLOAT=48, NEWLINE=49, WS=50, COMMENT=51, DIGIT=52;
	public static final int
		RULE_root = 0, RULE_projectName = 1, RULE_statements = 2, RULE_statement = 3, 
		RULE_time = 4, RULE_timestamp = 5, RULE_variable = 6, RULE_add = 7, RULE_video = 8, 
		RULE_caption = 9, RULE_image = 10, RULE_offset = 11, RULE_duration = 12, 
		RULE_combine = 13, RULE_cut = 14, RULE_stack = 15, RULE_overlay = 16, 
		RULE_adjustVolume = 17, RULE_transition = 18, RULE_crop = 19, RULE_cropOptions = 20, 
		RULE_freeze = 21, RULE_resize = 22, RULE_dimensions = 23, RULE_percentage = 24, 
		RULE_rotate = 25, RULE_slow = 26, RULE_accelerate = 27, RULE_position = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "projectName", "statements", "statement", "time", "timestamp", 
			"variable", "add", "video", "caption", "image", "offset", "duration", 
			"combine", "cut", "stack", "overlay", "adjustVolume", "transition", "crop", 
			"cropOptions", "freeze", "resize", "dimensions", "percentage", "rotate", 
			"slow", "accelerate", "position"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Project'", "'at'", "'fps'", "'resolution'", "'s'", "'add'", "'and'", 
			"'as'", "'caption'", "'image'", "'on'", "'wait'", "'for'", "'combine'", 
			"'cut'", "'from'", "'to'", "'stack'", "'('", "','", "')'", "'scale'", 
			"'overlay'", "'adjust'", "'volume'", "'of'", "'transition'", "'fadeIn'", 
			"'fadeOut'", "'duration'", "'crop'", "'freeze'", "'resize'", "'x'", "'%'", 
			"'rotate'", "'by'", "'slow'", "'accelerate'", "'top'", "'bottom'", "'left'", 
			"'right'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "IDENTIFIER", "STRING", 
			"TIME", "NUMBER", "FLOAT", "NEWLINE", "WS", "COMMENT", "DIGIT"
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
			setState(58);
			projectName();
			setState(59);
			statements();
			setState(60);
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
			setState(62);
			match(T__0);
			setState(63);
			match(IDENTIFIER);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(64);
				match(T__1);
				setState(65);
				match(NUMBER);
				setState(66);
				match(T__2);
				}
			}

			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(69);
				match(T__3);
				setState(70);
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
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(73);
				statement();
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 908545279552L) != 0) );
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
		public ImageContext image() {
			return getRuleContext(ImageContext.class,0);
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
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				caption();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				image();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				combine();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				add();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				cut();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				stack();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
				transition();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 8);
				{
				setState(85);
				overlay();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 9);
				{
				setState(86);
				adjustVolume();
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 10);
				{
				setState(87);
				crop();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 11);
				{
				setState(88);
				freeze();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 12);
				{
				setState(89);
				resize();
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 13);
				{
				setState(90);
				rotate();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 14);
				{
				setState(91);
				slow();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 15);
				{
				setState(92);
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
			setState(95);
			match(NUMBER);
			setState(96);
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
			setState(98);
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
			setState(100);
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
			setState(102);
			match(T__5);
			setState(103);
			video();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(104);
				match(T__6);
				setState(105);
				video();
				}
				}
				setState(110);
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
			setState(111);
			match(STRING);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(112);
				match(T__7);
				setState(113);
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
			setState(116);
			match(T__8);
			setState(117);
			match(STRING);
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(118);
				offset();
				}
				break;
			case T__12:
				{
				setState(119);
				duration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(122);
				match(T__7);
				setState(123);
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
	public static class ImageContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(VideoMLParser.STRING, 0); }
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(VideoMLParser.IDENTIFIER, 0); }
		public ImageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_image; }
	}

	public final ImageContext image() throws RecognitionException {
		ImageContext _localctx = new ImageContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_image);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__9);
			setState(127);
			match(STRING);
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(128);
				offset();
				}
				break;
			case T__12:
				{
				setState(129);
				duration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(132);
				match(T__7);
				setState(133);
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
		enterRule(_localctx, 22, RULE_offset);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__10);
			setState(137);
			variable();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(138);
				match(T__11);
				setState(139);
				time();
				}
			}

			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(142);
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
		enterRule(_localctx, 24, RULE_duration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__12);
			setState(146);
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
		enterRule(_localctx, 26, RULE_combine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__13);
			setState(149);
			variable();
			setState(152); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(150);
				match(T__6);
				setState(151);
				variable();
				}
				}
				setState(154); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
			setState(156);
			match(T__7);
			setState(157);
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
		enterRule(_localctx, 28, RULE_cut);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__14);
			setState(160);
			variable();
			setState(161);
			match(T__15);
			setState(162);
			time();
			setState(163);
			match(T__16);
			setState(164);
			time();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(165);
				match(T__7);
				setState(166);
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
		enterRule(_localctx, 30, RULE_stack);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__17);
			setState(170);
			variable();
			setState(171);
			match(T__10);
			setState(172);
			variable();
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(173);
				match(T__1);
				setState(174);
				match(T__18);
				setState(175);
				position();
				setState(176);
				match(T__19);
				setState(177);
				position();
				setState(178);
				match(T__20);
				}
			}

			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(182);
				match(T__21);
				setState(183);
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
		enterRule(_localctx, 32, RULE_overlay);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__22);
			setState(187);
			match(IDENTIFIER);
			setState(188);
			match(T__10);
			setState(189);
			match(STRING);
			setState(190);
			match(T__1);
			setState(191);
			timestamp();
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(192);
				match(T__7);
				setState(193);
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
		enterRule(_localctx, 34, RULE_adjustVolume);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__23);
			setState(197);
			match(T__24);
			setState(198);
			match(T__25);
			setState(199);
			match(STRING);
			setState(200);
			match(T__16);
			setState(201);
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
		enterRule(_localctx, 36, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__26);
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
				{
				setState(204);
				((TransitionContext)_localctx).fadeIn = match(T__27);
				}
				break;
			case T__28:
				{
				setState(205);
				((TransitionContext)_localctx).fadeOut = match(T__28);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(208);
			match(T__10);
			setState(209);
			match(IDENTIFIER);
			setState(210);
			match(T__29);
			setState(211);
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
		enterRule(_localctx, 38, RULE_crop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(T__30);
			setState(214);
			cropOptions();
			setState(215);
			match(T__25);
			setState(216);
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
		enterRule(_localctx, 40, RULE_cropOptions);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				((CropOptionsContext)_localctx).all = percentage();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				((CropOptionsContext)_localctx).leftRight = percentage();
				setState(220);
				((CropOptionsContext)_localctx).topBottom = percentage();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				((CropOptionsContext)_localctx).left = percentage();
				setState(223);
				((CropOptionsContext)_localctx).top = percentage();
				setState(224);
				((CropOptionsContext)_localctx).right = percentage();
				setState(225);
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
		enterRule(_localctx, 42, RULE_freeze);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__31);
			setState(230);
			match(IDENTIFIER);
			setState(231);
			match(T__1);
			setState(232);
			((FreezeContext)_localctx).start = time();
			setState(233);
			match(T__12);
			setState(234);
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
		enterRule(_localctx, 44, RULE_resize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(T__32);
			setState(237);
			match(IDENTIFIER);
			setState(238);
			match(T__16);
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(239);
				dimensions();
				}
				break;
			case 2:
				{
				setState(240);
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
		enterRule(_localctx, 46, RULE_dimensions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			((DimensionsContext)_localctx).width = match(NUMBER);
			setState(244);
			match(T__33);
			setState(245);
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
		enterRule(_localctx, 48, RULE_percentage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(NUMBER);
			setState(248);
			match(T__34);
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
		enterRule(_localctx, 50, RULE_rotate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(T__35);
			setState(251);
			match(IDENTIFIER);
			setState(252);
			match(T__36);
			setState(253);
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
		enterRule(_localctx, 52, RULE_slow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__37);
			setState(256);
			match(IDENTIFIER);
			setState(257);
			match(T__36);
			setState(258);
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
		enterRule(_localctx, 54, RULE_accelerate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__38);
			setState(261);
			match(IDENTIFIER);
			setState(262);
			match(T__36);
			setState(263);
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
		enterRule(_localctx, 56, RULE_position);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492674416640L) != 0)) ) {
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
		"\u0004\u00014\u010c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"D\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001H\b\u0001\u0001\u0002\u0004"+
		"\u0002K\b\u0002\u000b\u0002\f\u0002L\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003^\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007k\b\u0007\n\u0007\f\u0007n\t\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0003\bs\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\ty\b\t\u0001"+
		"\t\u0001\t\u0003\t}\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0083"+
		"\b\n\u0001\n\u0001\n\u0003\n\u0087\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u008d\b\u000b\u0001\u000b\u0003\u000b\u0090\b"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0004\r"+
		"\u0099\b\r\u000b\r\f\r\u009a\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00a8\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00b5\b\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00b9\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00c3\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00cf\b\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u00e4\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00f2\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0000"+
		"\u0000\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468\u0000\u0002\u0001\u0000,-\u0001"+
		"\u0000(+\u0110\u0000:\u0001\u0000\u0000\u0000\u0002>\u0001\u0000\u0000"+
		"\u0000\u0004J\u0001\u0000\u0000\u0000\u0006]\u0001\u0000\u0000\u0000\b"+
		"_\u0001\u0000\u0000\u0000\nb\u0001\u0000\u0000\u0000\fd\u0001\u0000\u0000"+
		"\u0000\u000ef\u0001\u0000\u0000\u0000\u0010o\u0001\u0000\u0000\u0000\u0012"+
		"t\u0001\u0000\u0000\u0000\u0014~\u0001\u0000\u0000\u0000\u0016\u0088\u0001"+
		"\u0000\u0000\u0000\u0018\u0091\u0001\u0000\u0000\u0000\u001a\u0094\u0001"+
		"\u0000\u0000\u0000\u001c\u009f\u0001\u0000\u0000\u0000\u001e\u00a9\u0001"+
		"\u0000\u0000\u0000 \u00ba\u0001\u0000\u0000\u0000\"\u00c4\u0001\u0000"+
		"\u0000\u0000$\u00cb\u0001\u0000\u0000\u0000&\u00d5\u0001\u0000\u0000\u0000"+
		"(\u00e3\u0001\u0000\u0000\u0000*\u00e5\u0001\u0000\u0000\u0000,\u00ec"+
		"\u0001\u0000\u0000\u0000.\u00f3\u0001\u0000\u0000\u00000\u00f7\u0001\u0000"+
		"\u0000\u00002\u00fa\u0001\u0000\u0000\u00004\u00ff\u0001\u0000\u0000\u0000"+
		"6\u0104\u0001\u0000\u0000\u00008\u0109\u0001\u0000\u0000\u0000:;\u0003"+
		"\u0002\u0001\u0000;<\u0003\u0004\u0002\u0000<=\u0005\u0000\u0000\u0001"+
		"=\u0001\u0001\u0000\u0000\u0000>?\u0005\u0001\u0000\u0000?C\u0005,\u0000"+
		"\u0000@A\u0005\u0002\u0000\u0000AB\u0005/\u0000\u0000BD\u0005\u0003\u0000"+
		"\u0000C@\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DG\u0001\u0000"+
		"\u0000\u0000EF\u0005\u0004\u0000\u0000FH\u0003.\u0017\u0000GE\u0001\u0000"+
		"\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0003\u0001\u0000\u0000\u0000"+
		"IK\u0003\u0006\u0003\u0000JI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000"+
		"\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000M\u0005\u0001"+
		"\u0000\u0000\u0000N^\u0003\u0012\t\u0000O^\u0003\u0014\n\u0000P^\u0003"+
		"\u001a\r\u0000Q^\u0003\u000e\u0007\u0000R^\u0003\u001c\u000e\u0000S^\u0003"+
		"\u001e\u000f\u0000T^\u0003$\u0012\u0000U^\u0003 \u0010\u0000V^\u0003\""+
		"\u0011\u0000W^\u0003&\u0013\u0000X^\u0003*\u0015\u0000Y^\u0003,\u0016"+
		"\u0000Z^\u00032\u0019\u0000[^\u00034\u001a\u0000\\^\u00036\u001b\u0000"+
		"]N\u0001\u0000\u0000\u0000]O\u0001\u0000\u0000\u0000]P\u0001\u0000\u0000"+
		"\u0000]Q\u0001\u0000\u0000\u0000]R\u0001\u0000\u0000\u0000]S\u0001\u0000"+
		"\u0000\u0000]T\u0001\u0000\u0000\u0000]U\u0001\u0000\u0000\u0000]V\u0001"+
		"\u0000\u0000\u0000]W\u0001\u0000\u0000\u0000]X\u0001\u0000\u0000\u0000"+
		"]Y\u0001\u0000\u0000\u0000]Z\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000]\\\u0001\u0000\u0000\u0000^\u0007\u0001\u0000\u0000\u0000_`\u0005"+
		"/\u0000\u0000`a\u0005\u0005\u0000\u0000a\t\u0001\u0000\u0000\u0000bc\u0005"+
		".\u0000\u0000c\u000b\u0001\u0000\u0000\u0000de\u0007\u0000\u0000\u0000"+
		"e\r\u0001\u0000\u0000\u0000fg\u0005\u0006\u0000\u0000gl\u0003\u0010\b"+
		"\u0000hi\u0005\u0007\u0000\u0000ik\u0003\u0010\b\u0000jh\u0001\u0000\u0000"+
		"\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000m\u000f\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000"+
		"or\u0005-\u0000\u0000pq\u0005\b\u0000\u0000qs\u0005,\u0000\u0000rp\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0011\u0001\u0000\u0000"+
		"\u0000tu\u0005\t\u0000\u0000ux\u0005-\u0000\u0000vy\u0003\u0016\u000b"+
		"\u0000wy\u0003\u0018\f\u0000xv\u0001\u0000\u0000\u0000xw\u0001\u0000\u0000"+
		"\u0000y|\u0001\u0000\u0000\u0000z{\u0005\b\u0000\u0000{}\u0005,\u0000"+
		"\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0013\u0001"+
		"\u0000\u0000\u0000~\u007f\u0005\n\u0000\u0000\u007f\u0082\u0005-\u0000"+
		"\u0000\u0080\u0083\u0003\u0016\u000b\u0000\u0081\u0083\u0003\u0018\f\u0000"+
		"\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000"+
		"\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0085\u0005\b\u0000\u0000\u0085"+
		"\u0087\u0005,\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0001\u0000\u0000\u0000\u0087\u0015\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0005\u000b\u0000\u0000\u0089\u008c\u0003\f\u0006\u0000\u008a\u008b\u0005"+
		"\f\u0000\u0000\u008b\u008d\u0003\b\u0004\u0000\u008c\u008a\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008f\u0001\u0000"+
		"\u0000\u0000\u008e\u0090\u0003\u0018\f\u0000\u008f\u008e\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0017\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0005\r\u0000\u0000\u0092\u0093\u0003\b\u0004\u0000"+
		"\u0093\u0019\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u000e\u0000\u0000"+
		"\u0095\u0098\u0003\f\u0006\u0000\u0096\u0097\u0005\u0007\u0000\u0000\u0097"+
		"\u0099\u0003\f\u0006\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0005\b\u0000\u0000\u009d\u009e\u0005,\u0000\u0000\u009e\u001b\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0005\u000f\u0000\u0000\u00a0\u00a1\u0003"+
		"\f\u0006\u0000\u00a1\u00a2\u0005\u0010\u0000\u0000\u00a2\u00a3\u0003\b"+
		"\u0004\u0000\u00a3\u00a4\u0005\u0011\u0000\u0000\u00a4\u00a7\u0003\b\u0004"+
		"\u0000\u00a5\u00a6\u0005\b\u0000\u0000\u00a6\u00a8\u0005,\u0000\u0000"+
		"\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8\u001d\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0012\u0000\u0000"+
		"\u00aa\u00ab\u0003\f\u0006\u0000\u00ab\u00ac\u0005\u000b\u0000\u0000\u00ac"+
		"\u00b4\u0003\f\u0006\u0000\u00ad\u00ae\u0005\u0002\u0000\u0000\u00ae\u00af"+
		"\u0005\u0013\u0000\u0000\u00af\u00b0\u00038\u001c\u0000\u00b0\u00b1\u0005"+
		"\u0014\u0000\u0000\u00b1\u00b2\u00038\u001c\u0000\u00b2\u00b3\u0005\u0015"+
		"\u0000\u0000\u00b3\u00b5\u0001\u0000\u0000\u0000\u00b4\u00ad\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0005\u0016\u0000\u0000\u00b7\u00b9\u00050\u0000"+
		"\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b9\u001f\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u0017\u0000"+
		"\u0000\u00bb\u00bc\u0005,\u0000\u0000\u00bc\u00bd\u0005\u000b\u0000\u0000"+
		"\u00bd\u00be\u0005-\u0000\u0000\u00be\u00bf\u0005\u0002\u0000\u0000\u00bf"+
		"\u00c2\u0003\n\u0005\u0000\u00c0\u00c1\u0005\b\u0000\u0000\u00c1\u00c3"+
		"\u0005,\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c3!\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u0018"+
		"\u0000\u0000\u00c5\u00c6\u0005\u0019\u0000\u0000\u00c6\u00c7\u0005\u001a"+
		"\u0000\u0000\u00c7\u00c8\u0005-\u0000\u0000\u00c8\u00c9\u0005\u0011\u0000"+
		"\u0000\u00c9\u00ca\u0005/\u0000\u0000\u00ca#\u0001\u0000\u0000\u0000\u00cb"+
		"\u00ce\u0005\u001b\u0000\u0000\u00cc\u00cf\u0005\u001c\u0000\u0000\u00cd"+
		"\u00cf\u0005\u001d\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0005\u000b\u0000\u0000\u00d1\u00d2\u0005,\u0000\u0000\u00d2\u00d3"+
		"\u0005\u001e\u0000\u0000\u00d3\u00d4\u0003\b\u0004\u0000\u00d4%\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0005\u001f\u0000\u0000\u00d6\u00d7\u0003"+
		"(\u0014\u0000\u00d7\u00d8\u0005\u001a\u0000\u0000\u00d8\u00d9\u0005,\u0000"+
		"\u0000\u00d9\'\u0001\u0000\u0000\u0000\u00da\u00e4\u00030\u0018\u0000"+
		"\u00db\u00dc\u00030\u0018\u0000\u00dc\u00dd\u00030\u0018\u0000\u00dd\u00e4"+
		"\u0001\u0000\u0000\u0000\u00de\u00df\u00030\u0018\u0000\u00df\u00e0\u0003"+
		"0\u0018\u0000\u00e0\u00e1\u00030\u0018\u0000\u00e1\u00e2\u00030\u0018"+
		"\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00da\u0001\u0000\u0000"+
		"\u0000\u00e3\u00db\u0001\u0000\u0000\u0000\u00e3\u00de\u0001\u0000\u0000"+
		"\u0000\u00e4)\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005 \u0000\u0000\u00e6"+
		"\u00e7\u0005,\u0000\u0000\u00e7\u00e8\u0005\u0002\u0000\u0000\u00e8\u00e9"+
		"\u0003\b\u0004\u0000\u00e9\u00ea\u0005\r\u0000\u0000\u00ea\u00eb\u0003"+
		"\b\u0004\u0000\u00eb+\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005!\u0000"+
		"\u0000\u00ed\u00ee\u0005,\u0000\u0000\u00ee\u00f1\u0005\u0011\u0000\u0000"+
		"\u00ef\u00f2\u0003.\u0017\u0000\u00f0\u00f2\u00030\u0018\u0000\u00f1\u00ef"+
		"\u0001\u0000\u0000\u0000\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f2-\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f4\u0005/\u0000\u0000\u00f4\u00f5\u0005\""+
		"\u0000\u0000\u00f5\u00f6\u0005/\u0000\u0000\u00f6/\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f8\u0005/\u0000\u0000\u00f8\u00f9\u0005#\u0000\u0000\u00f91"+
		"\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005$\u0000\u0000\u00fb\u00fc\u0005"+
		",\u0000\u0000\u00fc\u00fd\u0005%\u0000\u0000\u00fd\u00fe\u0005/\u0000"+
		"\u0000\u00fe3\u0001\u0000\u0000\u0000\u00ff\u0100\u0005&\u0000\u0000\u0100"+
		"\u0101\u0005,\u0000\u0000\u0101\u0102\u0005%\u0000\u0000\u0102\u0103\u0003"+
		"0\u0018\u0000\u01035\u0001\u0000\u0000\u0000\u0104\u0105\u0005\'\u0000"+
		"\u0000\u0105\u0106\u0005,\u0000\u0000\u0106\u0107\u0005%\u0000\u0000\u0107"+
		"\u0108\u00030\u0018\u0000\u01087\u0001\u0000\u0000\u0000\u0109\u010a\u0007"+
		"\u0001\u0000\u0000\u010a9\u0001\u0000\u0000\u0000\u0014CGL]lrx|\u0082"+
		"\u0086\u008c\u008f\u009a\u00a7\u00b4\u00b8\u00c2\u00ce\u00e3\u00f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}