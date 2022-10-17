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
    create_token_set_(CALL_EXPR, DIV_EXPR, EQUAL_EXPR, EXPR,
      LESS_EXPR, MINUS_EXPR, MORE_EXPR, MUL_EXPR,
      NOT_EQUAL_EXPR, PAREN_EXPR, PLUS_EXPR, SIMPLE_REF_EXPR,
      UNARY_MIN_EXPR, UNARY_NOT_EXPR),
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
  // expr
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = expr(b, l + 1, -1);
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
  // '{-#' IDENTIFIER (IDENTIFIER|NUMBER) '#-}'
  static boolean directive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive")) return false;
    if (!nextTokenIs(b, LDBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LDBRACKET, IDENTIFIER);
    r = r && directive_2(b, l + 1);
    r = r && consumeToken(b, RDBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER|NUMBER
  private static boolean directive_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_2")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
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
  // all
  static boolean program(PsiBuilder b, int l) {
    return all(b, l + 1);
  }

  /* ********************************************************** */
  // !(ASSIGN | FUNCTION | LET | TRUE | FALSE |IF |ELSE |RETURN
  // | INT | STRING | IDENTIFIER | PLUS | MINUS| BANG | ASTERISK |SLASH | LT |GT|EQ
  // | NOT_EQ | COMMA | COLON | LPAREN |RPAREN |LBRACE |RBRACE | LBRACKET | RBRACKET)
  static boolean property_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !property_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ASSIGN | FUNCTION | LET | TRUE | FALSE |IF |ELSE |RETURN
  // | INT | STRING | IDENTIFIER | PLUS | MINUS| BANG | ASTERISK |SLASH | LT |GT|EQ
  // | NOT_EQ | COMMA | COLON | LPAREN |RPAREN |LBRACE |RBRACE | LBRACKET | RBRACKET
  private static boolean property_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover_0")) return false;
    boolean r;
    r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, FUNCTION);
    if (!r) r = consumeToken(b, LET);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, ELSE);
    if (!r) r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, ASTERISK);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NOT_EQ);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, RBRACKET);
    return r;
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
  // LET var_definition ASSIGN expr
  public static boolean var_declaration_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_declaration_statement")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && var_definition(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, VAR_DECLARATION_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean var_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definition")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, VAR_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: BINARY(equal_expr) BINARY(not_equal_expr)
  // 1: BINARY(less_expr) BINARY(more_expr)
  // 2: BINARY(plus_expr) BINARY(minus_expr)
  // 3: BINARY(mul_expr) BINARY(div_expr)
  // 4: ATOM(unary_min_expr) ATOM(unary_not_expr)
  // 5: POSTFIX(call_expr)
  // 6: ATOM(simple_ref_expr) ATOM(paren_expr)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = unary_min_expr(b, l + 1);
    if (!r) r = unary_not_expr(b, l + 1);
    if (!r) r = simple_ref_expr(b, l + 1);
    if (!r) r = paren_expr(b, l + 1);
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
      else if (g < 1 && consumeTokenSmart(b, LT)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, LESS_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, GT)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, MORE_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, PLUS)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, PLUS_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, MINUS)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, MINUS_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, ASTERISK)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, MUL_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, SLASH)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, DIV_EXPR, r, true, null);
      }
      else if (g < 5 && call_arguments(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CALL_EXPR, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
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

  // IDENT
  public static boolean simple_ref_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_ref_expr")) return false;
    if (!nextTokenIsSmart(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IDENT);
    exit_section_(b, m, SIMPLE_REF_EXPR, r);
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

}
