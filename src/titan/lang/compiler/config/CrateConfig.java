package titan.lang.compiler.config;

/**
 * .
 *
 * @author tian wei jun
 */
public class CrateConfig {

  public String crateName = null;
  public String crateEntry = null;

  public String[] sourceCodeFileDirectories = null;
  public String[] sourceCodeFilePaths = null;

  public LibConfig[] libs = null;
  public PlatformDependentLibConfig[] platformDependentLibs = null;

  public String crateType = null;
  public String outputFilePath = null;


}
