package demo21Stream;

import java.io.FileReader;
import java.io.IOException;

public class Demo06IOException {
  public static void main(String[] args) {
    try (FileReader fr = new FileReader("a.txt")) {
      int len;
      while ((len = fr.read()) != -1) {
        System.out.print((char) len);
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
