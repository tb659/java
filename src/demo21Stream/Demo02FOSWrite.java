package demo21Stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02FOSWrite {
  public static void main(String[] args) throws IOException {

    FileOutputStream fos = new FileOutputStream("a.txt");

//   写出字节
    fos.write(97);
    fos.write(98);
    fos.write(99);
    fos.write(65);
    fos.write('a');
//    fos.write("hello");
    fos.close();

//    写出字节数组
    FileOutputStream fos2 = new FileOutputStream("b.txt");
    fos2.write("helloWorld".getBytes());
    fos2.close();

//    写出指定长度字节数组
    FileOutputStream fos3 = new FileOutputStream("c.txt");
    fos3.write("hello".getBytes(), 3, 2);
    fos3.close();

//    追加数据
    FileOutputStream fos4 = new FileOutputStream("a.txt", true);
    fos4.write("追加数据".getBytes());
    fos4.close();

//    换行
    FileOutputStream fos5 = new FileOutputStream("b.txt");
    fos5.write('a');
    fos5.write("\r\n".getBytes()); // windows \r\n    linux \n
    fos5.write('b');
    fos5.close();

  }
}

