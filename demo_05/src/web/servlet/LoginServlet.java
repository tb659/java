package web.servlet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Classname LoginServlet
 * @Description 登录
 * @Date 2022-11-18 17:04
 * @Created by @tb659
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    req.setCharacterEncoding("utf-8");

    // String username = req.getParameter("username");
    // String password = req.getParameter("password");
    //
    // User loginUser = new User();
    // loginUser.setUsername(username);
    // loginUser.setPassword(password);

    Map<String, String[]> parameterMap = req.getParameterMap();

    User loginUser = new User();

    try {
      BeanUtils.populate(loginUser, parameterMap);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    UserDao userDao = new UserDao();
    User user = userDao.login(loginUser);

    if (user == null) {
      // 登录失败
      req.getRequestDispatcher("/failServlet").forward(req, resp);
    } else {
      // 登录成功
      req.setAttribute("user", user);
      req.getRequestDispatcher("/successServlet").forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
