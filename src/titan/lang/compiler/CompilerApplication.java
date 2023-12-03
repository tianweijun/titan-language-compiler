package titan.lang.compiler;

import titan.json.Json;
import titan.lang.compiler.config.CrateConfig;
import titan.lang.compiler.context.CompilerContext;
import titan.lang.compiler.ir.builder.OriginalCrateIrBuilder;
import titan.lang.compiler.link.Linker;
import titan.lang.compiler.target.TargetBuilder;

/**
 * .
 *
 * @author tian wei jun
 */
public class CompilerApplication {

  /**
   * 1.构建ir 2.构建link 3.构建 最终生成文件 .
   *
   * @param crateConfig
   */
  public void run(CrateConfig crateConfig) {
    CompilerContext context = CompilerContext.init(crateConfig);
    Json.destruct(); // json仅用在配置文件序列化上,配置完之后直接释放Json所占用的资源
    // 1.构建ir
    OriginalCrateIrBuilder crateIrBuilder = new OriginalCrateIrBuilder();
    crateIrBuilder.build();
    // 2.构建link
    Linker linker = new Linker();
    linker.link();
    // 3.构建 最终生成文件
    TargetBuilder targetBuilder = new TargetBuilder();
    targetBuilder.build();

    CompilerContext.clear();
  }
}
