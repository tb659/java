package web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName ServletDemo01
 * @Description TODO
 * @Author @TB659
 * @Date 2022-11-15 11:36
 * @Version 1.0
 */

//@WebServlet(urlPatterns = "/demo01")
@WebServlet("/demo02")
public class ServletDemo01 implements Servlet {
  @Override
  public void init(ServletConfig servletConfig) throws ServletException {

  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    System.out.println("Servlet3.0来了...");
  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {

  }
}
