package demo1.demo02Jdbc.jdbc;

import demo1.demo02Jdbc.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @ClassName jdbc07_login
 * @Description TODO
 * @Author @TB659
 * @Date 2022-10-12 11:16
 * @Version 1.0
 */

public class jdbc07_login {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入用户名");
    String username = scanner.next();
    System.out.println("请输入密码");
    String password = scanner.next();
    boolean loginStatus = login2(username, password);
    if (loginStatus) {
      System.out.println("登录成功");
    } else {
      System.out.println("用户名或密码错误");
    }
  }

  /**
   * @desc: 登录 使用 preparedStatement
   * @author: @TB659
   * @date: 2022-10-12
   * @params:
   * @returns:
   */
  public static boolean login2(String username, String password) {
    if (username == null || password == null) {
      return false;
    }
    Connection connection = null;
//    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      /*
      String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
      connection = JDBCUtils.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);*/

      String sql = "select * from user where username = ? and password = ?";
      connection = JDBCUtils.getConnection();
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);
      resultSet = preparedStatement.executeQuery();
      return resultSet.next();

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
//      JDBCUtils.close(resultSet, statement, connection);
      JDBCUtils.close(resultSet, preparedStatement, connection);
    }

    return false;
  }

  /**
   * @desc: 登录
   * @author: @TB659
   * @date: 2022-10-12
   * @params:
   * @returns:
   */
  public static boolean login(String username, String password) {
    if (username == null || password == null) {
      return false;
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";

      connection = JDBCUtils.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      return resultSet.next();

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      JDBCUtils.close(resultSet, statement, connection);
    }

    return false;
  }
}
