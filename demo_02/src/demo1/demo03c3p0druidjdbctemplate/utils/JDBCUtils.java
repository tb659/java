package demo1.demo03c3p0druidjdbctemplate.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName JDBCUtils
 * @Description TODO
 * @Author @TB659
 * @Date 2022-11-02 16:13
 * @Version 1.0
 */

public class JDBCUtils {
  private static DataSource ds;

  static {
    try {
      Properties properties = new Properties();
      properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

      ds = DruidDataSourceFactory.createDataSource(properties);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /*
   * @desc: 获取连接
   * @author: @TB659
   * @date: 2022-11-02
   * @params:
   * @returns:
   */
  public static Connection getConnection() throws SQLException {
    return ds.getConnection();
  }

  /**
   * @desc: 释放资源
   * @author: @TB659
   * @date: 2022-11-02
   * @params:
   * @returns:
   */
  public static void close(Statement statement, Connection connection) {
     // if (statement != null) {
     //   try {
     //     statement.close();
     //   } catch (SQLException throwable) {
     //     throwable.printStackTrace();
     //   }
     // }
     // if (connection != null) {
     //   try {
     //     statement.close();
     //   } catch (SQLException throwable) {
     //     throwable.printStackTrace();
     //   }
     // }
    close(null, statement, connection);
  }

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
        statement.close();
      } catch (SQLException throwable) {
        throwable.printStackTrace();
      }
    }
  }

  /**
   * @desc: 获取连接池
   * @author: @TB659
   * @date: 2022-11-02
   * @params:
   * @returns:
   */
  public static DataSource getDataSource() {
    return ds;
  }
}
