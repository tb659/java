package dao.impl;

import dao.UserDao;
import domain.Account;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname UserDaoImpl
 * @Description TODO
 * @Date 2022-11-21 22:00
 * @Created by @tb659
 */

public class UserDaoImpl implements UserDao {

  private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  @Override
  public List<User> findAll() {

    // 使用JDBC操作数据库
    String sql = "select * from user";
    List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    return users;
  }

  @Override
  public Account login(String username, String password) {
    try {
      String sql = "select * from account where username = ? and password = ?";
      Account account = template.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), username, password);
      return account;
    } catch (DataAccessException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void addUser(User user) {
    String sql = "insert into user values(null, ?, ?, ?, ?, ?, ?, null, null)";
    template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
  }

  @Override
  public void deleteUser(int id) {
    String sql = "delete from user where id = ?";
    template.update(sql, id);
  }

  @Override
  public User queryUserById(int id) {
    String sql = "select * from user where id = ?";
    return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
  }

  @Override
  public void updateUser(User user) {
    String sql = "update user set name = ?, gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
    template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
  }

  @Override
  public int QueryTotalCount(Map<String, String[]> condition) {
    String sql = "select count(id) from user where 1 = 1 ";

    StringBuilder stringBuilder = new StringBuilder(sql);

    List<Object> params = new ArrayList<>();
    Set<String> keySet = condition.keySet();
    for (String key : keySet) {
      if ("pageSize".equals(key) || "pageNumber".equals(key)) {
        continue;
      }
      String value = condition.get(key)[0];
      if (value != null && !"".equals(value)) {
        stringBuilder.append(" and " + key + " like ? ");
        params.add("%" + value + "%");
      }
    }
    return template.queryForObject(stringBuilder.toString(), Integer.class, params.toArray());
  }

  @Override
  public List<User> queryUserByPage(int start, int pageSize, Map<String, String[]> condition) {

    String sql = "select * from user where 1 = 1 ";

    List<Object> params = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder(sql);
    Set<String> keySet = condition.keySet();
    for (String key : keySet) {
      if ("pageSize".equals(key) || "pageNumber".equals(key)) {
        continue;
      }
      String value = condition.get(key)[0];
      if (value != null && !"".equals(value)) {
        stringBuilder.append(" and " + key + " like ?");
        params.add("%" + value + "%");
      }
    }

    stringBuilder.append(" limit ?, ?");
    params.add(start);
    params.add(pageSize);

    return template.query(stringBuilder.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
  }

}
