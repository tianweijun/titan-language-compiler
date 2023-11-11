package titan.lang.compiler.config;

/**
 * Language 配置文件，从LanguageConfig.json中获取.
 *
 * @author tian wei jun
 */
public class LangCompilerConfig {

  public LangEnvCompilerConfig envCompilerConfig = null;
  public LangCrateCompilerConfig crateCompilerConfig = null;

  public void setEnvConfig(LangEnvCompilerConfig envCompilerConfig) {
    this.envCompilerConfig = envCompilerConfig;
  }

  public void setUserCofig(LangUserCompilerConfig userCompilerConfig) {
    crateCompilerConfig = new LangCrateCompilerConfig();
    crateCompilerConfig.set(userCompilerConfig);
    envCompilerConfig.set(crateCompilerConfig);
  }
}
