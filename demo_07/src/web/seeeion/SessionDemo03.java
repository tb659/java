package web.seeeion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-19 21:41
 * @Created by @tb659
 */
@WebServlet("/sessionDemo03")
public class SessionDemo03 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session = request.getSession();
    System.out.println(session.getId());

    Cookie jsessionid = new Cookie("JSESSIONID", session.getId());
    jsessionid.setMaxAge(60 * 60);
    response.addCookie(jsessionid);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
