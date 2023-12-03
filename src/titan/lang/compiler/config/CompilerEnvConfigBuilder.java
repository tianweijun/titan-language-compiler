package titan.lang.compiler.config;

import titan.lang.compiler.exception.CompilerRuntimeException;

/**
 * TitanLanguageConfigBuilder.
 *
 * @author tian wei jun
 */
public class CompilerEnvConfigBuilder {

  public CompilerEnvConfig build(RootCompilerConfig rootCompilerConfig) {
    if (CompilerEnv.WIN32.equalsIgnoreCase(rootCompilerConfig.compilerEnvType)) {
      return new Win32CompilerEnvConfigBuilder()
          .build(rootCompilerConfig.compilerEnvConfigFilePath);
    }
    throw new CompilerRuntimeException(String
        .format("no this compilerEnvType type:'%s'", rootCompilerConfig.compilerEnvType));
  }
}

