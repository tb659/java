package dao;

import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/**
 * @Classname UserDao
 * @Description 操作数据库中User表的类
 * @Date 2022-11-20 13:47
 * @Created by @tb659
 */
public class UserDao {

  private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  public User login(User loginUser) {

    try {
      String sql = "select * from user where username = ? and password = ?";

      User user = template.queryForObject(
        sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword()
      );

      return user;
    } catch (DataAccessException e) {
      e.printStackTrace();
      return null;
    }
  }
}
