package titan.lang.compiler.config;

import titan.ast.runtime.StringUtils;

/**
 * .
 *
 * @author tian wei jun
 */
public class Win32CompilerEnvConfig implements CompilerEnvConfig {
  public String isa;
  public String os;

  public int defaultOperandSize = -1;
  public int defaultAddressSize = -1;

  public String[] assembleInstructionSets;

  public void beOverrode(Win32CompilerEnvConfig config) {
    if (StringUtils.isNotBlank(config.isa)) {
      this.isa = config.isa;
    }
    if (StringUtils.isNotBlank(config.os)) {
      this.os = config.os;
    }
    if (config.defaultOperandSize == -1) {
      this.defaultOperandSize = config.defaultOperandSize;
    }
    if (config.defaultAddressSize == -1) {
      this.defaultAddressSize = config.defaultAddressSize;
    }
    if (config.assembleInstructionSets != null && config.assembleInstructionSets.length > 0) {
      this.assembleInstructionSets = config.assembleInstructionSets;
    }
  }
}
