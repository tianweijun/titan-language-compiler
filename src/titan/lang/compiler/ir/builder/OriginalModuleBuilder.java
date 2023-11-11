package titan.lang.compiler.ir.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import titan.lang.compiler.ir.context.OriginalModule;
import titan.lang.compiler.ir.context.Scope;

/**
 * .
 *
 * @author tian wei jun
 */
public class OriginalModuleBuilder {

  public List<OriginalModule> build(Set<String> moduleFilePaths) {
    List<OriginalModule> modules = new ArrayList<>(moduleFilePaths.size());
    for (String moduleFilePath : moduleFilePaths) {
      modules.add(build(moduleFilePath));
    }
    return modules;
  }

  /**
   * 1.生成ast 2.遍历ast，生成属性 .
   *
   * @param moduleFilePath 模块文件路径
   * @return 模块
   */
  public OriginalModule build(String moduleFilePath) {
    Scope scope = new ScopeBuilder().build(moduleFilePath);
    OriginalModule module = new OriginalModule();
    return module;
  }
}
