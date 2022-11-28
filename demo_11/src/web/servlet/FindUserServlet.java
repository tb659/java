package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import doMain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-27 13:12
 * @Created by @tb659
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    res.setContentType("application/json;charset=utf-8");

    String username = req.getParameter("username");

    HashMap<String, Object> map = new HashMap<>();
    if ("mt".equals(username)) {
      map.put("msg", "用户名重复!!!");
      map.put("code", 500);
    } else {
      map.put("msg", "用户名可用");
      map.put("code", 0);
    }

    ObjectMapper mapper = new ObjectMapper();
    // mapper.writeValue(res.getWriter(), map);
    res.getWriter().write(mapper.writeValueAsString(map));
    User user = new User();
    user.setName("张三");
    user.setAge(12);
    user.setBirthday(new Date());

    mapper.writeValue(new File("d://a.txt"), map);
    // System.out.println(mapper.writeValueAsString(user));
    // mapper.writeValue(new File("//WEB-INF//b.txt"), user);
    // mapper.writeValue(new File("//WEB-INF//classes//c.txt"), user);
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.doPost(req, res);
  }
}
