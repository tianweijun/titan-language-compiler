package titan.lang.compiler.ir.context;

import java.util.LinkedList;
import java.util.List;

/**
 * .
 *
 * @author tian wei jun
 */
public class OriginalCrateContext {
  public String name = "";
  // 所有模块
  public List<OriginalModule> modules = new LinkedList<OriginalModule>();
  // crate所依赖的非本身crate lib
  // from CrateRuntimeContext.dependencyCrateLibsPool
  // lib中模块的全限定名称不能重复
  // List<OriginalSharedCrateContext> dependencyCrates = new ArrayList<>();
}
