package titan.lang.compiler.config;

import java.io.InputStream;
import titan.json.Json;

/**
 * .
 *
 * @author tian wei jun
 */
public class RootCompilerConfigBuilder {

  public RootCompilerConfig build() {
    InputStream rootCompilerConfigJsonInputStream =
        this.getClass().getClassLoader().getResourceAsStream("config/rootCompilerConfig.json");
    RootCompilerConfig rootCompilerConfig =
        Json.fromJson(rootCompilerConfigJsonInputStream, RootCompilerConfig.class);
    return rootCompilerConfig;
  }
}
