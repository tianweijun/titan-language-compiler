package titan.lang.compiler.config;

/**
 * .
 *
 * @author tian wei jun
 */
public class LangCrateCompilerConfig {
  public String crateName = null;
  public String crateEntry = null;

  public String[] sourceCodeFileDirectories = null;
  public String[] sourceCodeFilePaths = null;

  public LibConfig[] libs = null;
  public PlatformDependentLibConfig[] platformDependentLibs = null;

  public String crateType = null;
  public String outputFilePath = null;

  public void set(LangUserCompilerConfig userCompilerConfig) {
    this.crateName = userCompilerConfig.crateName;
    this.crateEntry = userCompilerConfig.crateEntry;

    this.sourceCodeFileDirectories = userCompilerConfig.sourceCodeFileDirectories;
    this.sourceCodeFilePaths = userCompilerConfig.sourceCodeFilePaths;

    this.libs = userCompilerConfig.libs;
    this.platformDependentLibs = userCompilerConfig.platformDependentLibs;

    this.crateType = userCompilerConfig.crateType;
    this.outputFilePath = userCompilerConfig.outputFilePath;
  }
}
