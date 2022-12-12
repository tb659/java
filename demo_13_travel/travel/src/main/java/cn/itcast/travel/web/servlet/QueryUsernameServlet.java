package cn.itcast.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-12-04 11:04
 * @Created by @tb659
 */
@WebServlet("/queryUsername")
public class QueryUsernameServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String name = (String) req.getSession().getAttribute("username");
    res.setContentType("text/html;charset=utf-8");
    if (name == null) {
      name = "";
    }
    res.getWriter().write(name);
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.doPost(req, res);
  }
}
