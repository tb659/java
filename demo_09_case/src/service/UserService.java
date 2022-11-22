package service;

import domain.Account;
import domain.User;

import java.util.List;

/**
 * @Classname UserService
 * @Description 用户管理的业务接口
 * @Date 2022-11-21 21:53
 * @Created by @tb659
 */

public interface UserService {

  /**
   * @desc: 查询所有用户信息
   * @author: @tb659
   * @date: 2022-11-21 21:55
   * @return: java.util.List<domain.User>
   */
  List<User>findAll();

  /**
   * @desc: 登录
   * @author: @tb659
   * @date: 2022-11-22 00:37
   * @return: domain.User
   */
  Account login(Account account);

  /**
   * @desc: 新增用户
   * @author: @tb659
   * @date: 2022-11-22 10:38
   * @Param user:
   * @return: void
   */
  void addUser(User user);

  /**
   * @desc: 新增用户
   * @author: @tb659
   * @date: 2022-11-22 10:38
   * @Param user:
   * @return: void
   */
  void deleteUser(String id);

  /**
   * @desc: 查询用户
   * @author: @tb659
   * @date: 2022-11-22 10:38
   * @Param user:
   * @return: void
   */
  User queryUserById(String id);

  /**
   * @desc: 更新用户
   * @author: @tb659
   * @date: 2022-11-22 10:38
   * @Param user:
   * @return: void
   */
  void updateUser(User user);
}
