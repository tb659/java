package demo1.demo21Stream;

import java.io.FileReader;
import java.io.IOException;

public class Demo04Reader {
  public static void main(String[] args) throws IOException {
//    FileReader fr = new FileReader("a.txt");
//    int len;
//    while ((len = fr.read()) != -1) {
//      System.out.print((char) len);
//    }
//    fr.close();

    FileReader fr = new FileReader("a.txt");
    int len;
    char[] chars = new char[1024];
    while ((len = fr.read(chars)) != -1) {
      System.out.print(new String(chars, 0 , len));
    }
    fr.close();
  }
}
