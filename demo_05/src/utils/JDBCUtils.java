package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Classname JDBCUtils
 * @Description TODO
 * @Date 2022-11-18 15:02
 * @Created by TB659
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

  public static DataSource getDataSource() {
    return ds;
  }

  public static Connection getConnection() throws SQLException {
    return ds.getConnection();
  }
}
