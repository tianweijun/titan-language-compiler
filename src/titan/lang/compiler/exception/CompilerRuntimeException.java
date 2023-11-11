package titan.lang.compiler.exception;

/**
 * 自定义运行时异常.
 *
 * @author tian wei jun
 */
public class CompilerRuntimeException extends RuntimeException {

  public CompilerRuntimeException(Throwable cause) {
    super(cause);
  }

  public CompilerRuntimeException(String message) {
    super(message);
  }
}
