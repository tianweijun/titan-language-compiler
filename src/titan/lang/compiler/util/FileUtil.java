package titan.lang.compiler.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import titan.lang.compiler.exception.CompilerRuntimeException;

/**
 * .
 *
 * @author tian wei jun
 */
public class FileUtil {
  private FileUtil() {}

  public static List<File> getAllFiles(String fileDirectory) {
    List<File> fileList = new ArrayList<>();
    // 检查指定路径是否为目录
    File directory = new File(fileDirectory);
    if (!directory.isDirectory()) {
      return fileList;
    }

    // 获取目录下的所有文件和子目录
    File[] files = directory.listFiles();

    if (files == null || files.length <= 0) {
      return fileList;
    }
    // 遍历所有文件和子目录
    for (File file : files) {
      // 如果是文件则添加到文件列表中
      if (file.isFile()) {
        fileList.add(file);
      }
      // 如果是目录则递归调用该方法
      if (file.isDirectory()) {
        fileList.addAll(getAllFiles(file.getAbsolutePath()));
      }
    }

    return fileList;
  }

  public static File makeFile(String filePath) {
    File file = new File(filePath);
    if (file.exists()) {
      return file;
    }
    File fileParent = file.getParentFile();
    if (!fileParent.exists()) {
      boolean mkdirs = fileParent.mkdirs();
      if (!mkdirs) {
        throw new CompilerRuntimeException("mkdirs failed at makeFile method in FileUtil");
      }
    }

    try {
      boolean hasCreated = file.createNewFile();
      if (!hasCreated) {
        throw new CompilerRuntimeException("mkdirs failed at makeFile method in FileUtil");
      }
    } catch (IOException e) {
      throw new CompilerRuntimeException(e);
    }
    return file;
  }
}
