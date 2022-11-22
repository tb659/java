package demo1.demo02Jdbc.util;

/**
 * @ClassName JDBCUtils
 * @Description TODO
 * @Author @TB659
 * @Date 2022-10-11 14:08
 * @Version 1.0
 */

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @desc: jdbc工具类
 * @author: @TB659
 * @date: 2022-10-11
 * @params:
 * @returns:
 */
public class JDBCUtils {
  private static String url;
  private static String user;
  private static String password;
  private static String driver;

  static {
    // 读取资源文件
    try {
      // 创建properties集合类
      Properties properties = new Properties();

      // 加载文件 获取src路径下文件  classLoader类加载器

      ClassLoader classLoader = JDBCUtils.class.getClassLoader();
      URL resource = classLoader.getResource("jdbc.properties");
      String path = resource.getPath();
      properties.load(new FileReader(path));
//       properties.load(new FileReader("src/jdbc.properties"));
//       properties.load(new FileReader("D:\\0WorkSpace\\project\\java\\demo_02\\src\\jdbc.properties"));

      // 获取数据 赋值
      url = properties.getProperty("url");
      user = properties.getProperty("user");
      password = properties.getProperty("password");
      driver = properties.getProperty("driver");
      // 注册驱动
      Class.forName(driver);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * @desc:
   * @author: @tb659
   * @date: 2022-11-18 15:39
   
   * @return: java.sql.Connection
   */
  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }

  /**
   * @desc: 释放资源
   * @author: @TB659
   * @date: 2022-10-11
   * @params:
   * @returns:
   */
  public static void close(Statement statement, Connection connection) {
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException throwable) {
        throwable.printStackTrace();
      }
    }
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException throwable) {
        throwable.printStackTrace();
      }
    }
  }

  /**
   * @desc: 
   * @author: @tb659
   * @date: 2022-11-18 15:35
   * @Param resultSet: 
   * @Param statement: 
   * @Param connection: 
   * @return: void
   */
  public static void close(ResultSet resultSet, Statement statement, Connection connection) {
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException throwable) {
        throwable.printStackTrace();
      }
    }
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException throwable) {
        throwable.printStackTrace();
      }
    }
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException throwable) {
        throwable.printStackTrace();
      }
    }
  }
}
