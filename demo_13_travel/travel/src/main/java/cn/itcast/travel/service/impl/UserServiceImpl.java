package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2022-12-01 21:03
 * @Created by @tb659
 */

public class UserServiceImpl implements UserService {

  private UserDao UserDao = new UserDaoImpl();

  /**
   * @desc: 注册用户
   * @author: @tb659
   * @date: 2022-12-02 13:25
   * @Param user:
   * @return: boolean
   */
  @Override
  public boolean register(User user) {
    User u = UserDao.queryUserByUsername(user.getUsername());
    if (u != null) {
      return false;
    }
    UserDao.register(user);
    return true;
  }
}
