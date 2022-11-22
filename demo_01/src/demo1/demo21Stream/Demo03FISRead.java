package demo1.demo21Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Demo03FISRead {
  public static void main(String[] args) throws IOException {
    FileInputStream fis = new FileInputStream("a.txt");
    System.out.println(fis.read());

    System.out.println("====================");

    int len;
    FileInputStream fis1 = new FileInputStream("b.txt");
//    System.out.println(fis1.read(b));
    while ((len = fis.read()) != -1) {
      System.out.println((char) len);
    }
    fis.close();

    System.out.println("====================");

    int l;
    byte[] b = new byte[2];
    while ((l = fis1.read(b)) != -1) {
      System.out.println(new String(b));
    }
    System.out.println(Arrays.toString(b));
    fis1.close();

    System.out.println("====================");

    int len1;
    byte[] b1 = new byte[1024];
    FileInputStream fis2 = new FileInputStream("a.txt");
    while ((len1 = fis2.read(b1)) != -1) {
      System.out.println(new String(b1, 0, len1));
    }
    fis2.close();

    System.out.println("====================");

    long s = System.currentTimeMillis();
//    FileInputStream imgRead = new FileInputStream("a.txt");
//    FileOutputStream imgWrite = new FileOutputStream("d.txt");
    FileInputStream imgRead = new FileInputStream("test1.png");
    FileOutputStream imgWrite = new FileOutputStream("test.png");

    int len3;
    byte[] byte1 = new byte[1024];

    while ((len3 = imgRead.read(byte1)) != -1) {
      imgWrite.write(byte1, 0, len3);
    }
    imgWrite.close();
    imgRead.close();
    long e = System.currentTimeMillis();
    System.out.println("复制图片耗时" + (e - s) + "毫秒");
  }
}
