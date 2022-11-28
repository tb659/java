package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-26 16:47
 * @Created by @tb659
 */
@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    String name = req.getParameter("name");
    System.out.println(name);

    String[] names = req.getParameterValues("name");
    for (String value : names) {
      System.out.println(value);
    }

    Map<String, String[]> parameterMap = req.getParameterMap();
    Set<String> keySet = parameterMap.keySet();
    for (String key : keySet) {
      String[] values = parameterMap.get(key);
      for (String value : values) {
        System.out.println(value);
      }
    }
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.doPost(req, res);
  }
}
