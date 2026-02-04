// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/alter/column/drop/AlterColumnDrop.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.drop;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AlterColumnDropLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALTER=1, TABLE=2, DROP=3, COLUMN=4, IDENTIFIER=5, WS=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ALTER", "TABLE", "DROP", "COLUMN", "IDENTIFIER", "WS", "A", "B", "C", 
			"D", "E", "L", "M", "N", "O", "P", "R", "T", "U"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALTER", "TABLE", "DROP", "COLUMN", "IDENTIFIER", "WS"
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


	public AlterColumnDropLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AlterColumnDrop.g4"; }

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
		"\u0004\u0000\u0006g\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004B\b\u0004\n\u0004"+
		"\f\u0004E\t\u0004\u0001\u0005\u0004\u0005H\b\u0005\u000b\u0005\f\u0005"+
		"I\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0000\u0000\u0013\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0000\u000f\u0000\u0011\u0000\u0013\u0000\u0015"+
		"\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d\u0000\u001f\u0000!\u0000"+
		"#\u0000%\u0000\u0001\u0000\u0010\u0003\u0000AZ__az\u0004\u000009AZ__a"+
		"z\u0003\u0000\t\n\r\r  \u0002\u0000AAaa\u0002\u0000BBbb\u0002\u0000CC"+
		"cc\u0002\u0000DDdd\u0002\u0000EEee\u0002\u0000LLll\u0002\u0000MMmm\u0002"+
		"\u0000NNnn\u0002\u0000OOoo\u0002\u0000PPpp\u0002\u0000RRrr\u0002\u0000"+
		"TTtt\u0002\u0000UUuu[\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0001\'\u0001\u0000\u0000\u0000\u0003-\u0001\u0000"+
		"\u0000\u0000\u00053\u0001\u0000\u0000\u0000\u00078\u0001\u0000\u0000\u0000"+
		"\t?\u0001\u0000\u0000\u0000\u000bG\u0001\u0000\u0000\u0000\rM\u0001\u0000"+
		"\u0000\u0000\u000fO\u0001\u0000\u0000\u0000\u0011Q\u0001\u0000\u0000\u0000"+
		"\u0013S\u0001\u0000\u0000\u0000\u0015U\u0001\u0000\u0000\u0000\u0017W"+
		"\u0001\u0000\u0000\u0000\u0019Y\u0001\u0000\u0000\u0000\u001b[\u0001\u0000"+
		"\u0000\u0000\u001d]\u0001\u0000\u0000\u0000\u001f_\u0001\u0000\u0000\u0000"+
		"!a\u0001\u0000\u0000\u0000#c\u0001\u0000\u0000\u0000%e\u0001\u0000\u0000"+
		"\u0000\'(\u0003\r\u0006\u0000()\u0003\u0017\u000b\u0000)*\u0003#\u0011"+
		"\u0000*+\u0003\u0015\n\u0000+,\u0003!\u0010\u0000,\u0002\u0001\u0000\u0000"+
		"\u0000-.\u0003#\u0011\u0000./\u0003\r\u0006\u0000/0\u0003\u000f\u0007"+
		"\u000001\u0003\u0017\u000b\u000012\u0003\u0015\n\u00002\u0004\u0001\u0000"+
		"\u0000\u000034\u0003\u0013\t\u000045\u0003!\u0010\u000056\u0003\u001d"+
		"\u000e\u000067\u0003\u001f\u000f\u00007\u0006\u0001\u0000\u0000\u0000"+
		"89\u0003\u0011\b\u00009:\u0003\u001d\u000e\u0000:;\u0003\u0017\u000b\u0000"+
		";<\u0003%\u0012\u0000<=\u0003\u0019\f\u0000=>\u0003\u001b\r\u0000>\b\u0001"+
		"\u0000\u0000\u0000?C\u0007\u0000\u0000\u0000@B\u0007\u0001\u0000\u0000"+
		"A@\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000"+
		"\u0000CD\u0001\u0000\u0000\u0000D\n\u0001\u0000\u0000\u0000EC\u0001\u0000"+
		"\u0000\u0000FH\u0007\u0002\u0000\u0000GF\u0001\u0000\u0000\u0000HI\u0001"+
		"\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"JK\u0001\u0000\u0000\u0000KL\u0006\u0005\u0000\u0000L\f\u0001\u0000\u0000"+
		"\u0000MN\u0007\u0003\u0000\u0000N\u000e\u0001\u0000\u0000\u0000OP\u0007"+
		"\u0004\u0000\u0000P\u0010\u0001\u0000\u0000\u0000QR\u0007\u0005\u0000"+
		"\u0000R\u0012\u0001\u0000\u0000\u0000ST\u0007\u0006\u0000\u0000T\u0014"+
		"\u0001\u0000\u0000\u0000UV\u0007\u0007\u0000\u0000V\u0016\u0001\u0000"+
		"\u0000\u0000WX\u0007\b\u0000\u0000X\u0018\u0001\u0000\u0000\u0000YZ\u0007"+
		"\t\u0000\u0000Z\u001a\u0001\u0000\u0000\u0000[\\\u0007\n\u0000\u0000\\"+
		"\u001c\u0001\u0000\u0000\u0000]^\u0007\u000b\u0000\u0000^\u001e\u0001"+
		"\u0000\u0000\u0000_`\u0007\f\u0000\u0000` \u0001\u0000\u0000\u0000ab\u0007"+
		"\r\u0000\u0000b\"\u0001\u0000\u0000\u0000cd\u0007\u000e\u0000\u0000d$"+
		"\u0001\u0000\u0000\u0000ef\u0007\u000f\u0000\u0000f&\u0001\u0000\u0000"+
		"\u0000\u0003\u0000CI\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}