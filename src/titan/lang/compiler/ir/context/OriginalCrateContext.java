package titan.lang.compiler.ir.context;

import java.util.HashSet;
import java.util.Set;
import titan.lang.compiler.ir.original.OriginalModule;

/**
 * .
 *
 * @author tian wei jun
 */
public class OriginalCrateContext {
  public String name = "";
  // primitives
  public OriginalPrimitivesCrateContext primitivesCrate = new OriginalPrimitivesCrateContext();
  // 所有模块
  public Set<OriginalModule> modules = new HashSet<OriginalModule>();
  // crate所依赖的非本身crate lib
  // from CrateRuntimeContext.dependencyCrateLibsPool
  // lib中模块的全限定名称不能重复
  // List<OriginalSharedCrateContext> dependencyCrates = new ArrayList<>();
  // 当前项目实际依赖的所有lib
  // public List<OriginalSharedCrateContext> dependencyCratePool = new ArrayList<>();
  // 当前项目实际依赖的所有lib
  // public List<OriginalSharedCrateContext> dependencyCratePool = new ArrayList<>();

}
