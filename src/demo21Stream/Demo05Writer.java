package demo21Stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo05Writer {
  public static void main(String[] args) throws IOException {
    FileReader fr = new FileReader("a.txt");
    FileWriter fw = new FileWriter("e.txt");
    int len;
    char[] chars = new char[1024];
    while ((len = fr.read(chars)) != -1) {
      fw.write(chars, 0, len);
    }
//    fw.close();
//    fr.close();
//    FileWriter fw1 = new FileWriter("e.txt", true);
//    fw1.write(97);
//    fw1.close();

    fw.flush();
    fw.write("\r\n");
    fw.write(99);
    fw.close();
    fr.close();
  }
}
