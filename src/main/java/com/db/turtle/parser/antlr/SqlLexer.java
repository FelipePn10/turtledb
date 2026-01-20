package com.db.turtle.parser.antlr;// Generated from src/main/java/com/db/turtle/antlr/Sql.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SqlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, SELECT=5, FROM=6, WHERE=7, STAR=8, IDENTIFIER=9, 
		NUMBER=10, STRING=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "SELECT", "FROM", "WHERE", "STAR", "IDENTIFIER", 
			"NUMBER", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'>'", "'<'", "'SELECT'", "'FROM'", "'WHERE'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "SELECT", "FROM", "WHERE", "STAR", "IDENTIFIER", 
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


	public SqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Sql.g4"; }

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
		"\u0004\u0000\fQ\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0005\b8\b\b\n\b\f\b;\t\b\u0001\t\u0004\t>\b\t\u000b\t\f\t?\u0001\n"+
		"\u0001\n\u0005\nD\b\n\n\n\f\nG\t\n\u0001\n\u0001\n\u0001\u000b\u0004\u000b"+
		"L\b\u000b\u000b\u000b\f\u000bM\u0001\u000b\u0001\u000b\u0001E\u0000\f"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0001\u0000\u0004\u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0003\u0000\t\n\r\r  T"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0001\u0019"+
		"\u0001\u0000\u0000\u0000\u0003\u001b\u0001\u0000\u0000\u0000\u0005\u001d"+
		"\u0001\u0000\u0000\u0000\u0007\u001f\u0001\u0000\u0000\u0000\t!\u0001"+
		"\u0000\u0000\u0000\u000b(\u0001\u0000\u0000\u0000\r-\u0001\u0000\u0000"+
		"\u0000\u000f3\u0001\u0000\u0000\u0000\u00115\u0001\u0000\u0000\u0000\u0013"+
		"=\u0001\u0000\u0000\u0000\u0015A\u0001\u0000\u0000\u0000\u0017K\u0001"+
		"\u0000\u0000\u0000\u0019\u001a\u0005,\u0000\u0000\u001a\u0002\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0005=\u0000\u0000\u001c\u0004\u0001\u0000\u0000"+
		"\u0000\u001d\u001e\u0005>\u0000\u0000\u001e\u0006\u0001\u0000\u0000\u0000"+
		"\u001f \u0005<\u0000\u0000 \b\u0001\u0000\u0000\u0000!\"\u0005S\u0000"+
		"\u0000\"#\u0005E\u0000\u0000#$\u0005L\u0000\u0000$%\u0005E\u0000\u0000"+
		"%&\u0005C\u0000\u0000&\'\u0005T\u0000\u0000\'\n\u0001\u0000\u0000\u0000"+
		"()\u0005F\u0000\u0000)*\u0005R\u0000\u0000*+\u0005O\u0000\u0000+,\u0005"+
		"M\u0000\u0000,\f\u0001\u0000\u0000\u0000-.\u0005W\u0000\u0000./\u0005"+
		"H\u0000\u0000/0\u0005E\u0000\u000001\u0005R\u0000\u000012\u0005E\u0000"+
		"\u00002\u000e\u0001\u0000\u0000\u000034\u0005*\u0000\u00004\u0010\u0001"+
		"\u0000\u0000\u000059\u0007\u0000\u0000\u000068\u0007\u0001\u0000\u0000"+
		"76\u0001\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000"+
		"\u00009:\u0001\u0000\u0000\u0000:\u0012\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000<>\u0007\u0002\u0000\u0000=<\u0001\u0000\u0000\u0000"+
		">?\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@\u0014\u0001\u0000\u0000\u0000AE\u0005\'\u0000\u0000BD\t\u0000"+
		"\u0000\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000HI\u0005\'\u0000\u0000I\u0016\u0001\u0000\u0000"+
		"\u0000JL\u0007\u0003\u0000\u0000KJ\u0001\u0000\u0000\u0000LM\u0001\u0000"+
		"\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0001"+
		"\u0000\u0000\u0000OP\u0006\u000b\u0000\u0000P\u0018\u0001\u0000\u0000"+
		"\u0000\u0005\u00009?EM\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}