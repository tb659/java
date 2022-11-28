package web.tomcat;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName ServletDemo01
 * @Description TODO
 * @Author @TB659
 * @Date 2022-11-15 09:14
 * @Version 1.0
 */

public class ServletDemo01 implements Servlet {
  @Override
  public void init(ServletConfig servletConfig) throws ServletException {

  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  // 提供服务的方法
  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    System.out.println("hello web.servlet");
  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {

  }
}
