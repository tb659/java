package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Classname UserDaoImpl
 * @Description TODO
 * @Date 2022-12-01 21:04
 * @Created by @tb659
 */

public class UserDaoImpl implements UserDao {

  private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  /**
   * @desc: 根据用户名查询用户
   * @author: @tb659
   * @date: 2022-12-02 13:29
   * @Param username:
   * @return: cn.itcast.travel.domain.User
   */
  @Override
  public User queryUserByUsername(String username) {
    User user = null;
    try {
      String sql = "select * from tab_user where username = ?";
      user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
    } catch (Exception e) {

    }
    return user;
  }

  /**
   * @desc: 注册用户
   * @author: @tb659
   * @date: 2022-12-02 13:29
   * @Param user:
   * @return: void
   */
  @Override
  public void register(User user) {
    String sql = "insert into tab_user(username, password, name, birthday, sex, telephone, email) values(?,?,?,?,?,?,?)";
    template.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getBirthday(), user.getSex(), user.getTelephone(), user.getEmail());
  }
}
