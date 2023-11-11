package titan.lang.compiler.link;

import java.util.LinkedList;
import java.util.List;

/**
 * .
 *
 * @author tian wei jun
 */
public class Module {
  public String id = "";

  public ModuleScope scope = new ModuleScope();
  // 当前模块所声明导入的模块
  // from CrateLibContext.dependencyCrateLibs
  public List<Module> importModules = new LinkedList<Module>();
}
