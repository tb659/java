package demo1.demo03c3p0druidjdbctemplate.datasource.druid;

import demo1.demo03c3p0druidjdbctemplate.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName Druid_demo02
 * @Description TODO
 * @Author @TB659
 * @Date 2022-11-02 16:27
 * @Version 1.0
 */

public class Druid_demo02 {
  public static void main(String[] args) {
    // account 添加
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = JDBCUtils.getConnection();
      String sql = "insert into account values(null, ?, ?)";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, "laowang");
      preparedStatement.setDouble(2, 1000.0);
      int count = preparedStatement.executeUpdate();
      if (count > 0) {
        System.out.println("增加成功");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      JDBCUtils.close(preparedStatement, connection);
    }
  }
}
