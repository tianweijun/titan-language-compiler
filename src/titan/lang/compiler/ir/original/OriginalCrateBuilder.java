package titan.lang.compiler.ir.original;

import java.util.Set;
import titan.lang.compiler.context.CompilerContext;
import titan.lang.compiler.ir.context.OriginalCrateContext;

/**
 * .
 *
 * @author tian wei jun
 */
public class OriginalCrateBuilder {

  /** 完成对OriginalCrateRuntimeContext的构建. */
  public void build() {
    OriginalCrateContext originalCrateContext = new OriginalCrateContext();
    Set<String> moduleFilePaths = new ModuleFilePathsFinder().getModuleFilePaths();
    // buildModules
    OriginalModuleBuilder originalModuleBuilder = new OriginalModuleBuilder();
    originalCrateContext.modules.addAll(originalModuleBuilder.build(moduleFilePaths));
    // set result
    CompilerContext.get().originalCrateContext = originalCrateContext;
  }
}
