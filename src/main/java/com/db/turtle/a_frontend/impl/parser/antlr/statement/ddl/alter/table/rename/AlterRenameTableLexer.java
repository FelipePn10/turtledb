// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/alter/table/rename/AlterRenameTable.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.table.rename;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AlterRenameTableLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IDENTIFIER=1, WS=2, ALTER=3, TABLE=4, RENAME=5, TO=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IDENTIFIER", "WS", "ALTER", "TABLE", "RENAME", "TO", "A", "B", "C", 
			"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", 
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z"
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
			null, "IDENTIFIER", "WS", "ALTER", "TABLE", "RENAME", "TO"
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


	public AlterRenameTableLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AlterRenameTable.g4"; }

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
		"\u0004\u0000\u0006\u0099\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000"+
		"\u0005\u0000D\b\u0000\n\u0000\f\u0000G\t\u0000\u0001\u0001\u0004\u0001"+
		"J\b\u0001\u000b\u0001\f\u0001K\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0000\u0000 \u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0000\u000f\u0000\u0011"+
		"\u0000\u0013\u0000\u0015\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d"+
		"\u0000\u001f\u0000!\u0000#\u0000%\u0000\'\u0000)\u0000+\u0000-\u0000/"+
		"\u00001\u00003\u00005\u00007\u00009\u0000;\u0000=\u0000?\u0000\u0001\u0000"+
		"\u001d\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u0002"+
		"\u0000AAaa\u0002\u0000BBbb\u0002\u0000CCcc\u0002\u0000DDdd\u0002\u0000"+
		"EEee\u0002\u0000FFff\u0002\u0000GGgg\u0002\u0000HHhh\u0002\u0000IIii\u0002"+
		"\u0000JJjj\u0002\u0000KKkk\u0002\u0000LLll\u0002\u0000MMmm\u0002\u0000"+
		"NNnn\u0002\u0000OOoo\u0002\u0000PPpp\u0002\u0000QQqq\u0002\u0000RRrr\u0002"+
		"\u0000SSss\u0002\u0000TTtt\u0002\u0000UUuu\u0002\u0000VVvv\u0002\u0000"+
		"WWww\u0002\u0000XXxx\u0002\u0000YYyy\u0002\u0000ZZzz\u0080\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0001A\u0001\u0000"+
		"\u0000\u0000\u0003I\u0001\u0000\u0000\u0000\u0005O\u0001\u0000\u0000\u0000"+
		"\u0007U\u0001\u0000\u0000\u0000\t[\u0001\u0000\u0000\u0000\u000bb\u0001"+
		"\u0000\u0000\u0000\re\u0001\u0000\u0000\u0000\u000fg\u0001\u0000\u0000"+
		"\u0000\u0011i\u0001\u0000\u0000\u0000\u0013k\u0001\u0000\u0000\u0000\u0015"+
		"m\u0001\u0000\u0000\u0000\u0017o\u0001\u0000\u0000\u0000\u0019q\u0001"+
		"\u0000\u0000\u0000\u001bs\u0001\u0000\u0000\u0000\u001du\u0001\u0000\u0000"+
		"\u0000\u001fw\u0001\u0000\u0000\u0000!y\u0001\u0000\u0000\u0000#{\u0001"+
		"\u0000\u0000\u0000%}\u0001\u0000\u0000\u0000\'\u007f\u0001\u0000\u0000"+
		"\u0000)\u0081\u0001\u0000\u0000\u0000+\u0083\u0001\u0000\u0000\u0000-"+
		"\u0085\u0001\u0000\u0000\u0000/\u0087\u0001\u0000\u0000\u00001\u0089\u0001"+
		"\u0000\u0000\u00003\u008b\u0001\u0000\u0000\u00005\u008d\u0001\u0000\u0000"+
		"\u00007\u008f\u0001\u0000\u0000\u00009\u0091\u0001\u0000\u0000\u0000;"+
		"\u0093\u0001\u0000\u0000\u0000=\u0095\u0001\u0000\u0000\u0000?\u0097\u0001"+
		"\u0000\u0000\u0000AE\u0007\u0000\u0000\u0000BD\u0007\u0001\u0000\u0000"+
		"CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000F\u0002\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000HJ\u0007\u0002\u0000\u0000IH\u0001\u0000\u0000\u0000"+
		"JK\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000"+
		"\u0000LM\u0001\u0000\u0000\u0000MN\u0006\u0001\u0000\u0000N\u0004\u0001"+
		"\u0000\u0000\u0000OP\u0003\r\u0006\u0000PQ\u0003#\u0011\u0000QR\u0003"+
		"3\u0019\u0000RS\u0003\u0015\n\u0000ST\u0003/\u0017\u0000T\u0006\u0001"+
		"\u0000\u0000\u0000UV\u00033\u0019\u0000VW\u0003\r\u0006\u0000WX\u0003"+
		"\u000f\u0007\u0000XY\u0003#\u0011\u0000YZ\u0003\u0015\n\u0000Z\b\u0001"+
		"\u0000\u0000\u0000[\\\u0003/\u0017\u0000\\]\u0003\u0015\n\u0000]^\u0003"+
		"\'\u0013\u0000^_\u0003\r\u0006\u0000_`\u0003%\u0012\u0000`a\u0003\u0015"+
		"\n\u0000a\n\u0001\u0000\u0000\u0000bc\u00033\u0019\u0000cd\u0003)\u0014"+
		"\u0000d\f\u0001\u0000\u0000\u0000ef\u0007\u0003\u0000\u0000f\u000e\u0001"+
		"\u0000\u0000\u0000gh\u0007\u0004\u0000\u0000h\u0010\u0001\u0000\u0000"+
		"\u0000ij\u0007\u0005\u0000\u0000j\u0012\u0001\u0000\u0000\u0000kl\u0007"+
		"\u0006\u0000\u0000l\u0014\u0001\u0000\u0000\u0000mn\u0007\u0007\u0000"+
		"\u0000n\u0016\u0001\u0000\u0000\u0000op\u0007\b\u0000\u0000p\u0018\u0001"+
		"\u0000\u0000\u0000qr\u0007\t\u0000\u0000r\u001a\u0001\u0000\u0000\u0000"+
		"st\u0007\n\u0000\u0000t\u001c\u0001\u0000\u0000\u0000uv\u0007\u000b\u0000"+
		"\u0000v\u001e\u0001\u0000\u0000\u0000wx\u0007\f\u0000\u0000x \u0001\u0000"+
		"\u0000\u0000yz\u0007\r\u0000\u0000z\"\u0001\u0000\u0000\u0000{|\u0007"+
		"\u000e\u0000\u0000|$\u0001\u0000\u0000\u0000}~\u0007\u000f\u0000\u0000"+
		"~&\u0001\u0000\u0000\u0000\u007f\u0080\u0007\u0010\u0000\u0000\u0080("+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0007\u0011\u0000\u0000\u0082*\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0007\u0012\u0000\u0000\u0084,\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0007\u0013\u0000\u0000\u0086.\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0007\u0014\u0000\u0000\u00880\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0007\u0015\u0000\u0000\u008a2\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0007\u0016\u0000\u0000\u008c4\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0007\u0017\u0000\u0000\u008e6\u0001\u0000\u0000\u0000\u008f\u0090\u0007"+
		"\u0018\u0000\u0000\u00908\u0001\u0000\u0000\u0000\u0091\u0092\u0007\u0019"+
		"\u0000\u0000\u0092:\u0001\u0000\u0000\u0000\u0093\u0094\u0007\u001a\u0000"+
		"\u0000\u0094<\u0001\u0000\u0000\u0000\u0095\u0096\u0007\u001b\u0000\u0000"+
		"\u0096>\u0001\u0000\u0000\u0000\u0097\u0098\u0007\u001c\u0000\u0000\u0098"+
		"@\u0001\u0000\u0000\u0000\u0003\u0000EK\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}