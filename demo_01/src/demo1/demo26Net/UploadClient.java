package demo1.demo26Net;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadClient {
//  public static void main(String[] args) throws IOException {
//
//    FileInputStream fis = new FileInputStream("test.png");
//
//    Socket socket = new Socket("127.0.0.1", 8888);
//
//    OutputStream os = socket.getOutputStream();
//
//    int len;
//    byte[] buffer = new byte[1024];
//    while ((len = fis.read(buffer)) != -1) {
//      os.write(buffer, 0, len);
//    }
//
//    /*
//        解决:上传完文件,给服务器写一个结束标记
//        void shutdownOutput() 禁用此套接字的输出流。
//        对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列。
//     */
//    socket.shutdownOutput(); // 解决死循环
//
//    InputStream is = socket.getInputStream();
//
//    System.out.println("333333333333333333333");
//
//    while ((len = is.read(buffer)) != -1) {
//      System.out.println(new String(buffer,0,len));
//    }
//
//    System.out.println("444444444444444444  while死循环打印不到");
//    fis.close();
//    socket.close();
//
//
//  }

  public static void main(String[] args) throws IOException {
    FileInputStream fis = new FileInputStream("test.png");
    Socket socket = new Socket(("127.0.0.1"), 8888);
    OutputStream os = socket.getOutputStream();

    int len;
    byte[] buf = new byte[1024];
    while ((len = fis.read(buf)) != -1) {
      os.write(buf, 0, len);
    }

    socket.shutdownOutput();

    InputStream is = socket.getInputStream();

    while ((len = is.read(buf)) != -1) {
      System.out.println(new String(buf, 0, len));
    }
  }
}