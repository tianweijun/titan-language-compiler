package titan.lang.compiler.test.astcontext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import titan.ast.runtime.Grammar;
import titan.ast.runtime.GrammarType;
import titan.ast.runtime.RuntimeAutomataAstApplication;
import titan.lang.compiler.exception.CompilerRuntimeException;
import titan.lang.compiler.util.FileUtil;

/**
 * .
 *
 * @author tian wei jun
 */
public class AstContextBuilderTest {

  public static void main(String[] args) {
    String astContextFileDirectory =
        "D:\\github-pro\\titan\\titan-language-compiler\\src\\titan\\lang\\compiler\\ir\\original\\ast\\context\\";
    AstContextBuilderTest test = new AstContextBuilderTest();
    RuntimeAutomataAstApplication astApplication = test.getAstApplication();
    Grammar[] grammars = astApplication.getGrammars();
    for (Grammar grammar : grammars) {
      if (grammar.getType() == GrammarType.NONTERMINAL) {
        test.createAstContextFile(astContextFileDirectory, grammar.getName());
      }
    }
  }

  private void createAstContextFile(String astContextFileDirectory, String nonterminnalName) {
    String className = nonterminnalName + "Context";
    className = className.substring(0, 1).toUpperCase() + className.substring(1);
    String filePath = astContextFileDirectory + className + ".java";
    File file = new File(filePath);
    if (file.exists()) {
      return;
    }
    file = FileUtil.makeFile(filePath);
    String content =
        "package titan.lang.compiler.ir.original.ast.context;\n"
            + "\n"
            + "/**\n"
            + " * .\n"
            + " *\n"
            + " * @author tian wei jun\n"
            + " */\n"
            + "public class ${className} extends Context {\n"
            + "\n"
            + "  public ${className}() {}\n"
            + "}\n";
    content = content.replace("${className}", className);
    try (FileWriter fileWriter = new FileWriter(file)) {
      fileWriter.write(content);
    } catch (IOException e) {
      throw new CompilerRuntimeException(e);
    }
  }

  RuntimeAutomataAstApplication getAstApplication() {
    RuntimeAutomataAstApplication astApplication = new RuntimeAutomataAstApplication();
    try (InputStream automataInputStream =
        this.getClass().getClassLoader().getResourceAsStream("grammar/titanLangGrammar.automata")) {
      astApplication.setContext(automataInputStream);
    } catch (IOException e) {
      throw new CompilerRuntimeException(e);
    }
    return astApplication;
  }
}
