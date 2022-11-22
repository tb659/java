package demo1.demo20File;

import java.io.File;

public class demo01File {
  public static void main(String[] args) {
    String pathSeparator = File.pathSeparator;
    System.out.println(pathSeparator); // 路径分隔符 windows ;  linux :

    String separator = File.separator;
    System.out.println(separator); // 文件名称分隔符 windows \  linux /
    // "c:\dev\a.txt" =>  "c:" + File.separator + "dev" + File.separator + "a.txt"
    System.out.println("c" + File.separator + "dev" + File.separator + "a.txt");

    System.out.println("=====================");

    File f1 = new File("D:0WorkSpace\\project\\java\\a.txt");

    File f2 = new File("D:0WorkSpace\\project\\java");

    File f3 = new File("a.txt");

    File f4 = new File("D:0WorkSpace\\project\\", "java");

    File f5 = new File(new File("D:0WorkSpace\\project"), "java");
  }
}
