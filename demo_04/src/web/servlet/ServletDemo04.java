package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ServletDemo04
 * @Description TODO
 * @Author @TB659
 * @Date 2022-11-15 15:19
 * @Version 1.0
 */

@WebServlet({"/d5", "/dd5", "/ddd5"})
public class ServletDemo04 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("d5...");
  }
}
