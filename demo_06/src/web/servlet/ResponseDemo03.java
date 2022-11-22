package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname ${NAME}
 * @Description response
 * @Date 2022-11-18 20:32
 * @Created by @tb659
 */
@WebServlet("/responseDemo03")
public class ResponseDemo03 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // response.setCharacterEncoding("utf-8");
    // response.setHeader("content-type", "text/html;charset=utf-8");

    response.setContentType("text/html;charset=utf-8");

    PrintWriter pw = response.getWriter();
    pw.write("<h1>hello response 哈哈</h1>");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
