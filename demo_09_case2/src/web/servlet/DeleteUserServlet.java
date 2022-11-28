package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-22 10:42
 * @Created by @tb659
 */
@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String id = request.getParameter("id");

    UserService service = new UserServiceImpl();
    service.deleteUser(id);

    // response.sendRedirect(request.getContextPath() + "/userListServlet");
    response.sendRedirect(request.getContextPath() + "/queryUserByPageServlet");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
