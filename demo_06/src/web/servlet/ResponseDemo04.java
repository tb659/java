package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description response
 * @Date 2022-11-18 20:32
 * @Created by @tb659
 */
@WebServlet("/responseDemo04")
public class ResponseDemo04 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html;charset=utf-8");

    ServletOutputStream sos = response.getOutputStream();
    sos.write("hello".getBytes());
    sos.write("你好".getBytes("utf-8"));
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
