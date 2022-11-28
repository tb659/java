package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-26 16:11
 * @Created by @tb659
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {

    // ServletRequest proxy_req = (ServletRequest) PProxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
    //   @Override
    //   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //     return null;
    //   }
    // });
    ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(
      req.getClass().getClassLoader(),
      req.getClass().getInterfaces(),
      (Object proxy, Method method, Object[] args) -> {
        if (method.getName().equals("getParameter")) {
          String value = (String) method.invoke(req, args);
          if (value != null) {
            for (String word : list) {
              if (value.contains(word)) {
                value = value.replaceAll(word, "**");
              }
            }
          }
          return value;
        } else if (method.getName().equals("getParameterValues")) {
          String[] values = (String[]) method.invoke(req, args);
          if (values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
              for (String word : list) {
                if (values[i].contains(word)) {
                  values[i] = values[i].replaceAll(word, "**");
                }
              }
            }
          }
          return values;
        } else if (method.getName().equals("getParameterMap")) {

          Map<String, String[]> parameterMap = (Map<String, String[]>) method.invoke(req, args);
          Set<String> keySet = parameterMap.keySet();

          for (String key : keySet) {
            String[] values = parameterMap.get(key);
            if (values != null && values.length > 0) {
              for (int i = 0; i < values.length; i++) {
                for (String word : list) {
                  if (values[i].contains(word)) {
                    values[i] = values[i].replaceAll(word, "**");
                  }
                }
              }
            }
          }
          return parameterMap;
        }
        return method.invoke(req, args);
      });
    chain.doFilter(proxy_req, res);
  }

  private List<String> list = new ArrayList<String>();

  public void init(FilterConfig config) throws ServletException {
    ServletContext servletContext = config.getServletContext();
    String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");

    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
      String line = null;
      while ((line = bufferedReader.readLine()) != null) {
        list.add(line);
      }
      bufferedReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void destroy() {

  }

}
