package titan.lang.compiler;

import titan.lang.compiler.input.CommandLineParameters;

/**
 * CommandLineCompilerApplication.
 *
 * @author tian wei jun
 */
public class CommandLineCompilerApplication {

  public void run(String[] args) {
    CommandLineParameters commandLineParameters = new CommandLineParameters(args);
    CompilerApplication compilerApplication = new CompilerApplication();
    compilerApplication.run(commandLineParameters.toLanguageUserConfig());
  }

  public static void main(String[] args) {
    new CommandLineCompilerApplication().run(args);
  }
}
