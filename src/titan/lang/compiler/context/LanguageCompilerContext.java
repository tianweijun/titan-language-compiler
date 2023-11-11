package titan.lang.compiler.context;

import titan.lang.compiler.config.LangCompilerConfig;
import titan.lang.compiler.config.LangCompilerConfigBuilder;
import titan.lang.compiler.config.LangUserCompilerConfig;
import titan.lang.compiler.ir.context.OriginalCrateRuntimeContext;

/**
 * context.
 *
 * @author tian wei jun
 */
public class LanguageCompilerContext {

  private static ThreadLocal<LanguageCompilerContext> languageCompilerContext = new ThreadLocal<>();

  public LangCompilerConfig languageCompilerConfig = null;
  public OriginalCrateRuntimeContext originalCrateRuntimeContext = null;

  /**
   * 初始化并生成一个当前应用程序的 上下文.
   *
   * @return 当前应用程序的 上下文
   * @param languageUserConfig
   */
  public static LanguageCompilerContext build(LangUserCompilerConfig languageUserConfig) {
    clear();
    LanguageCompilerContext languageCompilerContext = new LanguageCompilerContext();
    languageCompilerContext.languageCompilerConfig = new LangCompilerConfigBuilder().build();
    languageCompilerContext.languageCompilerConfig.setUserCofig(languageUserConfig);
    set(languageCompilerContext);
    return languageCompilerContext;
  }

  public static void set(LanguageCompilerContext ctx) {
    languageCompilerContext.set(ctx);
  }

  public static void clear() {
    languageCompilerContext.remove();
  }

  public static LanguageCompilerContext get() {
    return languageCompilerContext.get();
  }
}
