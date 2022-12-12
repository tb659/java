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
 * @Date 2022-12-04 15:04
 * @Created by @tb659
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    req.getSession().removeAttribute("username");
    res.setContentType("text/html;charset=utf-8");
    res.getWriter().write("");
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.doPost(req, res);
  }
}
