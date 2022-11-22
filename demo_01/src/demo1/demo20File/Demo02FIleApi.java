package demo1.demo20File;

import java.io.File;
import java.io.IOException;

public class Demo02FIleApi {
  public static void main(String[] args) {
    File file = new File("D:\\0WorkSpace\\project\\java\\a.txt");
    System.out.println(file.getAbsolutePath());
    System.out.println(file.getPath());
    System.out.println(file.getName());
    System.out.println(file.length());
    System.out.println(new File("D:\\0WorkSpace\\project\\java\\src\\demo1.demo20File\\demo02FileGet.java").length());

    System.out.println("==================");

    file = new File("b.txt");
    System.out.println(file.getAbsolutePath());
    System.out.println(file.getPath());
    System.out.println(file.getName());
    System.out.println(file.length());

    System.out.println("==================");

    System.out.println(new File("D:\\java").exists());
    System.out.println(new File("D:\\java\\a.txt").exists());
    System.out.println(new File("D:\\java\\b.txt").exists());
    System.out.println(new File("D:\\java").isDirectory());
    System.out.println(new File("D:\\java\\a.txt").isDirectory());
    System.out.println(new File("D:\\java").isFile());
    System.out.println(new File("D:\\java\\a.txt").isFile());

    System.out.println("==================");

    File file1 = new File("D:\\0WorkSpace\\project\\java\\src\\demo1.demo20File\\1.txt");
    File file2 = new File("src\\demo1.demo20File\\2.txt");
    try {
      System.out.println(file1.createNewFile());
      System.out.println(file2.createNewFile());
    } catch (IOException e) {
      e.printStackTrace();
    }
    File f1 = new File("D:\\0WorkSpace\\project\\java\\src\\demo1.demo20File\\1");
    File f2 = new File("D:\\0WorkSpace\\project\\java\\src\\demo1.demo20File\\3\\3");
    File f3 = new File("D:\\0WorkSpace\\project\\java\\src\\demo1.demo20File\\2");
    File f4 = new File("D:\\0WorkSpace\\project\\java\\src\\demo1.demo20File\\2\\2\\2.txt");
    System.out.println(f1.mkdir());
    System.out.println(f2.mkdir());
    System.out.println(f3.mkdirs());
    System.out.println(f4.mkdirs());

    System.out.println("==================");

//    try {
//      Thread.sleep(2000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    System.out.println(f4.delete());

    System.out.println("======================");

    File f5 = new File("D:\\0WorkSpace\\project\\java\\src");
    String[] fileList1 = f5.list();
    for (String s : fileList1) {
      System.out.println(s);
    }

    System.out.println("======================");

    File[] files = f5.listFiles();
    for (File f : files) {
      System.out.println(f);
    }
  }
}
