package web.seeeion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-19 21:41
 * @Created by @tb659
 */
@WebServlet("/sessionDemo02")
public class SessionDemo02 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    Object msg = session.getAttribute("msg");
    System.out.println(msg);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
