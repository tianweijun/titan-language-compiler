package titan.lang.compiler.test;

import titan.lang.compiler.CommandLineCompilerApplication;
import titan.lang.compiler.logger.Logger;

public class LanguageCompilerTest {
  public static void main(String[] args) {
    args =
        new String[] {
          "-configurationFilePath",
          "D:\\github-pro\\titan\\titan-language-compiler\\test\\helloworld\\config.json"
        };

    CommandLineCompilerApplication compiler = new CommandLineCompilerApplication();
    compiler.run(args);

    Logger.info("LanguageCompilerTest main", "LanguageCompilerTest end");
  }
}
