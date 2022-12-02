package gtrb.mt.web.serlvet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname DemoServlet
 * @Description TODO
 * @Date 2022-11-30 11:31
 * @Created by @tb659
 */

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Hello Maven Servlet ~~~");
  }
}
