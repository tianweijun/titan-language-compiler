package titan.lang.compiler.ir.original.ast;

import titan.ast.runtime.Ast;
import titan.ast.runtime.RuntimeAutomataAstApplication;
import titan.lang.compiler.context.CompilerContext;

/**
 * .
 *
 * @author tian wei jun
 */
public class AstBuilder {
  RuntimeAutomataAstApplication astApplication;

  public AstBuilder() {
    astApplication = CompilerContext.get().getAstApplication();
  }

  public ContextAst build(String moduleFilePath) {
    Ast ast = astApplication.buildAst(moduleFilePath);
    return new Ast2ContextAstConvertor(ast).convert();
  }
}
