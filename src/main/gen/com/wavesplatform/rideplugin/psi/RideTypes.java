// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.wavesplatform.rideplugin.psi.impl.*;

public interface RideTypes {

  IElementType PROPERTY = new RideElementType("PROPERTY");

  IElementType COMMENT = new RideTokenType("COMMENT");
  IElementType CRLF = new RideTokenType("CRLF");
  IElementType KEY = new RideTokenType("KEY");
  IElementType SEPARATOR = new RideTokenType("SEPARATOR");
  IElementType VALUE = new RideTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new RidePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
