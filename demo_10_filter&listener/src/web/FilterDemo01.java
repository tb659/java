package web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-25 16:18
 * @Created by @tb659
 */
@WebFilter("/*")
public class FilterDemo01 implements Filter {
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {


    chain.doFilter(req, res);
  }

  public void init(FilterConfig config) throws ServletException {

  }

  public void destroy() {

  }

}
