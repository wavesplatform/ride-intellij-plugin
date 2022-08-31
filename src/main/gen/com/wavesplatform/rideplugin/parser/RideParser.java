// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.wavesplatform.rideplugin.psi.RideTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
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
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return File(b, l + 1);
  }

  /* ********************************************************** */
  // BooleanLiteral | StringLiteral | NumberLiteral | IntLiteral |
  // UnitLiteral | BaseLiteral | ArrayElementAtIndex | ObjectFieldCall | StructCreation | IDENTIFIER
  public static boolean ArgumentDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_DEFINITION, "<argument definition>");
    r = BooleanLiteral(b, l + 1);
    if (!r) r = StringLiteral(b, l + 1);
    if (!r) r = NumberLiteral(b, l + 1);
    if (!r) r = IntLiteral(b, l + 1);
    if (!r) r = UnitLiteral(b, l + 1);
    if (!r) r = BaseLiteral(b, l + 1);
    if (!r) r = ArrayElementAtIndex(b, l + 1);
    if (!r) r = ObjectFieldCall(b, l + 1);
    if (!r) r = StructCreation(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN ArgumentDefinition? (COMMA ArgumentDefinition)* RPAREN
  public static boolean ArgumentsDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentsDefinition")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && ArgumentsDefinition_1(b, l + 1);
    r = r && ArgumentsDefinition_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ARGUMENTS_DEFINITION, r);
    return r;
  }

  // ArgumentDefinition?
  private static boolean ArgumentsDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentsDefinition_1")) return false;
    ArgumentDefinition(b, l + 1);
    return true;
  }

  // (COMMA ArgumentDefinition)*
  private static boolean ArgumentsDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentsDefinition_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArgumentsDefinition_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArgumentsDefinition_2", c)) break;
    }
    return true;
  }

  // COMMA ArgumentDefinition
  private static boolean ArgumentsDefinition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentsDefinition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ArgumentDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACK ArgumentDefinition? (COMMA ArgumentDefinition)* RBRACK
  public static boolean ArrayDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayDefinition")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && ArrayDefinition_1(b, l + 1);
    r = r && ArrayDefinition_2(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, ARRAY_DEFINITION, r);
    return r;
  }

  // ArgumentDefinition?
  private static boolean ArrayDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayDefinition_1")) return false;
    ArgumentDefinition(b, l + 1);
    return true;
  }

  // (COMMA ArgumentDefinition)*
  private static boolean ArrayDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayDefinition_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArrayDefinition_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArrayDefinition_2", c)) break;
    }
    return true;
  }

  // COMMA ArgumentDefinition
  private static boolean ArrayDefinition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayDefinition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ArgumentDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ObjectFieldCall LBRACK INT RBRACK
  public static boolean ArrayElementAtIndex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayElementAtIndex")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ObjectFieldCall(b, l + 1);
    r = r && consumeTokens(b, 0, LBRACK, INT, RBRACK);
    exit_section_(b, m, ARRAY_ELEMENT_AT_INDEX, r);
    return r;
  }

  /* ********************************************************** */
  // (base16|base58|base64) StringLiteral
  public static boolean BaseLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BaseLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASE_LITERAL, "<base literal>");
    r = BaseLiteral_0(b, l + 1);
    r = r && StringLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // base16|base58|base64
  private static boolean BaseLiteral_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BaseLiteral_0")) return false;
    boolean r;
    r = consumeToken(b, BASE16);
    if (!r) r = consumeToken(b, BASE58);
    if (!r) r = consumeToken(b, BASE64);
    return r;
  }

  /* ********************************************************** */
  // true | false
  public static boolean BooleanLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BooleanLiteral")) return false;
    if (!nextTokenIs(b, "<boolean literal>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_LITERAL, "<boolean literal>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MetaDefinition* FunctionDefinition
  public static boolean Definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION, "<definition>");
    r = Definition_0(b, l + 1);
    r = r && FunctionDefinition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // MetaDefinition*
  private static boolean Definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!MetaDefinition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Definition_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // Definition*
  static boolean File(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "File")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "File", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // Statement*
  public static boolean FunctionBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionBody")) return false;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_BODY, "<function body>");
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionBody", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // func FunctionSignature ASSIGN (LBRACE FunctionBody RBRACE | FunctionInvocation)
  public static boolean FunctionDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition")) return false;
    if (!nextTokenIs(b, FUNC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNC);
    r = r && FunctionSignature(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && FunctionDefinition_3(b, l + 1);
    exit_section_(b, m, FUNCTION_DEFINITION, r);
    return r;
  }

  // LBRACE FunctionBody RBRACE | FunctionInvocation
  private static boolean FunctionDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionDefinition_3_0(b, l + 1);
    if (!r) r = FunctionInvocation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBRACE FunctionBody RBRACE
  private static boolean FunctionDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && FunctionBody(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ArgumentsDefinition
  public static boolean FunctionInvocation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionInvocation")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && ArgumentsDefinition(b, l + 1);
    exit_section_(b, m, FUNCTION_INVOCATION, r);
    return r;
  }

  /* ********************************************************** */
  // ArgumentsDefinition
  public static boolean FunctionParamsDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParamsDefinition")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArgumentsDefinition(b, l + 1);
    exit_section_(b, m, FUNCTION_PARAMS_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER FunctionParamsDefinition
  public static boolean FunctionSignature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionSignature")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && FunctionParamsDefinition(b, l + 1);
    exit_section_(b, m, FUNCTION_SIGNATURE, r);
    return r;
  }

  /* ********************************************************** */
  // INT
  public static boolean IntLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IntLiteral")) return false;
    if (!nextTokenIs(b, INT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INT);
    exit_section_(b, m, INT_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // let IDENTIFIER ASSIGN (FunctionInvocation | StructCreation | MethodInvocation)
  public static boolean LetDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LetDefinition")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LET, IDENTIFIER, ASSIGN);
    r = r && LetDefinition_3(b, l + 1);
    exit_section_(b, m, LET_DEFINITION, r);
    return r;
  }

  // FunctionInvocation | StructCreation | MethodInvocation
  private static boolean LetDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LetDefinition_3")) return false;
    boolean r;
    r = FunctionInvocation(b, l + 1);
    if (!r) r = StructCreation(b, l + 1);
    if (!r) r = MethodInvocation(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '{-#' IDENTIFIER (IDENTIFIER|NUMBER) '#-}'
  public static boolean MetaDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MetaDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, META_DEFINITION, "<meta definition>");
    r = consumeToken(b, "{-#");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && MetaDefinition_2(b, l + 1);
    r = r && consumeToken(b, "#-}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER|NUMBER
  private static boolean MetaDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MetaDefinition_2")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER DOT FunctionInvocation
  public static boolean MethodInvocation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodInvocation")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, DOT);
    r = r && FunctionInvocation(b, l + 1);
    exit_section_(b, m, METHOD_INVOCATION, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER
  public static boolean NumberLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumberLiteral")) return false;
    if (!nextTokenIs(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    exit_section_(b, m, NUMBER_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER DOT IDENTIFIER
  public static boolean ObjectFieldCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectFieldCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, DOT, IDENTIFIER);
    exit_section_(b, m, OBJECT_FIELD_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // LetDefinition | FunctionInvocation | COMMENT | ArrayDefinition
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = LetDefinition(b, l + 1);
    if (!r) r = FunctionInvocation(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = ArrayDefinition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING
  public static boolean StringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringLiteral")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ArgumentsDefinition
  public static boolean StructCreation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructCreation")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && ArgumentsDefinition(b, l + 1);
    exit_section_(b, m, STRUCT_CREATION, r);
    return r;
  }

  /* ********************************************************** */
  // unit
  public static boolean UnitLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnitLiteral")) return false;
    if (!nextTokenIs(b, UNIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNIT);
    exit_section_(b, m, UNIT_LITERAL, r);
    return r;
  }

}
