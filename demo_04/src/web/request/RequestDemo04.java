package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo04")
public class RequestDemo04 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String referer = request.getHeader("referer");
    System.out.println(referer);
    if (referer != null && referer.contains("/request")) {
      // 正常访问
      System.out.println("看电影");
      response.setContentType("text/html;charset=utf-8");
      response.getWriter().write("看电影");
    } else{
      // 倒链
      System.out.println("来官网看吧！！");
      response.setContentType("text/html;charset=utf-8");
      response.getWriter().write("来官网看吧！！");
    }
  }

}
