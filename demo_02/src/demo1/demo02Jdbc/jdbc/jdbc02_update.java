package demo1.demo02Jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName mt.demo.jdbc02_update
 * @Description TODO
 * @Author @TB659
 * @Date 2022-10-11 10:02
 * @Version 1.0
 */

public class jdbc02_update {
  public static void main(String[] args) {
    Connection connection = null;
    Statement statement = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
      statement = connection.createStatement();
      String sql = "update account set balance = 1500 where id = 3";
      int count = statement.executeUpdate(sql);
      if (count > 0) {
        System.out.println("修改成功");
      } else {
        System.out.println("修改失败");
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
