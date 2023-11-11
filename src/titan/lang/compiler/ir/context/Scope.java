package titan.lang.compiler.ir.context;

import java.util.ArrayList;
import java.util.List;
import titan.lang.compiler.ir.ast.tree.LanguageContextTree;

/**
 * .
 *
 * @author tian wei jun
 */
public class Scope {
  public Scope parent;
  public List<Scope> children = new ArrayList<>();

  public LanguageContextTree tree;
}
