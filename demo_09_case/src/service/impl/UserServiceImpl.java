package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.Account;
import domain.User;
import service.UserService;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2022-11-21 21:58
 * @Created by @tb659
 */

public class UserServiceImpl implements UserService {
  private UserDao dao = new UserDaoImpl();

  @Override
  public List<User> findAll() {
    // 调用DAO完成查询
    return dao.findAll();
  }

  @Override
  public Account login(Account account) {
    return dao.login(account.getUsername(), account.getPassword());
  }

  @Override
  public void addUser(User user) { dao.addUser(user); }

  @Override
  public void deleteUser(String id) {
    dao.deleteUser(Integer.parseInt(id));
  }

  @Override
  public User queryUserById(String id) {
    return dao.queryUserById(Integer.parseInt(id));
  }

  @Override
  public void updateUser(User user) {
    dao.updateUser(user);
  }

}
