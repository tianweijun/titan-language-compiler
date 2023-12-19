package titan.lang.compiler.ir.original.ast;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import titan.ast.runtime.Ast;
import titan.ast.runtime.Grammar;
import titan.ast.runtime.GrammarType;
import titan.lang.compiler.exception.CompilerRuntimeException;
import titan.lang.compiler.ir.original.ast.context.Context;

/**
 * .
 *
 * @author tian wei jun
 */
public class Ast2ContextAstConvertor {
  Ast source;

  public Ast2ContextAstConvertor(Ast source) {
    this.source = source;
  }

  public ContextAst convert() {
    return doConvert(source);
  }

  private ContextAst doConvert(Ast ast) {
    ContextAst contextAst = createContextAstByAst(ast);
    for (Ast astChild : ast.children) {
      ContextAst child = doConvert(astChild);
      child.parent = contextAst;
      contextAst.children.add(child);
    }
    return contextAst;
  }

  private ContextAst createContextAstByAst(Ast ast) {
    ContextAst contextAst = new ContextAst(ast.grammar, ast.alias);
    contextAst.token = ast.token;
    contextAst.context = createContextByAst(ast);
    return contextAst;
  }

  private Context createContextByAst(Ast ast) {
    Grammar grammar = ast.grammar;
    if (grammar.getType() != GrammarType.NONTERMINAL) {
      return null;
    }
    Context context = null;
    String className = getContextClassNameByGrammarName(grammar.getName());
    try {
      Class<?> contextClass = Class.forName(className);
      Constructor<?> constructor = contextClass.getDeclaredConstructor();
      context = (Context) constructor.newInstance();
    } catch (ClassNotFoundException
        | NoSuchMethodException
        | IllegalAccessException
        | InstantiationException
        | InvocationTargetException e) {
      throw new CompilerRuntimeException(e);
    }
    return context;
  }

  private String getContextClassNameByGrammarName(String grammarName) {
    String className = grammarName;
    char[] chars = className.toCharArray();
    char fchar = chars[0];
    if (97 <= fchar && fchar <= 122) { // 首字母小写转大写
      fchar ^= 32;
      chars[0] = fchar;
      className = new String(chars);
    }
    className = "titan.lang.compiler.ir.original.ast.context." + className + "Context";
    return className;
  }
}
