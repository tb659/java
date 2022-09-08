package demo20File;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Demo04FileFilter {
  public static void main(String[] args) {
    File f = new File("D:\\0WorkSpace\\project\\java\\src");

    getAllFile(f);
  }

  private static void getAllFile(File f) {
//    File[] files = f.listFiles(new FIleFilterImpl());
//    for (File file : files) {
//      if (file.isDirectory()) {
//        getAllFile(file);
//      } else {
//        System.out.println(file);
//      }
//    }

    // 匿名内部类
//    File[] files = f.listFiles(new FileFilter() {
//      @Override
//      public boolean accept(File file) {
//        return file.getName().toLowerCase().endsWith(".java") || file.isDirectory();
//      }
//    });
//    for (File file : files) {
//      if (file.isDirectory()) {
//        getAllFile(file);
//      } else {
//        System.out.println(file);
//      }
//    }

    // 匿名内部类
    File[] files = f.listFiles(new FilenameFilter() {
      @Override
      public boolean accept(File file, String s) {
        return new File(file, s).isDirectory() || s.toLowerCase().endsWith(".java");
      }
    });
    for (File file : files) {
      if (file.isDirectory()) {
        getAllFile(file);
      } else {
        System.out.println(file);
      }
    }

//    File[] files = f.listFiles((file) -> file.getName().toLowerCase().endsWith(".java") || file.isDirectory());
//    for (File file : files) {
//      if (file.isDirectory()) {
//        getAllFile(file);
//      } else {
//        System.out.println(file);
//      }
//    }


//    for (File file : f.listFiles((file) -> file.getName().toLowerCase().endsWith(".java") || file.isDirectory())) {
//      if (file.isDirectory()) {
//        getAllFile(file);
//      } else {
//        System.out.println(file);
//      }
//    }
  }
}
