package titan.lang.compiler.config;

/**
 * LangEnvCompilerConfig.
 *
 * @author tian wei jun
 */
public class LangEnvCompilerConfig {

  public String isa = "intel";
  public String os = "win10";

  public int defaultOperandSize = 4;
  public int defaultAddressSize = 4;

  public String[] assembleInstructionSets = {
    "x86", "x86-64", "MMX", "SSE", "SSE2", "SSE3", "SSE4.1", "SSE4.2", "EM64T", "VT-x", "AES",
    "AVX", "AVX2", "FMA3"
  };

  public void set(LangCrateCompilerConfig crateCompilerConfig) {}
}
