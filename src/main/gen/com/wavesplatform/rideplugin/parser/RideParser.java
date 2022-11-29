// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.wavesplatform.rideplugin.psi.RideTypes.*;
import static com.wavesplatform.rideplugin.parser.RideParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RideParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    boolean r;
    if (t == EXPR) {
      r = expr(b, l + 1, -1);
    }
    else {
      r = program(b, l + 1);
    }
    return r;
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ARRAY_TYPE, SIMPLE_TYPE, TUPLE_TYPE, TYPE,
      UNION_TYPE),
    create_token_set_(AND_EXPR, ANNOTATION_EXPR, APPEND_EXPR, ARRAY_EXPR,
      CASE_EXPR, CONCAT_EXPR, DIV_EXPR, EQUAL_EXPR,
      EXPR, EXPR_CALL, FIELD_CALL, FOLD_EXPR,
      FUNCTION_CALL, FUNC_EXPR, IF_EXPR, INDEX_EXPR,
      LESS_EXPR, LESS_OR_EQ_EXPR, LITERAL_EXPR, MINUS_EXPR,
      MOD_EXPR, MORE_EXPR, MORE_OR_EQ_EXPR, MUL_EXPR,
      NOT_EQUAL_EXPR, OBJECT_FUNCTION_CALL, OR_EXPR, PAREN_EXPR,
      PATTERN_MATCHING_EXPR, PLUS_EXPR, PREPEND_EXPR, SIMPLE_REF_EXPR,
      STANDALONE_FUNCTION_CALL, STRUCT_CALL, TUPLE_EXPR, UNARY_MIN_EXPR,
      UNARY_NOT_EXPR),
  };

  /* ********************************************************** */
  // directive* element*
  public static boolean all(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "all")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALL, "<all>");
    r = all_0(b, l + 1);
    r = r && all_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // directive*
  private static boolean all_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "all_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!directive(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "all_0", c)) break;
    }
    return true;
  }

  // element*
  private static boolean all_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "all_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "all_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // AT_SYMBOL UPPER_ID
  public static boolean annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation")) return false;
    if (!nextTokenIs(b, AT_SYMBOL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION, null);
    r = consumeTokens(b, 1, AT_SYMBOL, UPPER_ID);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // annotation LPAREN LOWER_ID RPAREN
  public static boolean annotation_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_expr")) return false;
    if (!nextTokenIs(b, AT_SYMBOL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_EXPR, null);
    r = annotation(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeTokens(b, -1, LPAREN, LOWER_ID, RPAREN));
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // expr | closure
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = expr(b, l + 1, -1);
    if (!r) r = closure(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // argument (COMMA argument)*
  public static boolean arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENTS, "<arguments>");
    r = argument(b, l + 1);
    p = r; // pin = 1
    r = r && arguments_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA argument)*
  private static boolean arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arguments_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arguments_1", c)) break;
    }
    return true;
  }

  // COMMA argument
  private static boolean arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && argument(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // element*
  public static boolean block_state(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_state")) return false;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_STATE, "<block state>");
    while (true) {
      int c = current_position_(b);
      if (!element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_state", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // TRUE | FALSE
  public static boolean boolLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolLiteral")) return false;
    if (!nextTokenIs(b, "<bool literal>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_LITERAL, "<bool literal>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (base16|base58|base64) SQSTRING
  public static boolean byteVectorLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byteVectorLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BYTE_VECTOR_LITERAL, "<byte vector literal>");
    r = byteVectorLiteral_0(b, l + 1);
    r = r && consumeToken(b, SQSTRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // base16|base58|base64
  private static boolean byteVectorLiteral_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byteVectorLiteral_0")) return false;
    boolean r;
    r = consumeToken(b, BASE16);
    if (!r) r = consumeToken(b, BASE58);
    if (!r) r = consumeToken(b, BASE64);
    return r;
  }

  /* ********************************************************** */
  // LPAREN arguments? RPAREN
  public static boolean call_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_arguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CALL_ARGUMENTS, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, call_arguments_1(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // arguments?
  private static boolean call_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_arguments_1")) return false;
    arguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // call_function_chain | call_field_chain
  public static boolean call_chain(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_chain")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_function_chain(b, l + 1);
    if (!r) r = call_field_chain(b, l + 1);
    exit_section_(b, m, CALL_CHAIN, r);
    return r;
  }

  /* ********************************************************** */
  // DOT field_definition
  public static boolean call_field_chain(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_field_chain")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && field_definition(b, l + 1);
    exit_section_(b, m, CALL_FIELD_CHAIN, r);
    return r;
  }

  /* ********************************************************** */
  // DOT function_name LPAREN arguments? RPAREN
  public static boolean call_function_chain(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_function_chain")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && function_name(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && call_function_chain_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CALL_FUNCTION_CHAIN, r);
    return r;
  }

  // arguments?
  private static boolean call_function_chain_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_function_chain_3")) return false;
    arguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // var_definition
  public static boolean calling_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "calling_object")) return false;
    if (!nextTokenIs(b, "<calling object>", LOWER_ID, UPPER_ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALLING_OBJECT, "<calling object>");
    r = var_definition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACE block_state RBRACE
  //           | LPAREN block_state RPAREN
  //           | block_state
  public static boolean case_closure(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_closure")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_CLOSURE, "<case closure>");
    r = case_closure_0(b, l + 1);
    if (!r) r = case_closure_1(b, l + 1);
    if (!r) r = block_state(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACE block_state RBRACE
  private static boolean case_closure_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_closure_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && block_state(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN block_state RPAREN
  private static boolean case_closure_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_closure_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && block_state(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CASE (UNDERSCORE | var_definition) type_definition? '=>' case_closure
  public static boolean case_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_expr")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CASE_EXPR, null);
    r = consumeToken(b, CASE);
    p = r; // pin = 1
    r = r && report_error_(b, case_expr_1(b, l + 1));
    r = p && report_error_(b, case_expr_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, "=>")) && r;
    r = p && case_closure(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // UNDERSCORE | var_definition
  private static boolean case_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_expr_1")) return false;
    boolean r;
    r = consumeToken(b, UNDERSCORE);
    if (!r) r = var_definition(b, l + 1);
    return r;
  }

  // type_definition?
  private static boolean case_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_expr_2")) return false;
    type_definition(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LBRACE block_state RBRACE
  //           | LPAREN block_state RPAREN
  //           | block_state
  public static boolean closure(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "closure")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLOSURE, "<closure>");
    r = closure_0(b, l + 1);
    if (!r) r = closure_1(b, l + 1);
    if (!r) r = block_state(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACE block_state RBRACE
  private static boolean closure_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "closure_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && block_state(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN block_state RPAREN
  private static boolean closure_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "closure_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && block_state(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LDBRACKET UPPER_ID (imports|UPPER_ID|INTEGER) RDBRACKET
  public static boolean directive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive")) return false;
    if (!nextTokenIs(b, LDBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LDBRACKET, UPPER_ID);
    r = r && directive_2(b, l + 1);
    r = r && consumeToken(b, RDBRACKET);
    exit_section_(b, m, DIRECTIVE, r);
    return r;
  }

  // imports|UPPER_ID|INTEGER
  private static boolean directive_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_2")) return false;
    boolean r;
    r = imports(b, l + 1);
    if (!r) r = consumeToken(b, UPPER_ID);
    if (!r) r = consumeToken(b, INTEGER);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> statement
  static boolean element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = element_0(b, l + 1);
    r = r && statement(b, l + 1);
    exit_section_(b, l, m, r, false, RideParser::property_recover);
    return r;
  }

  // !<<eof>>
  private static boolean element_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ELSE closure
  public static boolean else_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_block")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ELSE_BLOCK, null);
    r = consumeToken(b, ELSE);
    p = r; // pin = 1
    r = r && closure(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ELSE IF LPAREN? if_cond RPAREN? (THEN? closure)
  public static boolean else_if_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_block")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ELSE_IF_BLOCK, null);
    r = consumeTokens(b, 2, ELSE, IF);
    p = r; // pin = 2
    r = r && report_error_(b, else_if_block_2(b, l + 1));
    r = p && report_error_(b, if_cond(b, l + 1)) && r;
    r = p && report_error_(b, else_if_block_4(b, l + 1)) && r;
    r = p && else_if_block_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // LPAREN?
  private static boolean else_if_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_block_2")) return false;
    consumeToken(b, LPAREN);
    return true;
  }

  // RPAREN?
  private static boolean else_if_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_block_4")) return false;
    consumeToken(b, RPAREN);
    return true;
  }

  // THEN? closure
  private static boolean else_if_block_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_block_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = else_if_block_5_0(b, l + 1);
    r = r && closure(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THEN?
  private static boolean else_if_block_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if_block_5_0")) return false;
    consumeToken(b, THEN);
    return true;
  }

  /* ********************************************************** */
  // (standalone_function_call | var_definition) (call_function_chain | call_field_chain)+
  public static boolean field_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_call")) return false;
    if (!nextTokenIs(b, "<field call>", LOWER_ID, UPPER_ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, FIELD_CALL, "<field call>");
    r = field_call_0(b, l + 1);
    r = r && field_call_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // standalone_function_call | var_definition
  private static boolean field_call_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_call_0")) return false;
    boolean r;
    r = standalone_function_call(b, l + 1);
    if (!r) r = var_definition(b, l + 1);
    return r;
  }

  // (call_function_chain | call_field_chain)+
  private static boolean field_call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_call_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_call_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!field_call_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_call_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // call_function_chain | call_field_chain
  private static boolean field_call_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_call_1_0")) return false;
    boolean r;
    r = call_function_chain(b, l + 1);
    if (!r) r = call_field_chain(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LOWER_ID | INTEGER
  public static boolean field_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_definition")) return false;
    if (!nextTokenIs(b, "<field definition>", INTEGER, LOWER_ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_DEFINITION, "<field definition>");
    r = consumeToken(b, LOWER_ID);
    if (!r) r = consumeToken(b, INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LOWER_ID | UPPER_ID
  public static boolean function_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_name")) return false;
    if (!nextTokenIs(b, "<function name>", LOWER_ID, UPPER_ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_NAME, "<function name>");
    r = consumeToken(b, LOWER_ID);
    if (!r) r = consumeToken(b, UPPER_ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expr
  public static boolean if_cond(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_cond")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_COND, "<if cond>");
    r = expr(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RIDE_FILE (COMMA RIDE_FILE)*
  public static boolean imports(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports")) return false;
    if (!nextTokenIs(b, RIDE_FILE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORTS, null);
    r = consumeToken(b, RIDE_FILE);
    p = r; // pin = 1
    r = r && imports_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA RIDE_FILE)*
  private static boolean imports_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!imports_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "imports_1", c)) break;
    }
    return true;
  }

  // COMMA RIDE_FILE
  private static boolean imports_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "imports_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, RIDE_FILE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INTEGER
  public static boolean integerLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integerLiteral")) return false;
    if (!nextTokenIs(b, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTEGER);
    exit_section_(b, m, INTEGER_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // NIL
  public static boolean nilLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nilLiteral")) return false;
    if (!nextTokenIs(b, NIL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NIL);
    exit_section_(b, m, NIL_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // integerLiteral
  public static boolean numericLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numericLiteral")) return false;
    if (!nextTokenIs(b, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integerLiteral(b, l + 1);
    exit_section_(b, m, NUMERIC_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // calling_object DOT function_name LPAREN arguments? RPAREN
  public static boolean object_function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_function_call")) return false;
    if (!nextTokenIs(b, "<object function call>", LOWER_ID, UPPER_ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_FUNCTION_CALL, "<object function call>");
    r = calling_object(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && function_name(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    p = r; // pin = 4
    r = r && report_error_(b, object_function_call_4(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // arguments?
  private static boolean object_function_call_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_function_call_4")) return false;
    arguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // var_definition type_definition
  public static boolean param_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_definition")) return false;
    if (!nextTokenIs(b, "<param definition>", LOWER_ID, UPPER_ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAM_DEFINITION, "<param definition>");
    r = var_definition(b, l + 1);
    p = r; // pin = 1
    r = r && type_definition(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // param_definition (COMMA param_definition)*
  public static boolean param_group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_group")) return false;
    if (!nextTokenIs(b, "<param group>", LOWER_ID, UPPER_ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAM_GROUP, "<param group>");
    r = param_definition(b, l + 1);
    p = r; // pin = 1
    r = r && param_group_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA param_definition)*
  private static boolean param_group_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_group_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!param_group_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "param_group_1", c)) break;
    }
    return true;
  }

  // COMMA param_definition
  private static boolean param_group_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_group_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && param_definition(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // all
  static boolean program(PsiBuilder b, int l) {
    return all(b, l + 1);
  }

  /* ********************************************************** */
  // !(UNIT | NIL | AT_SYMBOL | FUNCTION | LET | STRICT | TRUE | FALSE |IF |ELSE | LDBRACKET
  // | RDBRACKET | PERCENT | LESS_OR_EQUAL | GREATER_OR_EQUAL
  // | INT | STRING | IDENT | PLUS | MINUS| BANG | ASTERISK |SLASH | LESS |GT|EQ | LBRACKET | RBRACKET
  // | NOT_EQ | COMMA | ASSIGN |  COLON | LPAREN |RPAREN |LBRACE |RBRACE | MATCH | CASE | FOLD_KW | LOWER_ID | UPPER_ID | TUPPLE_FIELD)
  static boolean property_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !property_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // UNIT | NIL | AT_SYMBOL | FUNCTION | LET | STRICT | TRUE | FALSE |IF |ELSE | LDBRACKET
  // | RDBRACKET | PERCENT | LESS_OR_EQUAL | GREATER_OR_EQUAL
  // | INT | STRING | IDENT | PLUS | MINUS| BANG | ASTERISK |SLASH | LESS |GT|EQ | LBRACKET | RBRACKET
  // | NOT_EQ | COMMA | ASSIGN |  COLON | LPAREN |RPAREN |LBRACE |RBRACE | MATCH | CASE | FOLD_KW | LOWER_ID | UPPER_ID | TUPPLE_FIELD
  private static boolean property_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover_0")) return false;
    boolean r;
    r = consumeToken(b, UNIT);
    if (!r) r = consumeToken(b, NIL);
    if (!r) r = consumeToken(b, AT_SYMBOL);
    if (!r) r = consumeToken(b, FUNCTION);
    if (!r) r = consumeToken(b, LET);
    if (!r) r = consumeToken(b, STRICT);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, ELSE);
    if (!r) r = consumeToken(b, LDBRACKET);
    if (!r) r = consumeToken(b, RDBRACKET);
    if (!r) r = consumeToken(b, PERCENT);
    if (!r) r = consumeToken(b, LESS_OR_EQUAL);
    if (!r) r = consumeToken(b, GREATER_OR_EQUAL);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, ASTERISK);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, RBRACKET);
    if (!r) r = consumeToken(b, NOT_EQ);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, MATCH);
    if (!r) r = consumeToken(b, CASE);
    if (!r) r = consumeToken(b, FOLD_KW);
    if (!r) r = consumeToken(b, LOWER_ID);
    if (!r) r = consumeToken(b, UPPER_ID);
    if (!r) r = consumeToken(b, TUPPLE_FIELD);
    return r;
  }

  /* ********************************************************** */
  // function_name LPAREN arguments? RPAREN
  public static boolean standalone_function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standalone_function_call")) return false;
    if (!nextTokenIs(b, "<standalone function call>", LOWER_ID, UPPER_ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STANDALONE_FUNCTION_CALL, "<standalone function call>");
    r = function_name(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    p = r; // pin = 2
    r = r && report_error_(b, standalone_function_call_2(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // arguments?
  private static boolean standalone_function_call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standalone_function_call_2")) return false;
    arguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // var_declaration_statement | expr
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = var_declaration_statement(b, l + 1);
    if (!r) r = expr(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING
  public static boolean stringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteral")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN var_definition (COMMA var_definition)* RPAREN
  public static boolean tuple_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_definition")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_DEFINITION, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, var_definition(b, l + 1));
    r = p && report_error_(b, tuple_definition_2(b, l + 1)) && r;
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA var_definition)*
  private static boolean tuple_definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_definition_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tuple_definition_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_definition_2", c)) break;
    }
    return true;
  }

  // COMMA var_definition
  private static boolean tuple_definition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_definition_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && var_definition(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // COLON type
  public static boolean type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_definition")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DEFINITION, null);
    r = consumeToken(b, COLON);
    p = r; // pin = 1
    r = r && type(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // UNIT
  public static boolean unitLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unitLiteral")) return false;
    if (!nextTokenIs(b, UNIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNIT);
    exit_section_(b, m, UNIT_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // (LET|STRICT) (tuple_definition | var_definition) ASSIGN (expr | closure)
  public static boolean var_declaration_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_declaration_statement")) return false;
    if (!nextTokenIs(b, "<var declaration statement>", LET, STRICT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECLARATION_STATEMENT, "<var declaration statement>");
    r = var_declaration_statement_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, var_declaration_statement_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, ASSIGN)) && r;
    r = p && var_declaration_statement_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // LET|STRICT
  private static boolean var_declaration_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_declaration_statement_0")) return false;
    boolean r;
    r = consumeToken(b, LET);
    if (!r) r = consumeToken(b, STRICT);
    return r;
  }

  // tuple_definition | var_definition
  private static boolean var_declaration_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_declaration_statement_1")) return false;
    boolean r;
    r = tuple_definition(b, l + 1);
    if (!r) r = var_definition(b, l + 1);
    return r;
  }

  // expr | closure
  private static boolean var_declaration_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_declaration_statement_3")) return false;
    boolean r;
    r = expr(b, l + 1, -1);
    if (!r) r = closure(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LOWER_ID | UPPER_ID
  public static boolean var_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definition")) return false;
    if (!nextTokenIs(b, "<var definition>", LOWER_ID, UPPER_ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_DEFINITION, "<var definition>");
    r = consumeToken(b, LOWER_ID);
    if (!r) r = consumeToken(b, UPPER_ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: BINARY(equal_expr) BINARY(not_equal_expr)
  // 1: ATOM(index_expr)
  // 2: BINARY(less_or_eq_expr) BINARY(more_or_eq_expr) BINARY(less_expr) BINARY(more_expr)
  //    BINARY(and_expr) BINARY(or_expr)
  // 3: BINARY(concat_expr) BINARY(append_expr) BINARY(prepend_expr)
  // 4: ATOM(unary_min_expr) ATOM(unary_not_expr)
  // 5: ATOM(func_expr) ATOM(array_expr) ATOM(pattern_matching_expr) ATOM(fold_expr)
  //    ATOM(tuple_expr)
  // 6: BINARY(plus_expr) BINARY(minus_expr)
  // 7: BINARY(mul_expr) BINARY(div_expr) BINARY(mod_expr)
  // 8: POSTFIX(expr_call) ATOM(struct_call) ATOM(function_call)
  // 9: ATOM(simple_ref_expr) ATOM(paren_expr) ATOM(literal_expr)
  // 10: ATOM(if_expr)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = index_expr(b, l + 1);
    if (!r) r = unary_min_expr(b, l + 1);
    if (!r) r = unary_not_expr(b, l + 1);
    if (!r) r = func_expr(b, l + 1);
    if (!r) r = array_expr(b, l + 1);
    if (!r) r = pattern_matching_expr(b, l + 1);
    if (!r) r = fold_expr(b, l + 1);
    if (!r) r = tuple_expr(b, l + 1);
    if (!r) r = struct_call(b, l + 1);
    if (!r) r = function_call(b, l + 1);
    if (!r) r = simple_ref_expr(b, l + 1);
    if (!r) r = paren_expr(b, l + 1);
    if (!r) r = literal_expr(b, l + 1);
    if (!r) r = if_expr(b, l + 1);
    p = r;
    r = r && expr_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expr_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && consumeTokenSmart(b, EQ)) {
        r = expr(b, l, 0);
        exit_section_(b, l, m, EQUAL_EXPR, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, NOT_EQ)) {
        r = expr(b, l, 0);
        exit_section_(b, l, m, NOT_EQUAL_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, LESS_OR_EQUAL)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, LESS_OR_EQ_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, GREATER_OR_EQUAL)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, MORE_OR_EQ_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, LESS)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, LESS_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, GT)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, MORE_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, COND_AND)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, AND_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, COND_OR)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, OR_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, CONCAT)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, CONCAT_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, APPEND)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, APPEND_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, PREPEND)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, PREPEND_EXPR, r, true, null);
      }
      else if (g < 6 && consumeTokenSmart(b, PLUS)) {
        r = expr(b, l, 6);
        exit_section_(b, l, m, PLUS_EXPR, r, true, null);
      }
      else if (g < 6 && consumeTokenSmart(b, MINUS)) {
        r = expr(b, l, 6);
        exit_section_(b, l, m, MINUS_EXPR, r, true, null);
      }
      else if (g < 7 && consumeTokenSmart(b, MUL)) {
        r = expr(b, l, 7);
        exit_section_(b, l, m, MUL_EXPR, r, true, null);
      }
      else if (g < 7 && consumeTokenSmart(b, SLASH)) {
        r = expr(b, l, 7);
        exit_section_(b, l, m, DIV_EXPR, r, true, null);
      }
      else if (g < 7 && consumeTokenSmart(b, PERCENT)) {
        r = expr(b, l, 7);
        exit_section_(b, l, m, MOD_EXPR, r, true, null);
      }
      else if (g < 8 && call_chain(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, EXPR_CALL, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // (standalone_function_call | object_function_call | field_call | simple_ref_expr) LBRACKET expr RBRACKET (DOT expr)?
  public static boolean index_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "index_expr")) return false;
    if (!nextTokenIsSmart(b, LOWER_ID, UPPER_ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INDEX_EXPR, "<index expr>");
    r = index_expr_0(b, l + 1);
    r = r && consumeToken(b, LBRACKET);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, RBRACKET);
    r = r && index_expr_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // standalone_function_call | object_function_call | field_call | simple_ref_expr
  private static boolean index_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "index_expr_0")) return false;
    boolean r;
    r = standalone_function_call(b, l + 1);
    if (!r) r = object_function_call(b, l + 1);
    if (!r) r = field_call(b, l + 1);
    if (!r) r = simple_ref_expr(b, l + 1);
    return r;
  }

  // (DOT expr)?
  private static boolean index_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "index_expr_4")) return false;
    index_expr_4_0(b, l + 1);
    return true;
  }

  // DOT expr
  private static boolean index_expr_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "index_expr_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, DOT);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MINUS expr
  public static boolean unary_min_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_min_expr")) return false;
    if (!nextTokenIsSmart(b, MINUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNARY_MIN_EXPR, null);
    r = consumeTokenSmart(b, MINUS);
    p = r; // pin = 1
    r = r && expr(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // BANG expr
  public static boolean unary_not_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_not_expr")) return false;
    if (!nextTokenIsSmart(b, BANG)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNARY_NOT_EXPR, null);
    r = consumeTokenSmart(b, BANG);
    p = r; // pin = 1
    r = r && expr(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // annotation_expr? FUNCTION function_name LPAREN param_group? RPAREN ASSIGN closure
  public static boolean func_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_expr")) return false;
    if (!nextTokenIsSmart(b, AT_SYMBOL, FUNCTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNC_EXPR, "<func expr>");
    r = func_expr_0(b, l + 1);
    r = r && consumeToken(b, FUNCTION);
    p = r; // pin = 2
    r = r && report_error_(b, function_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LPAREN)) && r;
    r = p && report_error_(b, func_expr_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokensSmart(b, -1, RPAREN, ASSIGN)) && r;
    r = p && closure(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // annotation_expr?
  private static boolean func_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_expr_0")) return false;
    annotation_expr(b, l + 1);
    return true;
  }

  // param_group?
  private static boolean func_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_expr_4")) return false;
    param_group(b, l + 1);
    return true;
  }

  // LBRACKET arguments? RBRACKET call_chain?
  public static boolean array_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expr")) return false;
    if (!nextTokenIsSmart(b, LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_EXPR, null);
    r = consumeTokenSmart(b, LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, array_expr_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, RBRACKET)) && r;
    r = p && array_expr_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // arguments?
  private static boolean array_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expr_1")) return false;
    arguments(b, l + 1);
    return true;
  }

  // call_chain?
  private static boolean array_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expr_3")) return false;
    call_chain(b, l + 1);
    return true;
  }

  // MATCH expr LBRACE case_expr*  RBRACE
  public static boolean pattern_matching_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_matching_expr")) return false;
    if (!nextTokenIsSmart(b, MATCH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_MATCHING_EXPR, null);
    r = consumeTokenSmart(b, MATCH);
    p = r; // pin = 1
    r = r && report_error_(b, expr(b, l + 1, -1));
    r = p && report_error_(b, consumeToken(b, LBRACE)) && r;
    r = p && report_error_(b, pattern_matching_expr_3(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // case_expr*
  private static boolean pattern_matching_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_matching_expr_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!case_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_matching_expr_3", c)) break;
    }
    return true;
  }

  // FOLD_KW LESS INTEGER GT call_arguments
  public static boolean fold_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fold_expr")) return false;
    if (!nextTokenIsSmart(b, FOLD_KW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FOLD_EXPR, null);
    r = consumeTokensSmart(b, 1, FOLD_KW, LESS, INTEGER, GT);
    p = r; // pin = 1
    r = r && call_arguments(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // call_arguments
  public static boolean tuple_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_expr")) return false;
    if (!nextTokenIsSmart(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_arguments(b, l + 1);
    exit_section_(b, m, TUPLE_EXPR, r);
    return r;
  }

  // type LPAREN arguments? RPAREN
  public static boolean struct_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_call")) return false;
    if (!nextTokenIsSmart(b, LPAREN, UPPER_ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_CALL, "<struct call>");
    r = type(b, l + 1, -1);
    r = r && consumeToken(b, LPAREN);
    r = r && struct_call_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // arguments?
  private static boolean struct_call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_call_2")) return false;
    arguments(b, l + 1);
    return true;
  }

  // object_function_call | standalone_function_call
  public static boolean function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call")) return false;
    if (!nextTokenIsSmart(b, LOWER_ID, UPPER_ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, FUNCTION_CALL, "<function call>");
    r = object_function_call(b, l + 1);
    if (!r) r = standalone_function_call(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LOWER_ID | UPPER_ID
  public static boolean simple_ref_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_ref_expr")) return false;
    if (!nextTokenIsSmart(b, LOWER_ID, UPPER_ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_REF_EXPR, "<simple ref expr>");
    r = consumeTokenSmart(b, LOWER_ID);
    if (!r) r = consumeTokenSmart(b, UPPER_ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN expr RPAREN
  public static boolean paren_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr")) return false;
    if (!nextTokenIsSmart(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PAREN_EXPR, null);
    r = consumeTokenSmart(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, expr(b, l + 1, -1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // boolLiteral
  //           | numericLiteral
  //           | stringLiteral
  //           | byteVectorLiteral
  //           | nilLiteral
  //           | unitLiteral
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = boolLiteral(b, l + 1);
    if (!r) r = numericLiteral(b, l + 1);
    if (!r) r = stringLiteral(b, l + 1);
    if (!r) r = byteVectorLiteral(b, l + 1);
    if (!r) r = nilLiteral(b, l + 1);
    if (!r) r = unitLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IF if_cond (THEN? closure) else_if_block* else_block?
  // | IF LPAREN if_cond RPAREN (THEN? closure) else_if_block* else_block?
  public static boolean if_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr")) return false;
    if (!nextTokenIsSmart(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_expr_0(b, l + 1);
    if (!r) r = if_expr_1(b, l + 1);
    exit_section_(b, m, IF_EXPR, r);
    return r;
  }

  // IF if_cond (THEN? closure) else_if_block* else_block?
  private static boolean if_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IF);
    r = r && if_cond(b, l + 1);
    r = r && if_expr_0_2(b, l + 1);
    r = r && if_expr_0_3(b, l + 1);
    r = r && if_expr_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THEN? closure
  private static boolean if_expr_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_expr_0_2_0(b, l + 1);
    r = r && closure(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THEN?
  private static boolean if_expr_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_0_2_0")) return false;
    consumeTokenSmart(b, THEN);
    return true;
  }

  // else_if_block*
  private static boolean if_expr_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!else_if_block(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_expr_0_3", c)) break;
    }
    return true;
  }

  // else_block?
  private static boolean if_expr_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_0_4")) return false;
    else_block(b, l + 1);
    return true;
  }

  // IF LPAREN if_cond RPAREN (THEN? closure) else_if_block* else_block?
  private static boolean if_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, IF, LPAREN);
    r = r && if_cond(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && if_expr_1_4(b, l + 1);
    r = r && if_expr_1_5(b, l + 1);
    r = r && if_expr_1_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THEN? closure
  private static boolean if_expr_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_1_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_expr_1_4_0(b, l + 1);
    r = r && closure(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THEN?
  private static boolean if_expr_1_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_1_4_0")) return false;
    consumeTokenSmart(b, THEN);
    return true;
  }

  // else_if_block*
  private static boolean if_expr_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_1_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!else_if_block(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_expr_1_5", c)) break;
    }
    return true;
  }

  // else_block?
  private static boolean if_expr_1_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_1_6")) return false;
    else_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Expression root: type
  // Operator priority table:
  // 0: ATOM(tuple_type)
  // 1: ATOM(array_type)
  // 2: POSTFIX(union_type)
  // 3: ATOM(simple_type)
  public static boolean type(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "type")) return false;
    addVariant(b, "<type>");
    if (!nextTokenIsSmart(b, LPAREN, UPPER_ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<type>");
    r = tuple_type(b, l + 1);
    if (!r) r = array_type(b, l + 1);
    if (!r) r = simple_type(b, l + 1);
    p = r;
    r = r && type_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean type_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "type_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 2 && union_type_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, UNION_TYPE, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // LPAREN type (COMMA type)* RPAREN
  public static boolean tuple_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_type")) return false;
    if (!nextTokenIsSmart(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_TYPE, null);
    r = consumeTokenSmart(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, type(b, l + 1, -1));
    r = p && report_error_(b, tuple_type_2(b, l + 1)) && r;
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA type)*
  private static boolean tuple_type_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_type_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tuple_type_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_type_2", c)) break;
    }
    return true;
  }

  // COMMA type
  private static boolean tuple_type_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_type_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokenSmart(b, COMMA);
    p = r; // pin = 1
    r = r && type(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // UPPER_ID LBRACKET type RBRACKET
  public static boolean array_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type")) return false;
    if (!nextTokenIsSmart(b, UPPER_ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_TYPE, null);
    r = consumeTokensSmart(b, 2, UPPER_ID, LBRACKET);
    p = r; // pin = 2
    r = r && report_error_(b, type(b, l + 1, -1));
    r = p && consumeToken(b, RBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // BIT_OR (type|NIL|UNIT) (BIT_OR (type|NIL|UNIT))*
  private static boolean union_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_type_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BIT_OR);
    r = r && union_type_0_1(b, l + 1);
    r = r && union_type_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // type|NIL|UNIT
  private static boolean union_type_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_type_0_1")) return false;
    boolean r;
    r = type(b, l + 1, -1);
    if (!r) r = consumeTokenSmart(b, NIL);
    if (!r) r = consumeTokenSmart(b, UNIT);
    return r;
  }

  // (BIT_OR (type|NIL|UNIT))*
  private static boolean union_type_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_type_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!union_type_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "union_type_0_2", c)) break;
    }
    return true;
  }

  // BIT_OR (type|NIL|UNIT)
  private static boolean union_type_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_type_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, BIT_OR);
    r = r && union_type_0_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // type|NIL|UNIT
  private static boolean union_type_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_type_0_2_0_1")) return false;
    boolean r;
    r = type(b, l + 1, -1);
    if (!r) r = consumeTokenSmart(b, NIL);
    if (!r) r = consumeTokenSmart(b, UNIT);
    return r;
  }

  // UPPER_ID
  public static boolean simple_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_type")) return false;
    if (!nextTokenIsSmart(b, UPPER_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, UPPER_ID);
    exit_section_(b, m, SIMPLE_TYPE, r);
    return r;
  }

}
