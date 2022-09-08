package demo21Stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01FileOutputStream {
  public static void main(String[] args) throws IOException {
//    File file = new File("a.txt");
//    FileOutputStream fos = new FileOutputStream(file);

    FileOutputStream fos = new FileOutputStream(new File("a.txt"));

    FileOutputStream fos2 = new FileOutputStream("b.txt");
  }
}
