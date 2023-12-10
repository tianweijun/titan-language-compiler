package titan.lang.compiler.ir.original;

import titan.lang.compiler.ir.original.ast.AstBuilder;

/**
 * .
 *
 * @author tian wei jun
 */
public class SingleOriginalModuleBuilder {
  AstBuilder astBuilder = new AstBuilder();
  /**
   * 1.生成ast 2.遍历ast，生成属性 .
   *
   * @param moduleFilePath 模块文件路径
   * @return OriginalModule
   */
  public OriginalModule build(String moduleFilePath) {
    OriginalModule originalModule = new OriginalModule();
    // 1.生成ast
    originalModule.tree = astBuilder.build(moduleFilePath);
    return originalModule;
  }
}
