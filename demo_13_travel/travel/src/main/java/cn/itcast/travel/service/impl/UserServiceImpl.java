package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2022-12-01 21:03
 * @Created by @tb659
 */

public class UserServiceImpl implements UserService {

  private UserDao userDao = new UserDaoImpl();

  /**
   * @desc: 注册用户
   * @author: @tb659
   * @date: 2022-12-02 13:25
   * @Param user:
   * @return: boolean
   */
  @Override
  public boolean register(User user) {
    User u = userDao.queryUserByUsername(user.getUsername());
    if (u != null) {
      return false;
    }
    user.setCode(UuidUtil.getUuid());
    user.setStatus("N");
    userDao.register(user);

    String content = "<a href='http://localhost:8080/travel/user/activeUser?code=" + user.getCode() + "'>点击激活旅游网</a>";
    MailUtils.sendMail(user.getEmail(), content, "激活邮件");
    return true;
  }

  /**
   * @desc: 激活
   * @author: @tb659
   * @date: 2022-12-02 22:39
   * @Param code:
   * @return: boolean
   */
  @Override
  public int activeUser(String code) {
    User user = userDao.queryUserByCode(code);
    if (user != null) {
      if (user.getStatus().equals("Y")) {
        return 2;
      } else {
        userDao.updateUserStatus(user.getUid());
        return 1;
      }
    }
    return 0;
  }

  /**
   * @desc: 用户登录
   * @author: @tb659
   * @date: 2022-12-03 21:45
   * @Param loginUser:
   * @return: cn.itcast.travel.domain.User
   */
  @Override
  public User login(User loginUser) {
    return userDao.login(loginUser);
  }

}
