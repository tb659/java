package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
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
 * @Date 2022-12-03 21:02
 * @Created by @tb659
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    ResultInfo info = new ResultInfo();
    ObjectMapper mapper = new ObjectMapper();

    HttpSession session = req.getSession();
    String checkCode_str = (String) session.getAttribute("CHECK_CODE_SERVER");
    String checkCode = req.getParameter("check");
    if (checkCode_str != null && !checkCode_str.equalsIgnoreCase(checkCode)) {
      info.setFlag(false);
      info.setErrorMsg("验证码错误！");
      res.getWriter().write(mapper.writeValueAsString(info));
      return;
    }

    Map<String, String[]> parameterMap = req.getParameterMap();
    User loginUser = new User();
    try {
      BeanUtils.populate(loginUser, parameterMap);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    }

    UserService service = new UserServiceImpl();
    User user = service.login(loginUser);
    if (user == null) {
      info.setFlag(false);
      info.setErrorMsg("账号或密码错误！");
    } else if (user.getStatus().equals("N")) {
      info.setFlag(false);
      info.setErrorMsg("账号未激活，请先去邮箱激活账号！");
    } else {
      info.setFlag(true);
      info.setData(user);
      req.getSession().setAttribute("username", user.getName());
    }
    res.getWriter().write(mapper.writeValueAsString(info));
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.doPost(req, res);
  }
}
