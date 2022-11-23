/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.wavesplatform.rideplugin.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.wavesplatform.rideplugin.psi.RideTypes;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.wavesplatform.rideplugin.psi.RideTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>_RideLexer.flex</tt>
 */
public class _RideLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\16\4\2\22\0\1\16\1\40\1\17\1\14\1\0\1\47\1\43\1\20\1\34\1\35\1\45"+
    "\1\41\1\37\1\26\1\52\1\46\1\23\1\73\2\23\1\77\1\75\1\74\1\23\1\76\1\23\1\36"+
    "\1\0\1\51\1\24\1\50\1\0\1\3\1\65\2\21\1\61\1\67\1\56\2\21\1\62\1\21\1\71\1"+
    "\60\1\21\1\63\1\57\2\21\1\70\1\66\1\64\6\21\1\32\1\0\1\33\1\44\1\15\1\0\1"+
    "\11\1\72\1\53\1\22\1\7\1\10\1\22\1\55\1\30\2\22\1\12\1\54\1\31\3\22\1\5\1"+
    "\13\1\4\1\6\5\22\1\25\1\42\1\27\7\0\1\1\242\0\2\1\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\7\4\1\5\1\6\2\1"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\2\4\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\2\4"+
    "\3\7\2\4\1\35\7\4\2\5\1\10\1\0\1\36"+
    "\1\0\1\37\1\40\1\0\1\41\1\42\1\43\1\4"+
    "\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
    "\1\54\1\55\1\56\2\4\3\7\7\4\1\57\1\4"+
    "\1\60\1\61\1\62\1\63\2\4\1\7\1\64\1\7"+
    "\1\4\1\65\1\66\1\67\1\70\1\71\2\4\1\72"+
    "\1\4\1\73\1\7\1\4\1\74\1\4\1\75\1\7"+
    "\3\4\1\76\1\7\1\77\1\100\1\101\1\7\1\102";

  private static int [] zzUnpackAction() {
    int [] result = new int[128];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\100\0\200\0\100\0\300\0\u0100\0\u0140\0\u0180"+
    "\0\u01c0\0\u0200\0\u0240\0\u0280\0\u02c0\0\u0300\0\u0340\0\u0380"+
    "\0\u03c0\0\u0400\0\u0440\0\u0480\0\100\0\u04c0\0\u0500\0\100"+
    "\0\100\0\100\0\100\0\u0540\0\100\0\u0580\0\u05c0\0\u0600"+
    "\0\u0640\0\100\0\100\0\100\0\u0680\0\u06c0\0\100\0\u0700"+
    "\0\u0740\0\u0780\0\u07c0\0\u0800\0\u0840\0\u0880\0\u08c0\0\u0900"+
    "\0\u0940\0\u0980\0\u09c0\0\u0a00\0\u0a40\0\u0a80\0\u0ac0\0\u0b00"+
    "\0\u02c0\0\u0300\0\100\0\u0340\0\100\0\100\0\u0b40\0\100"+
    "\0\100\0\u0100\0\u0b80\0\100\0\100\0\100\0\100\0\100"+
    "\0\100\0\100\0\100\0\u0bc0\0\100\0\100\0\u0c00\0\u0c40"+
    "\0\u0c80\0\u0cc0\0\u0d00\0\u0d40\0\u0d80\0\u0dc0\0\u0e00\0\u0e40"+
    "\0\u0e80\0\u0ec0\0\u0100\0\u0f00\0\u0ac0\0\100\0\u0100\0\100"+
    "\0\u0f40\0\u0f80\0\u0fc0\0\u0380\0\u1000\0\u1040\0\u0100\0\u0100"+
    "\0\u0100\0\u0100\0\u0100\0\u1080\0\u10c0\0\u0100\0\u1100\0\u0380"+
    "\0\u1140\0\u1180\0\u0100\0\u11c0\0\u0100\0\u1200\0\u1240\0\u1280"+
    "\0\u12c0\0\u0100\0\u1300\0\u0100\0\u0100\0\u0100\0\u1340\0\u0380";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[128];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\2\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\6\1\12\1\13\1\14\1\15\1\3\1\16\1\17"+
    "\1\20\1\6\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\2\1\42\1\43\1\44\1\45"+
    "\1\46\1\47\1\50\1\51\1\6\1\52\3\20\1\53"+
    "\2\20\1\54\4\20\1\55\5\21\102\0\1\3\13\0"+
    "\1\3\65\0\1\6\1\56\6\6\1\0\1\57\3\0"+
    "\3\6\4\0\2\6\21\0\2\6\1\60\22\6\4\0"+
    "\10\6\1\0\1\57\3\0\3\6\4\0\2\6\21\0"+
    "\25\6\4\0\10\6\1\0\1\57\3\0\3\6\4\0"+
    "\1\6\1\61\21\0\25\6\4\0\6\6\1\62\1\6"+
    "\1\0\1\57\3\0\3\6\4\0\2\6\21\0\25\6"+
    "\4\0\2\6\1\63\2\6\1\64\2\6\1\0\1\57"+
    "\3\0\3\6\4\0\2\6\21\0\25\6\4\0\3\6"+
    "\1\65\4\6\1\0\1\57\3\0\3\6\4\0\2\6"+
    "\21\0\25\6\4\0\1\66\7\6\1\0\1\57\3\0"+
    "\3\6\4\0\2\6\21\0\25\6\1\67\2\0\23\67"+
    "\1\70\51\67\4\0\10\57\1\0\1\71\3\0\2\57"+
    "\1\71\4\0\2\57\21\0\20\57\5\71\17\72\1\73"+
    "\60\72\20\74\1\75\57\74\4\0\10\20\1\0\1\57"+
    "\3\0\3\20\4\0\2\20\21\0\25\20\15\0\1\21"+
    "\5\0\1\21\47\0\5\21\24\0\1\76\101\0\1\77"+
    "\75\0\1\100\1\0\1\101\55\0\4\6\1\102\3\6"+
    "\1\0\1\57\3\0\3\6\4\0\2\6\21\0\25\6"+
    "\4\0\10\6\1\0\1\57\3\0\3\6\4\0\1\103"+
    "\1\6\21\0\25\6\36\0\1\104\2\0\1\105\62\0"+
    "\1\106\114\0\1\107\62\0\1\110\15\0\1\111\61\0"+
    "\1\112\16\0\1\113\1\114\57\0\1\115\77\0\1\116"+
    "\57\0\5\6\1\117\2\6\1\0\1\57\3\0\3\6"+
    "\4\0\2\6\21\0\25\6\4\0\5\6\1\120\2\6"+
    "\1\0\1\57\3\0\3\6\4\0\2\6\21\0\25\6"+
    "\4\0\10\20\1\0\1\57\3\0\3\20\4\0\2\20"+
    "\21\0\4\20\1\121\20\20\4\0\10\20\1\0\1\57"+
    "\3\0\3\20\4\0\2\20\21\0\10\20\1\122\14\20"+
    "\4\0\10\20\1\0\1\57\3\0\3\20\4\0\2\20"+
    "\21\0\13\20\1\123\11\20\4\0\5\6\1\124\2\6"+
    "\1\0\1\57\3\0\3\6\4\0\2\6\21\0\25\6"+
    "\4\0\2\6\1\125\5\6\1\0\1\57\3\0\3\6"+
    "\4\0\2\6\21\0\25\6\4\0\10\57\1\0\1\57"+
    "\3\0\3\57\4\0\2\57\21\0\25\57\4\0\3\6"+
    "\1\126\4\6\1\0\1\57\3\0\3\6\4\0\2\6"+
    "\21\0\25\6\4\0\10\6\1\0\1\57\3\0\3\6"+
    "\4\0\1\127\1\6\21\0\25\6\4\0\7\6\1\130"+
    "\1\0\1\57\3\0\3\6\4\0\2\6\21\0\25\6"+
    "\4\0\10\6\1\0\1\57\3\0\3\6\4\0\1\6"+
    "\1\131\21\0\25\6\4\0\6\6\1\132\1\6\1\0"+
    "\1\57\3\0\3\6\4\0\2\6\21\0\25\6\4\0"+
    "\1\133\7\6\1\0\1\57\3\0\3\6\4\0\2\6"+
    "\21\0\25\6\4\0\1\6\1\134\6\6\1\0\1\57"+
    "\3\0\3\6\4\0\2\6\21\0\25\6\1\67\2\0"+
    "\76\67\2\0\24\67\1\135\50\67\14\0\1\136\67\0"+
    "\6\6\1\137\1\6\1\0\1\57\3\0\3\6\4\0"+
    "\2\6\21\0\25\6\24\0\1\140\57\0\7\6\1\141"+
    "\1\0\1\57\3\0\3\6\4\0\2\6\21\0\25\6"+
    "\4\0\1\142\7\6\1\0\1\57\3\0\3\6\4\0"+
    "\2\6\21\0\25\6\4\0\10\20\1\0\1\57\3\0"+
    "\3\20\4\0\2\20\21\0\5\20\1\143\17\20\4\0"+
    "\10\20\1\0\1\57\3\0\3\20\4\0\2\20\21\0"+
    "\11\20\1\144\13\20\4\0\10\20\1\0\1\57\3\0"+
    "\3\20\4\0\2\20\21\0\11\20\1\145\13\20\4\0"+
    "\7\6\1\146\1\0\1\57\3\0\3\6\4\0\2\6"+
    "\21\0\25\6\4\0\3\6\1\147\4\6\1\0\1\57"+
    "\3\0\3\6\4\0\2\6\21\0\25\6\4\0\10\6"+
    "\1\0\1\57\3\0\3\6\4\0\1\6\1\150\21\0"+
    "\25\6\4\0\1\151\7\6\1\0\1\57\3\0\3\6"+
    "\4\0\2\6\21\0\25\6\4\0\3\6\1\152\4\6"+
    "\1\0\1\57\3\0\3\6\4\0\2\6\21\0\25\6"+
    "\4\0\10\6\1\0\1\57\3\0\3\6\4\0\2\6"+
    "\21\0\1\153\24\6\4\0\7\6\1\154\1\0\1\57"+
    "\3\0\3\6\4\0\2\6\21\0\25\6\4\0\10\6"+
    "\1\0\1\57\3\0\3\6\4\0\1\155\1\6\21\0"+
    "\25\6\4\0\3\6\1\156\4\6\1\0\1\57\3\0"+
    "\3\6\4\0\2\6\21\0\25\6\4\0\10\6\1\0"+
    "\1\57\3\0\3\6\4\0\2\6\21\0\1\157\24\6"+
    "\4\0\10\20\1\0\1\57\3\0\3\20\4\0\2\20"+
    "\21\0\6\20\1\160\16\20\4\0\10\20\1\0\1\57"+
    "\3\0\3\20\4\0\2\20\21\0\14\20\1\161\10\20"+
    "\4\0\3\6\1\162\4\6\1\0\1\57\3\0\3\6"+
    "\4\0\2\6\21\0\25\6\4\0\3\6\1\163\4\6"+
    "\1\0\1\57\3\0\3\6\4\0\2\6\21\0\25\6"+
    "\4\0\10\6\1\0\1\57\3\0\3\6\4\0\2\6"+
    "\21\0\1\164\24\6\4\0\10\6\1\0\1\57\3\0"+
    "\3\6\4\0\2\6\21\0\2\6\1\165\22\6\4\0"+
    "\10\20\1\0\1\57\3\0\3\20\4\0\2\20\21\0"+
    "\15\20\1\166\7\20\4\0\10\6\1\0\1\57\3\0"+
    "\3\6\4\0\2\6\21\0\20\6\1\167\1\170\1\171"+
    "\2\6\4\0\1\172\7\6\1\0\1\57\3\0\3\6"+
    "\4\0\2\6\21\0\25\6\4\0\10\20\1\0\1\57"+
    "\3\0\3\20\4\0\2\20\21\0\7\20\1\173\15\20"+
    "\4\0\10\6\1\0\1\57\3\0\3\6\4\0\2\6"+
    "\21\0\21\6\1\174\3\6\4\0\10\6\1\0\1\57"+
    "\3\0\3\6\4\0\2\6\21\0\24\6\1\175\4\0"+
    "\10\6\1\0\1\57\3\0\3\6\4\0\2\6\21\0"+
    "\23\6\1\176\1\6\4\0\10\20\1\0\1\57\3\0"+
    "\3\20\4\0\2\20\21\0\13\20\1\177\11\20\4\0"+
    "\10\20\1\0\1\57\3\0\3\20\4\0\2\20\21\0"+
    "\16\20\1\200\6\20";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4992];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\20\1\1\11\2\1\4\11"+
    "\1\1\1\11\4\1\3\11\2\1\1\11\22\1\1\0"+
    "\1\11\1\0\2\11\1\0\2\11\2\1\10\11\1\1"+
    "\2\11\17\1\1\11\1\1\1\11\40\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[128];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _RideLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _RideLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 67: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 68: break;
          case 3: 
            { return AT_SYMBOL;
            } 
            // fall through
          case 69: break;
          case 4: 
            { return LOWER_ID;
            } 
            // fall through
          case 70: break;
          case 5: 
            { return COMMENT;
            } 
            // fall through
          case 71: break;
          case 6: 
            { return UNDERSCORE;
            } 
            // fall through
          case 72: break;
          case 7: 
            { return UPPER_ID;
            } 
            // fall through
          case 73: break;
          case 8: 
            { return INTEGER;
            } 
            // fall through
          case 74: break;
          case 9: 
            { return ASSIGN;
            } 
            // fall through
          case 75: break;
          case 10: 
            { return LBRACE;
            } 
            // fall through
          case 76: break;
          case 11: 
            { return MINUS;
            } 
            // fall through
          case 77: break;
          case 12: 
            { return RBRACE;
            } 
            // fall through
          case 78: break;
          case 13: 
            { return LBRACKET;
            } 
            // fall through
          case 79: break;
          case 14: 
            { return RBRACKET;
            } 
            // fall through
          case 80: break;
          case 15: 
            { return LPAREN;
            } 
            // fall through
          case 81: break;
          case 16: 
            { return RPAREN;
            } 
            // fall through
          case 82: break;
          case 17: 
            { return COLON;
            } 
            // fall through
          case 83: break;
          case 18: 
            { return COMMA;
            } 
            // fall through
          case 84: break;
          case 19: 
            { return BANG;
            } 
            // fall through
          case 85: break;
          case 20: 
            { return PLUS;
            } 
            // fall through
          case 86: break;
          case 21: 
            { return BIT_OR;
            } 
            // fall through
          case 87: break;
          case 22: 
            { return BIT_AND;
            } 
            // fall through
          case 88: break;
          case 23: 
            { return MUL;
            } 
            // fall through
          case 89: break;
          case 24: 
            { return SLASH;
            } 
            // fall through
          case 90: break;
          case 25: 
            { return PERCENT;
            } 
            // fall through
          case 91: break;
          case 26: 
            { return GT;
            } 
            // fall through
          case 92: break;
          case 27: 
            { return LESS;
            } 
            // fall through
          case 93: break;
          case 28: 
            { return DOT;
            } 
            // fall through
          case 94: break;
          case 29: 
            { return IDENT;
            } 
            // fall through
          case 95: break;
          case 30: 
            { return STRING;
            } 
            // fall through
          case 96: break;
          case 31: 
            { return SQSTRING;
            } 
            // fall through
          case 97: break;
          case 32: 
            { return EQ;
            } 
            // fall through
          case 98: break;
          case 33: 
            { return MINUS_ASSIGN;
            } 
            // fall through
          case 99: break;
          case 34: 
            { return MINUS_MINUS;
            } 
            // fall through
          case 100: break;
          case 35: 
            { return IF;
            } 
            // fall through
          case 101: break;
          case 36: 
            { return PREPEND;
            } 
            // fall through
          case 102: break;
          case 37: 
            { return APPEND;
            } 
            // fall through
          case 103: break;
          case 38: 
            { return NOT_EQ;
            } 
            // fall through
          case 104: break;
          case 39: 
            { return CONCAT;
            } 
            // fall through
          case 105: break;
          case 40: 
            { return BIT_OR_ASSIGN;
            } 
            // fall through
          case 106: break;
          case 41: 
            { return COND_OR;
            } 
            // fall through
          case 107: break;
          case 42: 
            { return BIT_AND_ASSIGN;
            } 
            // fall through
          case 108: break;
          case 43: 
            { return COND_AND;
            } 
            // fall through
          case 109: break;
          case 44: 
            { return BIT_CLEAR;
            } 
            // fall through
          case 110: break;
          case 45: 
            { return GREATER_OR_EQUAL;
            } 
            // fall through
          case 111: break;
          case 46: 
            { return LESS_OR_EQUAL;
            } 
            // fall through
          case 112: break;
          case 47: 
            { return LET;
            } 
            // fall through
          case 113: break;
          case 48: 
            { return RDBRACKET;
            } 
            // fall through
          case 114: break;
          case 49: 
            { return LDBRACKET;
            } 
            // fall through
          case 115: break;
          case 50: 
            { return NIL;
            } 
            // fall through
          case 116: break;
          case 51: 
            { return BIT_CLEAR_ASSIGN;
            } 
            // fall through
          case 117: break;
          case 52: 
            { return INT;
            } 
            // fall through
          case 118: break;
          case 53: 
            { return TRUE;
            } 
            // fall through
          case 119: break;
          case 54: 
            { return THEN;
            } 
            // fall through
          case 120: break;
          case 55: 
            { return UNIT;
            } 
            // fall through
          case 121: break;
          case 56: 
            { return ELSE;
            } 
            // fall through
          case 122: break;
          case 57: 
            { return FUNCTION;
            } 
            // fall through
          case 123: break;
          case 58: 
            { return CASE;
            } 
            // fall through
          case 124: break;
          case 59: 
            { return FOLD_KW;
            } 
            // fall through
          case 125: break;
          case 60: 
            { return FALSE;
            } 
            // fall through
          case 126: break;
          case 61: 
            { return MATCH;
            } 
            // fall through
          case 127: break;
          case 62: 
            { return STRICT;
            } 
            // fall through
          case 128: break;
          case 63: 
            { return BASE16;
            } 
            // fall through
          case 129: break;
          case 64: 
            { return BASE64;
            } 
            // fall through
          case 130: break;
          case 65: 
            { return BASE58;
            } 
            // fall through
          case 131: break;
          case 66: 
            { return ASTERISK;
            } 
            // fall through
          case 132: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
