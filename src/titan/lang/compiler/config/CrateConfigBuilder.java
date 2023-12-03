package titan.lang.compiler.config;

import java.io.FileInputStream;
import java.io.IOException;
import titan.json.Json;
import titan.lang.compiler.exception.CompilerRuntimeException;

/**
 * .
 *
 * @author tian wei jun
 */
public class CrateConfigBuilder {

  public CrateConfig build(String crateConfigFilePath) {
    CrateConfig crateConfig = null;
    try (FileInputStream inputStream = new FileInputStream(crateConfigFilePath)) {
      crateConfig = Json.fromJson(inputStream, CrateConfig.class);
    } catch (IOException e) {
      throw new CompilerRuntimeException(e);
    }
    return crateConfig;
  }
}
