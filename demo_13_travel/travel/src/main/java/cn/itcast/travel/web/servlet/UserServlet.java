package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Classname UserServlet
 * @Description TODO
 * @Date 2022-12-04 15:54
 * @Created by @tb659
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

  final UserService service = new UserServiceImpl();

  /**
   * @desc: 注册用户
   * @author: @tb659
   * @date: 2022-12-04 16:50
   * @Param req:
   * @Param res:
   * @return: void
   */
  public void registerUser(HttpServletRequest req, HttpServletResponse res) throws IOException {

    ResultInfo info = new ResultInfo();

    String checkCode = req.getParameter("check");
    HttpSession session = req.getSession();
    String checkCodeStr = (String) session.getAttribute("CHECK_CODE_SERVER");
    session.removeAttribute("CHECK_CODE_SERVER");

    if (checkCode == null || !checkCode.equalsIgnoreCase(checkCodeStr)) {
      info.setFlag(false);
      info.setErrorMsg("验证码错误");

      writeValue(info, res);

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
    boolean flag = service.register(user);
    if (flag) {
      info.setFlag(true);
    } else {
      info.setFlag(false);
      info.setErrorMsg("用户名重复，注册失败");
    }

    writeValue(info, res);
  }

  /**
   * @desc: 激活用户
   * @author: @tb659
   * @date: 2022-12-04 16:54
   * @Param req:
   * @Param res:
   * @return: void
   */
  public void activeUser(HttpServletRequest req, HttpServletResponse res) throws IOException {

    String code = req.getParameter("code");
    if (code != null) {
      int activeStatus = service.activeUser(code);
      String msg;
      if (activeStatus == 2) {
        msg = "请勿重复激活，去<a href='../login.html'>登录</a>";
      } else if (activeStatus == 1) {
        msg = "激活成功，请<a href='../login.html'>登录</a>";
      } else {
        msg = "激活失败，请联系管理员！！！";
      }
      res.getWriter().write(msg);
    }
  }

  /**
   * @desc: 用户登录
   * @author: @tb659
   * @date: 2022-12-04 16:52
   * @Param req:
   * @Param res:
   * @return: void
   */
  public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    ResultInfo info = new ResultInfo();

    HttpSession session = req.getSession();
    String checkCode_str = (String) session.getAttribute("CHECK_CODE_SERVER");
    String checkCode = req.getParameter("check");
    if (checkCode_str != null && !checkCode_str.equalsIgnoreCase(checkCode)) {
      info.setFlag(false);
      info.setErrorMsg("验证码错误！");

      writeValue(info, res);

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
      req.getSession().setAttribute("user", user);
    }

    writeValue(info, res);
  }

  /**
   * @desc: 查询用户
   * @author: @tb659
   * @date: 2022-12-04 16:58
   * @Param req:
   * @Param res:
   * @return: void
   */
  public void queryUser(HttpServletRequest req, HttpServletResponse res) throws IOException {

    User user = (User) req.getSession().getAttribute("user");

    writeValue(user, res);
  }

  /**
   * @desc: 退出登录
   * @author: @tb659
   * @date: 2022-12-04 16:59
   * @Param null:
   * @return: null
   */
  public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {

    req.getSession().removeAttribute("user");
    res.getWriter().write("");
  }
}
