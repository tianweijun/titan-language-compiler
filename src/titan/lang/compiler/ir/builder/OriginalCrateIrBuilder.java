package titan.lang.compiler.ir.builder;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import titan.lang.compiler.config.CrateConfig;
import titan.lang.compiler.context.CompilerContext;
import titan.lang.compiler.ir.context.OriginalCrateRuntimeContext;
import titan.lang.compiler.util.FileUtil;

/**
 * .
 *
 * @author tian wei jun
 */
public class OriginalCrateIrBuilder {

  /** 完成对OriginalCrateRuntimeContext的构建. */
  public void build() {
    OriginalCrateRuntimeContext originalCrateRuntimeContext = new OriginalCrateRuntimeContext();
    Set<String> moduleFilePaths = getModuleFilePaths();
    // buildModules
    OriginalModuleBuilder originalModuleBuilder = new OriginalModuleBuilder();
    originalCrateRuntimeContext.crate.modules.addAll(originalModuleBuilder.build(moduleFilePaths));
    // set result
    CompilerContext.get().originalCrateRuntimeContext = originalCrateRuntimeContext;
  }

  private Set<String> getModuleFilePaths() {
    Set<String> moduleFilePaths = new HashSet<>();
    // config
    CompilerContext compilerContext = CompilerContext.get();
    CrateConfig crateConfig =
        compilerContext.crateConfig;
    // sourceCodeFilePaths
    String[] sourceCodeFilePaths = crateConfig.sourceCodeFilePaths;
    String SOURCE_FILE_NAME_SUFFIX = ".titan";
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
