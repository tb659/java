package demo24InputOutputStreamReaderWriter;

import java.io.*;

public class Demo01OutStreamWriter {
  public static void main(String[] args) throws IOException {
    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("f.txt"), "GBK");
    osw.write("编码写入");
    osw.close();

    InputStreamReader isr = new InputStreamReader(new FileInputStream("f.txt"), "GBK");
    int len;
    while ((len = isr.read()) != -1) {
      System.out.print((char) len);
    }

    FileInputStream fis= new FileInputStream("f.txt");
    int len1;
    while ((len1 = fis.read()) != -1) {
      System.out.print((char) len1);
    }
  }
}
