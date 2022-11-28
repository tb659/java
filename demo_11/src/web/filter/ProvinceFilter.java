package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-28 11:53
 * @Created by @tb659
 */
@WebFilter("/*")
public class ProvinceFilter implements Filter {
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {



    chain.doFilter(req, res);
  }

  public void init(FilterConfig config) throws ServletException {

  }

  public void destroy() {

  }

}
