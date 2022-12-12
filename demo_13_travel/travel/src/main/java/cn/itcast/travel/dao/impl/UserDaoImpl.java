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

  private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

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
      user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
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
    String sql = "insert into tab_user(username, password, name, birthday, sex, telephone, email, status, code) "
      + "values(?,?,?,?,?,?,?,?,?)";
    template.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getBirthday(),
      user.getSex(), user.getTelephone(), user.getEmail(), user.getStatus(), user.getCode());
  }

  /**
   * @desc: 根据code查询用户
   * @author: @tb659
   * @date: 2022-12-03 11:11
   * @Param code:
   * @return: cn.itcast.travel.domain.User
   */
  @Override
  public User queryUserByCode(String code) {
    User user = null;
    try {
      String sql = "select * from tab_user where code = ?";
      user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), code);
    } catch (Exception e) {

    }
    return user;
  }

  /**
   * @desc: 更新用户状态
   * @author: @tb659
   * @date: 2022-12-03 11:15
   * @return: void
   */
  @Override
  public void updateUserStatus(int uid) {
    String sql = "update tab_user set status = 'Y' where uid = ?";
    template.update(sql, uid);
  }

  /**
   * @desc: 用户登录
   * @author: @tb659
   * @date: 2022-12-03 21:47
   * @Param loginUser:
   * @return: cn.itcast.travel.domain.User
   */
  @Override
  public User login(User loginUser) {
    String sql = "select * from tab_user where username = ? and password = ?";
    User user = null;
    try {
      user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), loginUser.getUsername(), loginUser.getPassword());
    } catch (Exception e) {

    }
    return user;
  }

}
