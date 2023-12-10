package titan.lang.compiler.context;

import java.io.IOException;
import java.io.InputStream;
import titan.ast.runtime.RuntimeAutomataAstApplication;
import titan.lang.compiler.config.CompilerEnvConfig;
import titan.lang.compiler.config.CompilerEnvConfigBuilder;
import titan.lang.compiler.config.CrateConfig;
import titan.lang.compiler.config.RootCompilerConfig;
import titan.lang.compiler.config.RootCompilerConfigBuilder;
import titan.lang.compiler.exception.CompilerRuntimeException;
import titan.lang.compiler.ir.context.OriginalCrateContext;

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
  public OriginalCrateContext originalCrateContext = null;

  RuntimeAutomataAstApplication astApplication = null;

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

  public RuntimeAutomataAstApplication getAstApplication() {
    if (null == astApplication) {
      astApplication = new RuntimeAutomataAstApplication();
      try (InputStream automataInputStream =
          this.getClass()
              .getClassLoader()
              .getResourceAsStream("grammar/titanLangGrammar.automata")) {
        astApplication.setContext(automataInputStream);
      } catch (IOException e) {
        throw new CompilerRuntimeException(e);
      }
    }
    return astApplication;
  }
}
