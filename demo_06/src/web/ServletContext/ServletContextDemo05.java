package web.ServletContext;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-19 09:45
 * @Created by @tb659
 */
@WebServlet("/servletContextDemo05")
public class ServletContextDemo05 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    ServletContext context = request.getServletContext();

    String path = context.getRealPath("/b.txt"); // web目录下资源访问
    System.out.println(path);

    String c = context.getRealPath("/WEB-INF/c.txt"); // WEB-INF下的资源目录
    System.out.println(c);

    String a = context.getRealPath("/WEB-INF/classes/a.txt"); // src下的资源目录
    System.out.println(a);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
