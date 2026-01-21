// Generated from src/main/java/com/db/turtle/parser/antlr/statement/Select.g4 by ANTLR 4.13.1

package com.db.turtle.parser.antlr.statement;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SelectLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, FROM=2, WHERE=3, AND=4, OR=5, NULL=6, STAR=7, COMMA=8, LEFT_PAREN=9, 
		RIGHT_PAREN=10, EQ=11, GT=12, GE=13, LT=14, LE=15, NE=16, IDENTIFIER=17, 
		NUMBER=18, STRING=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SELECT", "FROM", "WHERE", "AND", "OR", "NULL", "STAR", "COMMA", "LEFT_PAREN", 
			"RIGHT_PAREN", "EQ", "GT", "GE", "LT", "LE", "NE", "IDENTIFIER", "NUMBER", 
			"STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'SELECT'", "'FROM'", "'WHERE'", "'AND'", "'OR'", "'NULL'", "'*'", 
			"','", "'('", "')'", "'='", "'>'", "'>='", "'<'", "'<='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SELECT", "FROM", "WHERE", "AND", "OR", "NULL", "STAR", "COMMA", 
			"LEFT_PAREN", "RIGHT_PAREN", "EQ", "GT", "GE", "LT", "LE", "NE", "IDENTIFIER", 
			"NUMBER", "STRING", "WS"
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


	public SelectLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Select.g4"; }

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
		"\u0004\u0000\u0014\u0084\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0005\u0010a\b\u0010\n\u0010\f\u0010d\t\u0010\u0001"+
		"\u0011\u0004\u0011g\b\u0011\u000b\u0011\f\u0011h\u0001\u0011\u0001\u0011"+
		"\u0004\u0011m\b\u0011\u000b\u0011\f\u0011n\u0003\u0011q\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012w\b\u0012\n\u0012"+
		"\f\u0012z\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0004\u0013\u007f"+
		"\b\u0013\u000b\u0013\f\u0013\u0080\u0001\u0013\u0001\u0013\u0000\u0000"+
		"\u0014\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014\u0001\u0000\u0005"+
		"\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0002\u0000\'\'\\"+
		"\\\u0003\u0000\t\n\r\r  \u008a\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0001)\u0001\u0000\u0000\u0000\u00030\u0001\u0000\u0000\u0000\u00055"+
		"\u0001\u0000\u0000\u0000\u0007;\u0001\u0000\u0000\u0000\t?\u0001\u0000"+
		"\u0000\u0000\u000bB\u0001\u0000\u0000\u0000\rG\u0001\u0000\u0000\u0000"+
		"\u000fI\u0001\u0000\u0000\u0000\u0011K\u0001\u0000\u0000\u0000\u0013M"+
		"\u0001\u0000\u0000\u0000\u0015O\u0001\u0000\u0000\u0000\u0017Q\u0001\u0000"+
		"\u0000\u0000\u0019S\u0001\u0000\u0000\u0000\u001bV\u0001\u0000\u0000\u0000"+
		"\u001dX\u0001\u0000\u0000\u0000\u001f[\u0001\u0000\u0000\u0000!^\u0001"+
		"\u0000\u0000\u0000#f\u0001\u0000\u0000\u0000%r\u0001\u0000\u0000\u0000"+
		"\'~\u0001\u0000\u0000\u0000)*\u0005S\u0000\u0000*+\u0005E\u0000\u0000"+
		"+,\u0005L\u0000\u0000,-\u0005E\u0000\u0000-.\u0005C\u0000\u0000./\u0005"+
		"T\u0000\u0000/\u0002\u0001\u0000\u0000\u000001\u0005F\u0000\u000012\u0005"+
		"R\u0000\u000023\u0005O\u0000\u000034\u0005M\u0000\u00004\u0004\u0001\u0000"+
		"\u0000\u000056\u0005W\u0000\u000067\u0005H\u0000\u000078\u0005E\u0000"+
		"\u000089\u0005R\u0000\u00009:\u0005E\u0000\u0000:\u0006\u0001\u0000\u0000"+
		"\u0000;<\u0005A\u0000\u0000<=\u0005N\u0000\u0000=>\u0005D\u0000\u0000"+
		">\b\u0001\u0000\u0000\u0000?@\u0005O\u0000\u0000@A\u0005R\u0000\u0000"+
		"A\n\u0001\u0000\u0000\u0000BC\u0005N\u0000\u0000CD\u0005U\u0000\u0000"+
		"DE\u0005L\u0000\u0000EF\u0005L\u0000\u0000F\f\u0001\u0000\u0000\u0000"+
		"GH\u0005*\u0000\u0000H\u000e\u0001\u0000\u0000\u0000IJ\u0005,\u0000\u0000"+
		"J\u0010\u0001\u0000\u0000\u0000KL\u0005(\u0000\u0000L\u0012\u0001\u0000"+
		"\u0000\u0000MN\u0005)\u0000\u0000N\u0014\u0001\u0000\u0000\u0000OP\u0005"+
		"=\u0000\u0000P\u0016\u0001\u0000\u0000\u0000QR\u0005>\u0000\u0000R\u0018"+
		"\u0001\u0000\u0000\u0000ST\u0005>\u0000\u0000TU\u0005=\u0000\u0000U\u001a"+
		"\u0001\u0000\u0000\u0000VW\u0005<\u0000\u0000W\u001c\u0001\u0000\u0000"+
		"\u0000XY\u0005<\u0000\u0000YZ\u0005=\u0000\u0000Z\u001e\u0001\u0000\u0000"+
		"\u0000[\\\u0005!\u0000\u0000\\]\u0005=\u0000\u0000] \u0001\u0000\u0000"+
		"\u0000^b\u0007\u0000\u0000\u0000_a\u0007\u0001\u0000\u0000`_\u0001\u0000"+
		"\u0000\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001"+
		"\u0000\u0000\u0000c\"\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000"+
		"eg\u0007\u0002\u0000\u0000fe\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ip\u0001\u0000"+
		"\u0000\u0000jl\u0005.\u0000\u0000km\u0007\u0002\u0000\u0000lk\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001"+
		"\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000pj\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000q$\u0001\u0000\u0000\u0000rx\u0005\'\u0000\u0000"+
		"sw\b\u0003\u0000\u0000tu\u0005\\\u0000\u0000uw\t\u0000\u0000\u0000vs\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y{\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000{|\u0005\'\u0000\u0000|&\u0001\u0000\u0000"+
		"\u0000}\u007f\u0007\u0004\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0006\u0013\u0000\u0000\u0083(\u0001\u0000\u0000\u0000\b\u0000bhnpvx"+
		"\u0080\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}