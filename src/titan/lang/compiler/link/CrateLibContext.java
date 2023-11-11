package titan.lang.compiler.link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * .
 *
 * @author tian wei jun
 */
public class CrateLibContext {
  public String id = "";
  // 所有模块
  public List<Module> modules = new LinkedList<Module>();
  // crate所依赖的非本身crate lib
  // from CrateRuntimeContext.dependencyCrateLibsPool
  // lib中模块的全限定名称不能重复
  List<CrateLibContext> dependencyCrateLibs = new ArrayList<>();
}
