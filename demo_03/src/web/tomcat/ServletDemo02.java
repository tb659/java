package web.tomcat;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName ServletDemo02
 * @Description TODO
 * @Author @TB659
 * @Date 2022-11-15 10:36
 * @Version 1.0
 */

public class ServletDemo02 implements Servlet {

  /**
   * @desc: servlet被创建时，初始化访问执行一次
   * @author: @TB659
   * @date: 2022-11-15
   * @params: [servletConfig]
   * @returns: void
   */
  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
    System.out.println("init...");
  }

  /**
   * @desc: 获取ServletConfig对象
   *        ServletConfig：servlet配置
   * @author: @TB659
   * @date: 2022-11-15
   * @params: []
   * @returns: javax.servlet.ServletConfig
   */
  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  /**
   * @desc: servlet被访问时执行一次
   * @author: @TB659
   * @date: 2022-11-15
   * @params: [servletRequest, servletResponse]
   * @returns: void
   */
  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    System.out.println("service...");
  }

  @Override
  /**
   * @desc: 获取Servlet信息 版本、作者
   * @author: @TB659
   * @date: 2022-11-15
   * @params: []
   * @returns: java.lang.String
   */
  public String getServletInfo() {
    return null;
  }

  /**
   * @desc: servlet被销毁时执行一次
   * @author: @TB659
   * @date: 2022-11-15
   * @params: []
   * @returns: void
   */
  @Override
  public void destroy() {
    System.out.println("destroy...");
  }
}
