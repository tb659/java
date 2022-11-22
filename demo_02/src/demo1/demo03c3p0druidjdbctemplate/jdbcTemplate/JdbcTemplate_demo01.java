package demo1.demo03c3p0druidjdbctemplate.jdbcTemplate;

import demo1.demo03c3p0druidjdbctemplate.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName JdbcTemplate_demo01
 * @Description TODO
 * @Author @TB659
 * @Date 2022-11-02 16:49
 * @Version 1.0
 */

public class JdbcTemplate_demo01 {
  public static void main(String[] args) {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    String sql = "update account set balance = 5000 where id = ?";
    int count = jdbcTemplate.update(sql, 3);
    if (count > 0) {
      System.out.println("更新成功");
    }
  }
}
