package demo1.demo23BufferedStream;

import java.io.*;

public class Demo01BufferedOutputStream {
//  public static void main(String[] args) throws IOException {
//    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("bufferedStream.txt"));
//
//    bufferedOutputStream.write("abc".getBytes());
//    bufferedOutputStream.close();
//
//    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("bufferedStream.txt"));
//    int len;
//    while ((len = bufferedInputStream.read()) != -1) {
//      System.out.print((char) len);
//    }
//    bufferedInputStream.close();
//
//  }


  // 1 基本流

//  public static void main(String[] args) {
//    long s1 = System.currentTimeMillis();
//    try (
//      FileInputStream fis1 = new FileInputStream("bg.rar");
//      FileOutputStream fos1 = new FileOutputStream("bg2.rar");
//    ) {
//      int byte1;
//      while ((byte1 = fis1.read()) != -1) {
//        fos1.write(byte1);
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    long e1 = System.currentTimeMillis();
//    System.out.println(e1 - s1); // 26545 KB  用时 487806ms 487s
//  }


//  2 缓冲流

//  public static void main(String[] args) {
//    long s2 = System.currentTimeMillis();
//
//    try (
//      BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream("bg.rar"));
//      BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream("bg3.rar"));
//    ) {
//      int byte2;
//      while ((byte2 = bis2.read()) != -1) {
//        bos2.write(byte2);
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    long e2 = System.currentTimeMillis();
//    System.out.println(e2 - s2); // 2729ms 再次覆盖 990ms
//  }


//  3 缓冲流数组

  public static void main(String[] args) {
    long s3 = System.currentTimeMillis();

    try (
      BufferedInputStream bis3 = new BufferedInputStream(new FileInputStream("bg.rar"));
      BufferedOutputStream bos3 = new BufferedOutputStream(new FileOutputStream("bg4.rar"));
    ) {
      int byte3;
      byte[] bytes= new byte[1024 * 8];
      while ((byte3 = bis3.read(bytes)) != -1) {
        bos3.write(bytes, 0, byte3);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    long e3 = System.currentTimeMillis();
    System.out.println(e3 - s3); // 207ms 再次覆盖 166ms
  }
}
