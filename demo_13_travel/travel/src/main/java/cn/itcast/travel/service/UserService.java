package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2022-12-01 21:03
 * @Created by @tb659
 */

public interface UserService {

  /**
   * @desc: 注册用户
   * @author: @tb659
   * @date: 2022-12-02 13:29
   * @Param user:
   * @return: boolean
   */
  boolean register(User user);

  /**
   * @desc: 激活
   * @author: @tb659
   * @date: 2022-12-02 22:39
   * @Param code:
   * @return: boolean
   */
  boolean activeUser(String code);
}
