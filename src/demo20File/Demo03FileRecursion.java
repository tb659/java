package demo20File;

import java.io.File;
import java.sql.SQLOutput;

public class Demo03FileRecursion {
  public static void main(String[] args) {
    File dir = new File("D:\\0WorkSpace\\project\\java\\src");

    printFileName(dir);

  }

  private static void printFileName(File dir) {
    File[] list = dir.listFiles();
    for (File fileItem : list) {
      if (fileItem.isDirectory()) {
//      System.out.println(fileItem.getName());
       printFileName(fileItem);
      } else {
//        System.out.print(fileItem.getParentFile().getName());
//        System.out.print("==>");
        if (fileItem.getName().toLowerCase().endsWith(".java")) {
          System.out.println(fileItem);
        }

      }
    }
  }
}
