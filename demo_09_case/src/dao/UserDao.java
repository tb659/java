package dao;

import domain.Account;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Classname UserDao
 * @Description 用户操作的DAO
 * @Date 2022-11-21 21:59
 * @Created by @tb659
 */

public interface UserDao {

  List<User> findAll();

  Account login(String username, String password);

  void addUser(User user);

  void deleteUser(int id);

  User queryUserById(int id);

  void updateUser(User user);

  int QueryTotalCount(Map<String, String[]> condition);

  List<User> queryUserByPage(int start, int pageSize, Map<String, String[]> condition);
}
