package titan.lang.compiler.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import titan.json.Json;
import titan.lang.compiler.config.LangUserCompilerConfig;
import titan.lang.compiler.exception.CompilerRuntimeException;

/**
 * .
 *
 * @author tian wei jun
 */
public class CommandLineParameters {
  private static final String keyOfConfigurationFilePath = "-configurationFilePath";
  public String configurationFilePath = null;

  public CommandLineParameters(String[] args) {
    if (null == args || args.length < 1) {
      return;
    }
    for (int indexOfArg = 0; indexOfArg < args.length; ) {
      String key = args[indexOfArg];
      if (keyOfConfigurationFilePath.equals(key)) {
        ++indexOfArg;
        if (indexOfArg < args.length) {
          configurationFilePath = args[indexOfArg];
          ++indexOfArg;
        }
      } else {
        ++indexOfArg;
      }
    }
  }

  public LangUserCompilerConfig toLanguageUserConfig() {
    LangUserCompilerConfig userCompilerConfig = null;
    try (InputStream jsonInputStream = new FileInputStream(configurationFilePath)) {
      userCompilerConfig = Json.fromJson(jsonInputStream, LangUserCompilerConfig.class);
    } catch (IOException e) {
      throw new CompilerRuntimeException(e);
    }
    return userCompilerConfig;
  }
}
