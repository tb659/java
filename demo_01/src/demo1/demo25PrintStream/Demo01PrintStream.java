package demo1.demo25PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Demo01PrintStream {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("控制台输出");
    PrintStream ps = new PrintStream("print.txt");
    ps.write(97);
    ps.print(97);
    ps.println("===");
    ps.println(97);
    ps.close();
    System.setOut(ps);
    System.out.println("在打印流print.txt输出");
  }
}
