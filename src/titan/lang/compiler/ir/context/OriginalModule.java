package titan.lang.compiler.ir.context;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import titan.lang.compiler.ir.ast.derivation.Derivation;
import titan.lang.compiler.ir.ast.tree.LanguageContextTree;
import titan.lang.compiler.ir.shared.SharedIrModule;

/**
 * .
 *
 * @author tian wei jun
 */
public class OriginalModule {
  public String id = "";

  public OriginalModule parent = null;
  public List<OriginalModule> children = new ArrayList<>();

  public OriginalModuleScopeElements elements = new OriginalModuleScopeElements();
  // 当前模块所声明导入的模块
  // from CrateLibContext.dependencyCrateLibs
  public List<String> importStrings = new LinkedList<String>();
  // 推导的符号
  public Derivation derivation = new Derivation();

  // temp
  public LanguageContextTree tree = null;

  public SharedIrModule toSharedIrModule() {
    return null;
  }
}
