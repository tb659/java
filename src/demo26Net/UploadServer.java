package demo26Net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class UploadServer {
//  public static void main(String[] args) throws IOException {
//
//    ServerSocket serverSocket = new ServerSocket(8888);
//
//    Socket socket = serverSocket.accept();
//
//    InputStream is = socket.getInputStream();
//
//    File file = new File("test2.png");
//    if (!file.exists()) {
//      file.createNewFile();
//    }
//
//    FileOutputStream fos = new FileOutputStream(file);
//
//    System.out.println("1111111111111111111111");
//
//    int len;
//    byte[] buffer = new byte[1024];
//    while ((len = is.read(buffer)) != -1) {
//      fos.write(buffer, 0, len);
//    }
//
//    System.out.println("22222222222222222222222  while死循环打印不到");
//
//    OutputStream os = socket.getOutputStream();
//    os.write("上传成功".getBytes());
//
//    fos.close();
//    socket.close();
//    serverSocket.close();
//  }

  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(8888);
    while (true) {
      Socket socket = server.accept();

//      new Thread(new Runnable() {
//        @Override
//        public void run() {
//          try {
//            InputStream is = socket.getInputStream();
//
//            File file = new File("test" + System.currentTimeMillis() + new Random().nextInt(999999) + ".png");
//            if (!file.exists()) {
//              file.createNewFile();
//            }
//
//            FileOutputStream fos = new FileOutputStream(file);
//
//            int len;
//            byte[] buffer = new byte[1024];
//            while ((len = is.read(buffer)) != -1) {
//              fos.write(buffer, 0, len);
//            }
//
//            socket.getOutputStream().write("上传成功".getBytes());
//
//            fos.close();
//            socket.close();
//
//          } catch (IOException e) {
//            e.printStackTrace();
//          }
//        }
//      }).start();

      new Thread(() -> {
        try {
          InputStream is = socket.getInputStream();

          File file = new File("test" + System.currentTimeMillis() + new Random().nextInt(999999) + ".png");
          if (!file.exists()) {
            file.createNewFile();
          }

          FileOutputStream fos = new FileOutputStream(file);

          int len;
          byte[] buffer = new byte[1024];
          while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
          }

          socket.getOutputStream().write("上传成功".getBytes());

          fos.close();
          socket.close();

        } catch (IOException e) {
          e.printStackTrace();
        }
      }).start();

    }
    // server.close();
  }
}
