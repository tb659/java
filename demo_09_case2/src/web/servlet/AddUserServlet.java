package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-22 09:10
 * @Created by @tb659
 */
@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    request.setCharacterEncoding("utf-8");

    // 获取参数
    Map<String, String[]> parameterMap = request.getParameterMap();
    User user = new User();
    try {
      BeanUtils.populate(user, parameterMap);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    UserService service = new UserServiceImpl();
    service.addUser(user);

    // response.sendRedirect(request.getContextPath() + "/userListServlet");
    response.sendRedirect(request.getContextPath() + "/queryUserByPageServlet");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
