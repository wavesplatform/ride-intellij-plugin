// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.wavesplatform.rideplugin.psi.impl.RideElementTypeFactory;
import com.wavesplatform.rideplugin.psi.impl.*;

public interface RideTypes {

  IElementType ALL = new RideElementType("ALL");
  IElementType ARGUMENT = new RideElementType("ARGUMENT");
  IElementType ARGUMENTS = new RideElementType("ARGUMENTS");
  IElementType CALL_ARGUMENTS = new RideElementType("CALL_ARGUMENTS");
  IElementType CALL_EXPR = new RideElementType("CALL_EXPR");
  IElementType DIV_EXPR = new RideElementType("DIV_EXPR");
  IElementType EQUAL_EXPR = new RideElementType("EQUAL_EXPR");
  IElementType EXPR = new RideElementType("EXPR");
  IElementType LESS_EXPR = new RideElementType("LESS_EXPR");
  IElementType MINUS_EXPR = new RideElementType("MINUS_EXPR");
  IElementType MORE_EXPR = new RideElementType("MORE_EXPR");
  IElementType MUL_EXPR = new RideElementType("MUL_EXPR");
  IElementType NOT_EQUAL_EXPR = new RideElementType("NOT_EQUAL_EXPR");
  IElementType PAREN_EXPR = new RideElementType("PAREN_EXPR");
  IElementType PLUS_EXPR = new RideElementType("PLUS_EXPR");
  IElementType SIMPLE_REF_EXPR = new RideElementType("SIMPLE_REF_EXPR");
  IElementType STATEMENT = new RideElementType("STATEMENT");
  IElementType UNARY_MIN_EXPR = new RideElementType("UNARY_MIN_EXPR");
  IElementType UNARY_NOT_EXPR = new RideElementType("UNARY_NOT_EXPR");
  IElementType VAR_DECLARATION_STATEMENT = new RideElementType("VAR_DECLARATION_STATEMENT");
  IElementType VAR_DEFINITION = RideElementTypeFactory.factory("VAR_DEFINITION");

  IElementType ASSIGN = new RideTokenType("=");
  IElementType ASTERISK = new RideTokenType("ASTERISK");
  IElementType BANG = new RideTokenType("!");
  IElementType BIT_AND = new RideTokenType("&");
  IElementType BIT_AND_ASSIGN = new RideTokenType("&=");
  IElementType BIT_CLEAR = new RideTokenType("&^");
  IElementType BIT_CLEAR_ASSIGN = new RideTokenType("&^=");
  IElementType BIT_OR = new RideTokenType("|");
  IElementType BIT_OR_ASSIGN = new RideTokenType("|=");
  IElementType BOOL = new RideTokenType("BOOL");
  IElementType COLON = new RideTokenType(":");
  IElementType COMMA = new RideTokenType(",");
  IElementType COMMENT = new RideTokenType("COMMENT");
  IElementType COND_AND = new RideTokenType("&&");
  IElementType COND_OR = new RideTokenType("||");
  IElementType DOT = new RideTokenType(".");
  IElementType ELSE = new RideTokenType("else");
  IElementType EQ = new RideTokenType("==");
  IElementType FALSE = new RideTokenType("false");
  IElementType FUNCTION = new RideTokenType("func");
  IElementType GREATER = new RideTokenType(">");
  IElementType GREATER_OR_EQUAL = new RideTokenType(">=");
  IElementType GT = new RideTokenType("GT");
  IElementType IDENT = new RideTokenType("IDENT");
  IElementType IDENTIFIER = new RideTokenType("IDENTIFIER");
  IElementType IF = new RideTokenType("if");
  IElementType INT = new RideTokenType("INT");
  IElementType INTEGER = new RideTokenType("INTEGER");
  IElementType LBRACE = new RideTokenType("{");
  IElementType LBRACK = new RideTokenType("[");
  IElementType LBRACKET = new RideTokenType("LBRACKET");
  IElementType LDBRACKET = new RideTokenType("{-#");
  IElementType LESS = new RideTokenType("<");
  IElementType LET = new RideTokenType("let");
  IElementType LPAREN = new RideTokenType("(");
  IElementType LT = new RideTokenType("LT");
  IElementType MINUS = new RideTokenType("-");
  IElementType MINUS_ASSIGN = new RideTokenType("-=");
  IElementType MINUS_MINUS = new RideTokenType("--");
  IElementType MUL = new RideTokenType("*");
  IElementType NOT_EQ = new RideTokenType("!=");
  IElementType NUMBER = new RideTokenType("NUMBER");
  IElementType PLUS = new RideTokenType("+");
  IElementType QUOTIENT = new RideTokenType("/");
  IElementType RBRACE = new RideTokenType("}");
  IElementType RBRACK = new RideTokenType("]");
  IElementType RBRACKET = new RideTokenType("RBRACKET");
  IElementType RDBRACKET = new RideTokenType("#-}");
  IElementType RETURN = new RideTokenType("RETURN");
  IElementType RPAREN = new RideTokenType(")");
  IElementType SLASH = new RideTokenType("SLASH");
  IElementType STRICT = new RideTokenType("strict");
  IElementType STRING = new RideTokenType("STRING");
  IElementType TRUE = new RideTokenType("true");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALL) {
        return new RideAllImpl(node);
      }
      else if (type == ARGUMENT) {
        return new RideArgumentImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new RideArgumentsImpl(node);
      }
      else if (type == CALL_ARGUMENTS) {
        return new RideCallArgumentsImpl(node);
      }
      else if (type == CALL_EXPR) {
        return new RideCallExprImpl(node);
      }
      else if (type == DIV_EXPR) {
        return new RideDivExprImpl(node);
      }
      else if (type == EQUAL_EXPR) {
        return new RideEqualExprImpl(node);
      }
      else if (type == LESS_EXPR) {
        return new RideLessExprImpl(node);
      }
      else if (type == MINUS_EXPR) {
        return new RideMinusExprImpl(node);
      }
      else if (type == MORE_EXPR) {
        return new RideMoreExprImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new RideMulExprImpl(node);
      }
      else if (type == NOT_EQUAL_EXPR) {
        return new RideNotEqualExprImpl(node);
      }
      else if (type == PAREN_EXPR) {
        return new RideParenExprImpl(node);
      }
      else if (type == PLUS_EXPR) {
        return new RidePlusExprImpl(node);
      }
      else if (type == SIMPLE_REF_EXPR) {
        return new RideSimpleRefExprImpl(node);
      }
      else if (type == STATEMENT) {
        return new RideStatementImpl(node);
      }
      else if (type == UNARY_MIN_EXPR) {
        return new RideUnaryMinExprImpl(node);
      }
      else if (type == UNARY_NOT_EXPR) {
        return new RideUnaryNotExprImpl(node);
      }
      else if (type == VAR_DECLARATION_STATEMENT) {
        return new RideVarDeclarationStatementImpl(node);
      }
      else if (type == VAR_DEFINITION) {
        return new RideVarDefinitionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
