package titan.lang.compiler.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import titan.json.Json;
import titan.lang.compiler.exception.CompilerRuntimeException;

/**
 * .
 *
 * @author tian wei jun
 */
public class Win32CompilerEnvConfigBuilder {

  public Win32CompilerEnvConfig build(String compilerEnvConfigFilePath) {
    return buildByFilePath(compilerEnvConfigFilePath);
  }

  private Win32CompilerEnvConfig build() {
    InputStream win32CompilerEnvConfigStream =
        this.getClass()
            .getClassLoader()
            .getResourceAsStream("config/defaultWin32CompilerEnvConfig.json");
    return Json.fromJson(win32CompilerEnvConfigStream, Win32CompilerEnvConfig.class);
  }

  private Win32CompilerEnvConfig buildByFilePath(String compilerEnvConfigFilePath) {
    Win32CompilerEnvConfig compilerEnvConfig = build();
    File cfgFile = new File(compilerEnvConfigFilePath);
    if (cfgFile.exists() && cfgFile.isFile()) {
      try (FileInputStream compilerEnvConfigJsonInputStream = new FileInputStream(cfgFile)) {
        Win32CompilerEnvConfig compilerEnvConfigInFile =
            Json.fromJson(compilerEnvConfigJsonInputStream, Win32CompilerEnvConfig.class);
        compilerEnvConfig.beOverrode(compilerEnvConfigInFile);
      } catch (IOException e) {
        throw new CompilerRuntimeException(e);
      }
    }
    return compilerEnvConfig;
  }
}
