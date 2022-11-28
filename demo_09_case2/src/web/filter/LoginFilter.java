package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-25 16:36
 * @Created by @tb659
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {

    HttpServletRequest request = (HttpServletRequest) req;

    String uri = request.getRequestURI();
    if (uri.contains("login.jsp") || uri.contains("/checkCodeServlet") || uri.contains("loginServlet") || uri.contains("/css/") || uri.contains("/font/") || uri.contains("/js/")) {
      chain.doFilter(req, res);
    } else {
      Object account = request.getSession().getAttribute("account");
      if (account == null) {
        request.setAttribute("login_msg", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/login.jsp").forward(request, res);
      } else {
        chain.doFilter(req, res);
      }
    }
  }

  public void init(FilterConfig config) throws ServletException {

  }

  public void destroy() {

  }

}
