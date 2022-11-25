package service;

import domain.Account;
import domain.PageList;
import domain.User;

import java.util.List;
import java.util.Map;

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
  List<User> findAll();

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

  /**
   * @desc: 批量删除指定用户
   * @author: @tb659
   * @date: 2022-11-24 10:01
   * @Param ids:
   * @return: void
   */
  void deleteSelectedUsers(String[] ids);

  /**
   * @desc: 分页条件查询用户
   * @author: @tb659
   * @date: 2022-11-24 21:27
   * @Param pageSize:
   * @Param pageNumber:
   * @Param condition:
   * @return: domain.PageList<domain.User>
   */
  PageList<User> queryUserByPage(String pageSize, String pageNumber, Map<String, String[]> condition);
}
