package demo1.demo02Jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName jdbc01
 * @Description TODO
 * @Author @TB659
 * @Date 2022-10-10 17:56
 * @Version 1.0
 */

public class jdbc01_insert_into {
  public static void main(String[] args) {
    Connection connection = null;
    Statement statement = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
      statement = connection.createStatement();
      String sql = "insert into account values(null, '王五', 3000)";
      int count = statement.executeUpdate(sql);
      if (count > 0) {
        System.out.println("添加成功");
      } else {
        System.out.println("添加失败");
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
