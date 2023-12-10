package titan.lang.compiler.ir.original;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import titan.lang.compiler.config.CrateConfig;
import titan.lang.compiler.context.CompilerContext;
import titan.lang.compiler.util.FileUtil;

/**
 * .
 *
 * @author tian wei jun
 */
public class ModuleFilePathsFinder {
  private static final String SOURCE_FILE_NAME_SUFFIX = ".titan";

  public Set<String> getModuleFilePaths() {
    Set<String> moduleFilePaths = new HashSet<>();
    // config
    CompilerContext compilerContext = CompilerContext.get();
    CrateConfig crateConfig = compilerContext.crateConfig;
    // sourceCodeFilePaths
    String[] sourceCodeFilePaths = crateConfig.sourceCodeFilePaths;

    if (null != sourceCodeFilePaths && sourceCodeFilePaths.length > 0) {
      for (String sourceCodeFilePath : sourceCodeFilePaths) {
        if (sourceCodeFilePath.endsWith(SOURCE_FILE_NAME_SUFFIX)) {
          moduleFilePaths.add(sourceCodeFilePath);
        }
      }
    }
    // sourceCodeFileDirectories
    String[] sourceCodeFileDirectories = crateConfig.sourceCodeFileDirectories;
    if (null != sourceCodeFileDirectories && sourceCodeFileDirectories.length > 0) {
      for (String fileDirectory : sourceCodeFileDirectories) {
        List<File> sourceCodeFiles = FileUtil.getAllFiles(fileDirectory);
        for (File sourceCodeFile : sourceCodeFiles) {
          String sourceCodeFilePath = sourceCodeFile.getPath();
          if (sourceCodeFilePath.endsWith(SOURCE_FILE_NAME_SUFFIX)) {
            moduleFilePaths.add(sourceCodeFilePath);
          }
        }
      }
    }
    return moduleFilePaths;
  }
}
