package web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-19 15:57
 * @Created by @tb659
 */
@WebServlet("/cookieDemo04")
public class CookieDemo04 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Cookie c1 = new Cookie("msg", "setMaxAge");
    c1.setMaxAge(30); // 30秒
    // c1.setMaxAge(0); // 立即销毁
    response.addCookie(c1);

    Cookie c2 = new Cookie("name", "张三");
    c2.setMaxAge(-1); // 会话结束即销毁（默认）
    response.addCookie(c2);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
