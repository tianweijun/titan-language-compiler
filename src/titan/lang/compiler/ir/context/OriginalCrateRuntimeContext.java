package titan.lang.compiler.ir.context;

/**
 * .
 *
 * @author tian wei jun
 */
public class OriginalCrateRuntimeContext {
  // primitives
  public OriginalPrimitivesCrateContext primitivesCrate = new OriginalPrimitivesCrateContext();
  // 当前项目crate
  public OriginalCrateContext crate = new OriginalCrateContext();
  // 当前项目实际依赖的所有lib
  // public List<OriginalSharedCrateContext> dependencyCratePool = new ArrayList<>();
}
