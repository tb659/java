package dao;

import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

/**
 * @ClassName UserDao
 * @Description 操作数据库中User表的类
 * @Author @TB659
 * @Date 2022-11-18 11:56
 * @Version 1.0
 */

public class UserDao {

  private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  /**
   * @desc:
   * @author: @TB659
   * @date: 2022-11-18 14:56
   * @Param loginUser: 只有用户名和密码
   * @return: domain.User 用户全部信息
   */
  public User login(User loginUser) {
    try {

      String sql = "select * from user where username = ? and password = ?";

      User user = template.queryForObject(sql,
        new BeanPropertyRowMapper<User>(User.class),
        loginUser.getUsername(), loginUser.getPassword());

      return user;
    } catch (DataAccessException e) {
      e.printStackTrace();
      return null;
    }
  }
}
