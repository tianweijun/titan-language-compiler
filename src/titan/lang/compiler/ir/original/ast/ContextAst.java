package titan.lang.compiler.ir.original.ast;

import titan.ast.runtime.Ast;
import titan.ast.runtime.Grammar;
import titan.lang.compiler.ir.original.ast.context.Context;

/**
 * .
 *
 * @author tian wei jun
 */
public class ContextAst extends Ast {
  public ContextAst parent = null;
  public Context context = null;

  public ContextAst(Grammar grammar, String alias) {
    super(grammar, alias);
  }
}
