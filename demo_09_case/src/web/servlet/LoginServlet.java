package web.servlet;

import domain.Account;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Classname ${NAME}
 * @Description 验证码
 * @Date 2022-11-18 20:32
 * @Created by @tb659
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    request.setCharacterEncoding("utf-8");

    String checkCode = request.getParameter("checkCode");
    HttpSession session = request.getSession();
    String codeStr = (String) session.getAttribute("CHECK_CODE_SERVER");
    session.removeAttribute("CHECK_CODE_SERVER");

    if (!codeStr.equalsIgnoreCase(checkCode)) {
      request.setAttribute("login_msg", "验证码错误");
      request.getRequestDispatcher("/login.jsp").forward(request, response);
      return;
    }
    Map<String, String[]> parameterMap = request.getParameterMap();
    Account account = new Account();
    try {
      BeanUtils.populate(account, parameterMap);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    UserService service = new UserServiceImpl();
    Account loginAccount = service.login(account);

    if (loginAccount == null) {
      request.setAttribute("login_msg", "用户名或密码错误");
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    } else {
      session.setAttribute("account", loginAccount);
      response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
