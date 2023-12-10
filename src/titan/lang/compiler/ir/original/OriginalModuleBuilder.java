package titan.lang.compiler.ir.original;

import java.util.HashSet;
import java.util.Set;

/**
 * .
 *
 * @author tian wei jun
 */
public class OriginalModuleBuilder {

  public Set<OriginalModule> build(Set<String> moduleFilePaths) {
    Set<OriginalModule> modules = new HashSet<>(moduleFilePaths.size());
    SingleOriginalModuleBuilder singleOriginalModuleBuilder = new SingleOriginalModuleBuilder();
    for (String moduleFilePath : moduleFilePaths) {
      modules.add(singleOriginalModuleBuilder.build(moduleFilePath));
    }
    return modules;
  }
}
