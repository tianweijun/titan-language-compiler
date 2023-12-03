package titan.lang.compiler.input;

import titan.lang.compiler.config.CrateConfig;
import titan.lang.compiler.config.CrateConfigBuilder;

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

  public CrateConfig toCrateConfig() {
    return new CrateConfigBuilder().build(configurationFilePath);
  }
}
