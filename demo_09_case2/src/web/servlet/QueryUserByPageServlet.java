package web.servlet;

import domain.PageList;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-24 11:59
 * @Created by @tb659
 */
@WebServlet("/queryUserByPageServlet")
public class QueryUserByPageServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");

    String pageSize = request.getParameter("pageSize");
    String pageNumber = request.getParameter("pageNumber");

    if (pageSize == null || "".equals(pageSize)) {
      pageSize = "5";
    }
    if (pageNumber == null || "".equals(pageNumber)) {
      pageNumber = "1";
    }

    Map<String, String[]> condition = request.getParameterMap();

    UserService service = new UserServiceImpl();
    PageList<User> pageList = service.queryUserByPage(pageSize, pageNumber, condition);

    request.setAttribute("listData", pageList);
    request.setAttribute("condition", condition);
    request.getRequestDispatcher("/pageList.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
