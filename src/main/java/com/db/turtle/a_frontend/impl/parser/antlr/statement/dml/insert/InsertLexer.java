// Generated from src/main/java/com/db/turtle/parser/antlr/statement/dml/insert/Insert.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.insert;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class InsertLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INSERT=1, INTO=2, VALUES=3, NULL=4, TRUE=5, FALSE=6, LPAREN=7, RPAREN=8, 
		COMMA=9, IDENTIFIER=10, NUMBER=11, STRING=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INSERT", "INTO", "VALUES", "NULL", "TRUE", "FALSE", "LPAREN", "RPAREN", 
			"COMMA", "IDENTIFIER", "NUMBER", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'INSERT'", "'INTO'", "'VALUES'", "'NULL'", "'TRUE'", "'FALSE'", 
			"'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INSERT", "INTO", "VALUES", "NULL", "TRUE", "FALSE", "LPAREN", 
			"RPAREN", "COMMA", "IDENTIFIER", "NUMBER", "STRING", "WS"
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


	public InsertLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Insert.g4"; }

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
		"\u0004\u0000\rj\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0005\tG\b\t\n\t\f\tJ\t\t\u0001\n\u0004\nM"+
		"\b\n\u000b\n\f\nN\u0001\n\u0001\n\u0004\nS\b\n\u000b\n\f\nT\u0003\nW\b"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b]\b\u000b"+
		"\n\u000b\f\u000b`\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0004\fe\b\f"+
		"\u000b\f\f\ff\u0001\f\u0001\f\u0000\u0000\r\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u0001\u0000\u0005\u0003\u0000AZ__az\u0004"+
		"\u000009AZ__az\u0001\u000009\u0002\u0000\'\'\\\\\u0003\u0000\t\n\r\r "+
		" p\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0001\u001b\u0001\u0000\u0000\u0000\u0003\"\u0001"+
		"\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000\u0007.\u0001\u0000"+
		"\u0000\u0000\t3\u0001\u0000\u0000\u0000\u000b8\u0001\u0000\u0000\u0000"+
		"\r>\u0001\u0000\u0000\u0000\u000f@\u0001\u0000\u0000\u0000\u0011B\u0001"+
		"\u0000\u0000\u0000\u0013D\u0001\u0000\u0000\u0000\u0015L\u0001\u0000\u0000"+
		"\u0000\u0017X\u0001\u0000\u0000\u0000\u0019d\u0001\u0000\u0000\u0000\u001b"+
		"\u001c\u0005I\u0000\u0000\u001c\u001d\u0005N\u0000\u0000\u001d\u001e\u0005"+
		"S\u0000\u0000\u001e\u001f\u0005E\u0000\u0000\u001f \u0005R\u0000\u0000"+
		" !\u0005T\u0000\u0000!\u0002\u0001\u0000\u0000\u0000\"#\u0005I\u0000\u0000"+
		"#$\u0005N\u0000\u0000$%\u0005T\u0000\u0000%&\u0005O\u0000\u0000&\u0004"+
		"\u0001\u0000\u0000\u0000\'(\u0005V\u0000\u0000()\u0005A\u0000\u0000)*"+
		"\u0005L\u0000\u0000*+\u0005U\u0000\u0000+,\u0005E\u0000\u0000,-\u0005"+
		"S\u0000\u0000-\u0006\u0001\u0000\u0000\u0000./\u0005N\u0000\u0000/0\u0005"+
		"U\u0000\u000001\u0005L\u0000\u000012\u0005L\u0000\u00002\b\u0001\u0000"+
		"\u0000\u000034\u0005T\u0000\u000045\u0005R\u0000\u000056\u0005U\u0000"+
		"\u000067\u0005E\u0000\u00007\n\u0001\u0000\u0000\u000089\u0005F\u0000"+
		"\u00009:\u0005A\u0000\u0000:;\u0005L\u0000\u0000;<\u0005S\u0000\u0000"+
		"<=\u0005E\u0000\u0000=\f\u0001\u0000\u0000\u0000>?\u0005(\u0000\u0000"+
		"?\u000e\u0001\u0000\u0000\u0000@A\u0005)\u0000\u0000A\u0010\u0001\u0000"+
		"\u0000\u0000BC\u0005,\u0000\u0000C\u0012\u0001\u0000\u0000\u0000DH\u0007"+
		"\u0000\u0000\u0000EG\u0007\u0001\u0000\u0000FE\u0001\u0000\u0000\u0000"+
		"GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000"+
		"\u0000I\u0014\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KM\u0007"+
		"\u0002\u0000\u0000LK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"+
		"NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OV\u0001\u0000\u0000"+
		"\u0000PR\u0005.\u0000\u0000QS\u0007\u0002\u0000\u0000RQ\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UW\u0001\u0000\u0000\u0000VP\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000W\u0016\u0001\u0000\u0000\u0000X^\u0005\'\u0000\u0000"+
		"Y]\b\u0003\u0000\u0000Z[\u0005\\\u0000\u0000[]\t\u0000\u0000\u0000\\Y"+
		"\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_a\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000ab\u0005\'\u0000\u0000b\u0018\u0001"+
		"\u0000\u0000\u0000ce\u0007\u0004\u0000\u0000dc\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000hi\u0006\f\u0000\u0000i\u001a\u0001\u0000"+
		"\u0000\u0000\b\u0000HNTV\\^f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}