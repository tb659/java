package web.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName ServletDemo02
 * @Description TODO
 * @Author @TB659
 * @Date 2022-11-15 14:49
 * @Version 1.0
 */

@WebServlet("/demo03")
public class ServletDemo02 extends GenericServlet {
  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    System.out.println("service...");
  }
}
