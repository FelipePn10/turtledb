// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/create/index/CreateIndex.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.index;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CreateIndexLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CREATE=1, INDEX=2, UNIQUE=3, ON=4, LPAREN=5, RPAREN=6, COMMA=7, IDENTIFIER=8, 
		WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CREATE", "INDEX", "UNIQUE", "ON", "LPAREN", "RPAREN", "COMMA", "IDENTIFIER", 
			"WS", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CREATE", "INDEX", "UNIQUE", "ON", "LPAREN", "RPAREN", "COMMA", 
			"IDENTIFIER", "WS"
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


	public CreateIndexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CreateIndex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\t\u00a6\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0005\u0007g\b\u0007\n\u0007\f\u0007j\t"+
		"\u0007\u0001\b\u0004\bm\b\b\u000b\b\f\bn\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0000\u0000#\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\u0000\u0015\u0000\u0017\u0000\u0019\u0000\u001b\u0000"+
		"\u001d\u0000\u001f\u0000!\u0000#\u0000%\u0000\'\u0000)\u0000+\u0000-\u0000"+
		"/\u00001\u00003\u00005\u00007\u00009\u0000;\u0000=\u0000?\u0000A\u0000"+
		"C\u0000E\u0000\u0001\u0000\u001d\u0003\u0000AZ__az\u0004\u000009AZ__a"+
		"z\u0003\u0000\t\n\r\r  \u0002\u0000AAaa\u0002\u0000BBbb\u0002\u0000CC"+
		"cc\u0002\u0000DDdd\u0002\u0000EEee\u0002\u0000FFff\u0002\u0000GGgg\u0002"+
		"\u0000HHhh\u0002\u0000IIii\u0002\u0000JJjj\u0002\u0000KKkk\u0002\u0000"+
		"LLll\u0002\u0000MMmm\u0002\u0000NNnn\u0002\u0000OOoo\u0002\u0000PPpp\u0002"+
		"\u0000QQqq\u0002\u0000RRrr\u0002\u0000SSss\u0002\u0000TTtt\u0002\u0000"+
		"UUuu\u0002\u0000VVvv\u0002\u0000WWww\u0002\u0000XXxx\u0002\u0000YYyy\u0002"+
		"\u0000ZZzz\u008d\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0001G\u0001\u0000\u0000\u0000"+
		"\u0003N\u0001\u0000\u0000\u0000\u0005T\u0001\u0000\u0000\u0000\u0007["+
		"\u0001\u0000\u0000\u0000\t^\u0001\u0000\u0000\u0000\u000b`\u0001\u0000"+
		"\u0000\u0000\rb\u0001\u0000\u0000\u0000\u000fd\u0001\u0000\u0000\u0000"+
		"\u0011l\u0001\u0000\u0000\u0000\u0013r\u0001\u0000\u0000\u0000\u0015t"+
		"\u0001\u0000\u0000\u0000\u0017v\u0001\u0000\u0000\u0000\u0019x\u0001\u0000"+
		"\u0000\u0000\u001bz\u0001\u0000\u0000\u0000\u001d|\u0001\u0000\u0000\u0000"+
		"\u001f~\u0001\u0000\u0000\u0000!\u0080\u0001\u0000\u0000\u0000#\u0082"+
		"\u0001\u0000\u0000\u0000%\u0084\u0001\u0000\u0000\u0000\'\u0086\u0001"+
		"\u0000\u0000\u0000)\u0088\u0001\u0000\u0000\u0000+\u008a\u0001\u0000\u0000"+
		"\u0000-\u008c\u0001\u0000\u0000\u0000/\u008e\u0001\u0000\u0000\u00001"+
		"\u0090\u0001\u0000\u0000\u00003\u0092\u0001\u0000\u0000\u00005\u0094\u0001"+
		"\u0000\u0000\u00007\u0096\u0001\u0000\u0000\u00009\u0098\u0001\u0000\u0000"+
		"\u0000;\u009a\u0001\u0000\u0000\u0000=\u009c\u0001\u0000\u0000\u0000?"+
		"\u009e\u0001\u0000\u0000\u0000A\u00a0\u0001\u0000\u0000\u0000C\u00a2\u0001"+
		"\u0000\u0000\u0000E\u00a4\u0001\u0000\u0000\u0000GH\u0003\u0017\u000b"+
		"\u0000HI\u00035\u001a\u0000IJ\u0003\u001b\r\u0000JK\u0003\u0013\t\u0000"+
		"KL\u00039\u001c\u0000LM\u0003\u001b\r\u0000M\u0002\u0001\u0000\u0000\u0000"+
		"NO\u0003#\u0011\u0000OP\u0003-\u0016\u0000PQ\u0003\u0019\f\u0000QR\u0003"+
		"\u001b\r\u0000RS\u0003A \u0000S\u0004\u0001\u0000\u0000\u0000TU\u0003"+
		";\u001d\u0000UV\u0003-\u0016\u0000VW\u0003#\u0011\u0000WX\u00033\u0019"+
		"\u0000XY\u0003;\u001d\u0000YZ\u0003\u001b\r\u0000Z\u0006\u0001\u0000\u0000"+
		"\u0000[\\\u0003/\u0017\u0000\\]\u0003-\u0016\u0000]\b\u0001\u0000\u0000"+
		"\u0000^_\u0005(\u0000\u0000_\n\u0001\u0000\u0000\u0000`a\u0005)\u0000"+
		"\u0000a\f\u0001\u0000\u0000\u0000bc\u0005,\u0000\u0000c\u000e\u0001\u0000"+
		"\u0000\u0000dh\u0007\u0000\u0000\u0000eg\u0007\u0001\u0000\u0000fe\u0001"+
		"\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000"+
		"hi\u0001\u0000\u0000\u0000i\u0010\u0001\u0000\u0000\u0000jh\u0001\u0000"+
		"\u0000\u0000km\u0007\u0002\u0000\u0000lk\u0001\u0000\u0000\u0000mn\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000pq\u0006\b\u0000\u0000q\u0012\u0001\u0000\u0000"+
		"\u0000rs\u0007\u0003\u0000\u0000s\u0014\u0001\u0000\u0000\u0000tu\u0007"+
		"\u0004\u0000\u0000u\u0016\u0001\u0000\u0000\u0000vw\u0007\u0005\u0000"+
		"\u0000w\u0018\u0001\u0000\u0000\u0000xy\u0007\u0006\u0000\u0000y\u001a"+
		"\u0001\u0000\u0000\u0000z{\u0007\u0007\u0000\u0000{\u001c\u0001\u0000"+
		"\u0000\u0000|}\u0007\b\u0000\u0000}\u001e\u0001\u0000\u0000\u0000~\u007f"+
		"\u0007\t\u0000\u0000\u007f \u0001\u0000\u0000\u0000\u0080\u0081\u0007"+
		"\n\u0000\u0000\u0081\"\u0001\u0000\u0000\u0000\u0082\u0083\u0007\u000b"+
		"\u0000\u0000\u0083$\u0001\u0000\u0000\u0000\u0084\u0085\u0007\f\u0000"+
		"\u0000\u0085&\u0001\u0000\u0000\u0000\u0086\u0087\u0007\r\u0000\u0000"+
		"\u0087(\u0001\u0000\u0000\u0000\u0088\u0089\u0007\u000e\u0000\u0000\u0089"+
		"*\u0001\u0000\u0000\u0000\u008a\u008b\u0007\u000f\u0000\u0000\u008b,\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0007\u0010\u0000\u0000\u008d.\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0007\u0011\u0000\u0000\u008f0\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0007\u0012\u0000\u0000\u00912\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0007\u0013\u0000\u0000\u00934\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0007\u0014\u0000\u0000\u00956\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0007\u0015\u0000\u0000\u00978\u0001\u0000\u0000\u0000\u0098\u0099\u0007"+
		"\u0016\u0000\u0000\u0099:\u0001\u0000\u0000\u0000\u009a\u009b\u0007\u0017"+
		"\u0000\u0000\u009b<\u0001\u0000\u0000\u0000\u009c\u009d\u0007\u0018\u0000"+
		"\u0000\u009d>\u0001\u0000\u0000\u0000\u009e\u009f\u0007\u0019\u0000\u0000"+
		"\u009f@\u0001\u0000\u0000\u0000\u00a0\u00a1\u0007\u001a\u0000\u0000\u00a1"+
		"B\u0001\u0000\u0000\u0000\u00a2\u00a3\u0007\u001b\u0000\u0000\u00a3D\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0007\u001c\u0000\u0000\u00a5F\u0001\u0000"+
		"\u0000\u0000\u0003\u0000hn\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}