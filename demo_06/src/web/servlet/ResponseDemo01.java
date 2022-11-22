package web.servlet;

import javax.servlet.ServletException;
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
@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    System.out.println("demo1111被访问了");
    // response.setStatus(302);
    // response.setHeader("location", "/demo_06/responseDemo02");

    String contextPath = request.getContextPath();
    System.out.println(contextPath);
    response.sendRedirect(contextPath + "/responseDemo02");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
