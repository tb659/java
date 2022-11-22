package web.servlet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

/**
 * @Classname ${NAME}
 * @Description 验证码
 * @Date 2022-11-18 20:32
 * @Created by @tb659
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html;charset=utf-8");

    String checkCode = request.getParameter("checkCode");
    HttpSession session = request.getSession();
    String codeStr = (String) session.getAttribute("codeStr");
    session.removeAttribute("codeStr");

    if (checkCode == null) return;
    if (!checkCode.equalsIgnoreCase(codeStr)) {
      request.setAttribute("code_error", "验证码错误");
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    } else {
      Map<String, String[]> parameterMap = request.getParameterMap();
      User loginUser = new User();
      try {
        BeanUtils.populate(loginUser, parameterMap);
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
      User user = new UserDao().login(loginUser);
      if (user == null) {
        request.setAttribute("login_error", "用户名或密码错误");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
      } else {
        session.setAttribute("username", user.getUsername());
        response.sendRedirect(request.getContextPath() + "/success.jsp");
      }
    }

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
