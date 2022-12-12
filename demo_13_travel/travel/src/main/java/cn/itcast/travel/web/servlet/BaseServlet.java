package cn.itcast.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-12-04 15:53
 * @Created by @tb659
 */
public class BaseServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String uri = req.getRequestURI();
    String methodName = uri.substring(uri.lastIndexOf("/") + 1);

    try {
      // 暴力反射
      /*Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
      method.setAccessible(true);
      method.invoke(this, req, resp)*/;

      // System.out.println(methodName);

      Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
      method.invoke(this, req, resp);

    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  public void writeValue(Object obj, HttpServletResponse res) throws IOException {
    res.setContentType("application/json;charset=utf-8");
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(res.getOutputStream(), obj);
  }

  public void writerValueAsString(Object obj) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValueAsString(obj);
  }
}
