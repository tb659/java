package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-12-02 22:24
 * @Created by @tb659
 */
@WebServlet("/activeUser")
public class ActiveUserServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String code = req.getParameter("code");
    if (code != null) {
      UserService service = new UserServiceImpl();
      boolean flag = service.activeUser(code);
      String msg = "";
      if (flag) {
         msg = "激活成功，请<a href='login.html'>登录</a>";
      } else {
        msg = "激活失败，请联系管理员！";
      }
      res.setContentType("text/html;charset=utf-8");
      res.getWriter().write(msg);
    }
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.doPost(req, res);
  }
}
