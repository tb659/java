package demo1.demo02Jdbc.jdbc;

import java.sql.*;

/**
 * @ClassName mt.demo.jdbc04_create_table
 * @Description TODO
 * @Author @TB659
 * @Date 2022-10-11 10:26
 * @Version 1.0
 */

public class jdbc05_query_map {
  public static void main(String[] args) {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");

      connection = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");

      statement = connection.createStatement();

      String sql = "select * from account";

      resultSet = statement.executeQuery(sql);

      while (resultSet.next() /*游标下移一行*/) {
        int id = resultSet.getInt(1);
        String name = resultSet.getString("name");
        int balance = resultSet.getInt(3);
        System.out.println(id + "--" + name + "--" + balance);
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException throwable) {
      throwable.printStackTrace();
    } finally {
      if (resultSet != null) {
        try {
          resultSet.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
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
