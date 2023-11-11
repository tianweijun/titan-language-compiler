package titan.lang.compiler.config;

/**
 * LangUserCompilerConfig.
 *
 * @author tian wei jun
 */
public class LangUserCompilerConfig {

  public String crateName = null;
  public String crateEntry = null;

  public String[] sourceCodeFileDirectories = null;
  public String[] sourceCodeFilePaths = null;

  public LibConfig[] libs = null;
  public PlatformDependentLibConfig[] platformDependentLibs = null;

  public String crateType = null;
  public String outputFilePath = null;

  public String[] assembleInstructionSets = null;
  public String os = null;
  public int defaultOperandSize = 0;
  public int defaultAddressSize = 0;
}
