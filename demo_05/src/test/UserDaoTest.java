package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

/**
 * @Classname UserDaoTest
 * @Description 测试
 * @Date 2022-11-18 16:03
 * @Created by @tb659
 */
public class UserDaoTest {

  @Test
  public void TestLogin() {
    User loginUser = new User();
    loginUser.setUsername("admin");
    loginUser.setPassword("8888881");

    UserDao userDao = new UserDao();
    User user = userDao.login(loginUser);
    System.out.println(user);
  }
}


