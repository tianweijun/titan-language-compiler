package titan.lang.compiler.ir.original;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import titan.lang.compiler.ir.derivation.Derivation;
import titan.lang.compiler.ir.original.ast.node.ContextAst;
import titan.lang.compiler.ir.shared.SharedIrModule;

/**
 * 一个完整成熟的OriginalModule可直接转为SharedIrModule.
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
  public ContextAst tree = null;

  public SharedIrModule toSharedIrModule() {
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OriginalModule that = (OriginalModule) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
