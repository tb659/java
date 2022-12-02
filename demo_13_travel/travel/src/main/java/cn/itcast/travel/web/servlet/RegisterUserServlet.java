package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-12-01 20:18
 * @Created by @tb659
 */
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    ResultInfo info = new ResultInfo();
    ObjectMapper mapper = new ObjectMapper();

    String checkCode = req.getParameter("check");
    HttpSession session = req.getSession();
    String checkCodeStr = (String) session.getAttribute("CHECKCODE_SERVER");
    session.removeAttribute("CHECKCODE_SERVER");

    if (checkCode == null || !checkCode.equalsIgnoreCase(checkCodeStr)) {
      info.setFlag(false);
      info.setErrorMsg("验证码错误");
      String s = mapper.writeValueAsString(info);
      res.getWriter().write(s);
      return;
    }
    Map<String, String[]> parameterMap = req.getParameterMap();
    User user = new User();
    try {
      BeanUtils.populate(user, parameterMap);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    // System.out.println(user);
    UserService service = new UserServiceImpl();
    Boolean flag = service.register(user);
    if (flag) {
      info.setFlag(true);
    } else {
      info.setFlag(false);
      info.setErrorMsg("用户名重复，注册失败");
    }
    String s = mapper.writeValueAsString(info);
    res.getWriter().write(s);
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.doPost(req, res);
  }
}
