package demo1.demo03c3p0druidjdbctemplate.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName C3P0_demo01
 * @Description TODO
 * @Author @TB659
 * @Date 2022-10-12 16:09
 * @Version 1.0
 */

public class C3P0_demo02 {
  public static void main(String[] args) throws SQLException {
//    testDefaultConfig();
    testNameConfig();
  }

  public static void testDefaultConfig() throws SQLException {
    // 1.创建数据库连接池对象
    DataSource dataSource = new ComboPooledDataSource();
//    System.out.println(dataSource);
    // 2.获取连接对象
    for (int i = 1; i <= 11; i++) {

      Connection connection = dataSource.getConnection();
      System.out.println(i + ":" + connection);

//      if (i == 5) {
//        connection.close(); // 归还连接到连接池中
//      }
    }
  }

  public static void testNameConfig() throws SQLException {
    // 1.创建数据库连接池对象
    DataSource dataSource = new ComboPooledDataSource("otherC3p0");
//    System.out.println(dataSource);
    // 2.获取连接对象
    for (int i = 1; i <= 10; i++) {

      Connection connection = dataSource.getConnection();
      System.out.println(i + ":" + connection);
    }
  }
}
