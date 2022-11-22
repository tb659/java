package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo06")
public class RequestDemo06 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // String username = request.getParameter("username");
    // System.out.println("post");
    // System.out.println(username);

    // String[] hobbies = request.getParameterValues("hobby");
    // for (String hobby : hobbies) {
    //   System.out.println(hobby);
    // }

    // Enumeration<String> names = request.getParameterNames();
    // while (names.hasMoreElements()) {
    //   String name = names.nextElement();
    //   System.out.println(name);
    //   String value = request.getParameter(name);
    //   System.out.println(value);
    //   System.out.println("--------------");
    // }

    // Enumeration<String> names = request.getParameterNames();
    // while (names.hasMoreElements()) {
    //   String name = names.nextElement();
    //   System.out.println(name);
    //   String[] values = request.getParameterValues(name);
    //   for (String value : values) {
    //     System.out.println(value);
    //   }
    //   System.out.println("--------------");
    // }

    Map<String, String[]> parameterMap = request.getParameterMap();

    Set<String> keySet = parameterMap.keySet();
    for (String name : keySet) {
      System.out.println(name);
      String[] values = parameterMap.get(name);
      for (String value : values) {
        System.out.println(value);
      }
      System.out.println("-------------------");
    }

    Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
    Iterator<Map.Entry<String, String[]>> iterator = entries.iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, String[]> next = iterator.next();
      String name = next.getKey();
      System.out.println(name);
      String[] values = next.getValue();
      for (String value : values) {
        System.out.println(value);
      }
      System.out.println("-------------------");
    }
    for (Map.Entry<String, String[]> entry : entries) {
      String name = entry.getKey();
      System.out.println(name);
      String[] values = entry.getValue();
      for (String value : values) {
        System.out.println(value);
      }
      System.out.println("-------------------");
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // String username = request.getParameter("username");
    // System.out.println("get");
    // System.out.println(username);
    this.doPost(request, response);
  }

}
