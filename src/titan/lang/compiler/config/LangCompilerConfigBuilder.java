package titan.lang.compiler.config;

import java.io.IOException;
import java.io.InputStream;
import titan.ast.runtime.AstRuntimeException;
import titan.json.Json;

/**
 * TitanLanguageConfigBuilder.
 *
 * @author tian wei jun
 */
public class LangCompilerConfigBuilder {

  /**
   * 构建TitanLanguageConfig.
   *
   * @return TitanLanguageConfig
   */
  public LangCompilerConfig build() {
    LangCompilerConfig titanLangCompilerConfig = new LangCompilerConfig();
    InputStream jsonInputStream =
        this.getClass().getClassLoader().getResourceAsStream("titanLanguageEnvConfig.json");
    titanLangCompilerConfig.setEnvConfig(
        Json.fromJson(jsonInputStream, LangEnvCompilerConfig.class));
    if (null != jsonInputStream) {
      try {
        jsonInputStream.close();
      } catch (IOException e) {
        throw new AstRuntimeException(e);
      }
    }
    return titanLangCompilerConfig;
  }
}
