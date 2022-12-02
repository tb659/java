package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2022-12-01 21:04
 * @Created by @tb659
 */

public interface UserDao {

  /**
   * @desc: 根据用户名查询用户
   * @author: @tb659
   * @date: 2022-12-02 13:29
   * @Param username:
   * @return: cn.itcast.travel.domain.User
   */
  User queryUserByUsername(String username);

  /**
   * @desc: 注册用户
   * @author: @tb659
   * @date: 2022-12-02 13:42
   * @Param user:
   * @return: void
   */
  void register(User user);

  /**
   * @desc: 获取用户code码
   * @author: @tb659
   * @date: 2022-12-02 22:26
   * @return: java.lang.String
   */
  String getUserCode(String code);
}
