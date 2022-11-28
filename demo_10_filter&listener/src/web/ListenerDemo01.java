package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;

/**
 * @Classname ListenerDemo01
 * @Description TODO
 * @Date 2022-11-26 20:43
 * @Created by @tb659
 */

public class ListenerDemo01 implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    System.out.println("监听器创建");
    // 加载资源文件

    ServletContext servletContext = servletContextEvent.getServletContext();

    String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

    String realPath = servletContext.getRealPath(contextConfigLocation);

    try {
      FileInputStream fs = new FileInputStream(realPath);
      System.out.println(fs);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    System.out.println("监听器销毁");
  }
}
