package demo1.demo02Jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName mt.demo.jdbc03_delete
 * @Description TODO
 * @Author @TB659
 * @Date 2022-10-11 10:22
 * @Version 1.0
 */

public class jdbc03_delete {
  public static void main(String[] args) {
    Connection connection = null;
    Statement statement = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
      statement = connection.createStatement();
      String sql = "delete from account where id = 3";
      int count = statement.executeUpdate(sql);
      if (count > 0) {
        System.out.println("删除成功");
      } else {
        System.out.println("删除失败");
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
