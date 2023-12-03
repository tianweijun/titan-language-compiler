package titan.lang.compiler.context;

import titan.lang.compiler.config.CompilerEnvConfig;
import titan.lang.compiler.config.CompilerEnvConfigBuilder;
import titan.lang.compiler.config.CrateConfig;
import titan.lang.compiler.config.RootCompilerConfig;
import titan.lang.compiler.config.RootCompilerConfigBuilder;
import titan.lang.compiler.ir.context.OriginalCrateRuntimeContext;

/**
 * context.
 *
 * @author tian wei jun
 */
public class CompilerContext {

  private static ThreadLocal<CompilerContext> contextThreadLocal = new ThreadLocal<>();

  public RootCompilerConfig rootCompilerConfig = null;
  public CompilerEnvConfig compilerEnvConfig = null;
  public CrateConfig crateConfig = null;
  public OriginalCrateRuntimeContext originalCrateRuntimeContext = null;

  /**
   * 初始化并生成一个当前应用程序的 上下文.
   *
   * @param crateConfig crateConfig
   * @return 当前应用程序的 上下文
   */
  public static CompilerContext init(CrateConfig crateConfig) {
    CompilerContext compilerContext = new CompilerContext();
    compilerContext.rootCompilerConfig = new RootCompilerConfigBuilder().build();
    compilerContext.compilerEnvConfig =
        new CompilerEnvConfigBuilder().build(compilerContext.rootCompilerConfig);
    compilerContext.crateConfig = crateConfig;
    set(compilerContext);
    return compilerContext;
  }

  public static void set(CompilerContext ctx) {
    contextThreadLocal.set(ctx);
  }

  public static void clear() {
    contextThreadLocal.remove();
  }

  public static CompilerContext get() {
    return contextThreadLocal.get();
  }
}
