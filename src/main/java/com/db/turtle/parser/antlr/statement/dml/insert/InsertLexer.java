// Generated from src/main/java/com/db/turtle/parser/antlr/statement/insert/Insert.g4 by ANTLR 4.13.1

package com.db.turtle.parser.antlr.statement.dml.insert;

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
		INSERT=1, INTO=2, VALUES=3, NULL=4, LPAREN=5, RPAREN=6, COMMA=7, IDENTIFIER=8, 
		NUMBER=9, STRING=10, WS=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INSERT", "INTO", "VALUES", "NULL", "LPAREN", "RPAREN", "COMMA", "IDENTIFIER", 
			"NUMBER", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'INSERT'", "'INTO'", "'VALUES'", "'NULL'", "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INSERT", "INTO", "VALUES", "NULL", "LPAREN", "RPAREN", "COMMA", 
			"IDENTIFIER", "NUMBER", "STRING", "WS"
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
		"\u0004\u0000\u000b[\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0005\u00078\b\u0007\n\u0007\f\u0007;\t\u0007\u0001\b\u0004"+
		"\b>\b\b\u000b\b\f\b?\u0001\b\u0001\b\u0004\bD\b\b\u000b\b\f\bE\u0003\b"+
		"H\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\tN\b\t\n\t\f\tQ\t\t\u0001"+
		"\t\u0001\t\u0001\n\u0004\nV\b\n\u000b\n\f\nW\u0001\n\u0001\n\u0000\u0000"+
		"\u000b\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0001\u0000\u0005\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0001\u000009\u0002\u0000\'\'\\\\\u0003\u0000"+
		"\t\n\r\r  a\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000"+
		"\u0003\u001e\u0001\u0000\u0000\u0000\u0005#\u0001\u0000\u0000\u0000\u0007"+
		"*\u0001\u0000\u0000\u0000\t/\u0001\u0000\u0000\u0000\u000b1\u0001\u0000"+
		"\u0000\u0000\r3\u0001\u0000\u0000\u0000\u000f5\u0001\u0000\u0000\u0000"+
		"\u0011=\u0001\u0000\u0000\u0000\u0013I\u0001\u0000\u0000\u0000\u0015U"+
		"\u0001\u0000\u0000\u0000\u0017\u0018\u0005I\u0000\u0000\u0018\u0019\u0005"+
		"N\u0000\u0000\u0019\u001a\u0005S\u0000\u0000\u001a\u001b\u0005E\u0000"+
		"\u0000\u001b\u001c\u0005R\u0000\u0000\u001c\u001d\u0005T\u0000\u0000\u001d"+
		"\u0002\u0001\u0000\u0000\u0000\u001e\u001f\u0005I\u0000\u0000\u001f \u0005"+
		"N\u0000\u0000 !\u0005T\u0000\u0000!\"\u0005O\u0000\u0000\"\u0004\u0001"+
		"\u0000\u0000\u0000#$\u0005V\u0000\u0000$%\u0005A\u0000\u0000%&\u0005L"+
		"\u0000\u0000&\'\u0005U\u0000\u0000\'(\u0005E\u0000\u0000()\u0005S\u0000"+
		"\u0000)\u0006\u0001\u0000\u0000\u0000*+\u0005N\u0000\u0000+,\u0005U\u0000"+
		"\u0000,-\u0005L\u0000\u0000-.\u0005L\u0000\u0000.\b\u0001\u0000\u0000"+
		"\u0000/0\u0005(\u0000\u00000\n\u0001\u0000\u0000\u000012\u0005)\u0000"+
		"\u00002\f\u0001\u0000\u0000\u000034\u0005,\u0000\u00004\u000e\u0001\u0000"+
		"\u0000\u000059\u0007\u0000\u0000\u000068\u0007\u0001\u0000\u000076\u0001"+
		"\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		"9:\u0001\u0000\u0000\u0000:\u0010\u0001\u0000\u0000\u0000;9\u0001\u0000"+
		"\u0000\u0000<>\u0007\u0002\u0000\u0000=<\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000"+
		"@G\u0001\u0000\u0000\u0000AC\u0005.\u0000\u0000BD\u0007\u0002\u0000\u0000"+
		"CB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000GA\u0001\u0000"+
		"\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0012\u0001\u0000\u0000\u0000"+
		"IO\u0005\'\u0000\u0000JN\b\u0003\u0000\u0000KL\u0005\\\u0000\u0000LN\t"+
		"\u0000\u0000\u0000MJ\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000"+
		"NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000"+
		"\u0000PR\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000RS\u0005\'\u0000"+
		"\u0000S\u0014\u0001\u0000\u0000\u0000TV\u0007\u0004\u0000\u0000UT\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0006\n\u0000\u0000"+
		"Z\u0016\u0001\u0000\u0000\u0000\b\u00009?EGMOW\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}