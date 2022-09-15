package demo26Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class BSTCPServer {
  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(8888);

    while (true) {
      new Thread(() -> {
        try {
          Socket socket = server.accept();

          InputStream is = socket.getInputStream();

          // byte[] buffer = new byte[1024];
          // int len = is.read(buffer, 0, buffer.length);
          // System.out.println(new String(buffer, 0, len));

          BufferedReader reader = new BufferedReader(new InputStreamReader(is));
          String line = reader.readLine();
          System.out.println(line);

          String htmlPath = line.split(" ")[1].substring(1);
          FileInputStream fis = new FileInputStream(htmlPath);
          OutputStream os = socket.getOutputStream();

          os.write("HTTP/1.1 200 OK\r\n".getBytes());
          os.write("Content-Type: text/html\r\n".getBytes());
          os.write("\r\n".getBytes());

          int len;
          byte[] buf = new byte[1024];
          while ((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
          }

          fis.close();
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

      }).start();
    }

//    server.close();
  }
}
