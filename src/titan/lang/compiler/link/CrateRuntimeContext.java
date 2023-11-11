package titan.lang.compiler.link;

import java.util.ArrayList;
import java.util.List;

/**
 * .
 *
 * @author tian wei jun
 */
public class CrateRuntimeContext {
  // primitives
  PrimitivesCrateMetaLibContext primitivesMetaLibCrate = new PrimitivesCrateMetaLibContext();
  // 当前项目crate
  CrateLibContext crateLib = new CrateLibContext();
  // 当前项目实际依赖的所有lib
  List<CrateLibContext> dependencyCrateLibsPool = new ArrayList<>();
}
