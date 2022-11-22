package web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-19 15:57
 * @Created by @tb659
 */
@WebServlet("/cookieDemo05")
public class CookieDemo05 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html;charset=utf-8");

    String date = null;
    Cookie[] cookies = request.getCookies();

    if (cookies != null && cookies.length > 0) {
      for (Cookie cookie : cookies) {
        if ("lastTime".equals(cookie.getName())) {
          date = URLDecoder.decode(cookie.getValue(), "utf-8");
          break;
        }
      }
    }
    Cookie lastTime = new Cookie("lastTime",
      URLEncoder.encode(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")
        .format(new Date()), "utf-8"));

    lastTime.setMaxAge(60 * 60 * 24 * 30);

    response.addCookie(lastTime);

    if (date == null) {
      response.getWriter().write("您好，欢迎您首次访问");
    } else {
      response.getWriter().write("欢迎回来，您上次访问的时间是: " + date);
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
