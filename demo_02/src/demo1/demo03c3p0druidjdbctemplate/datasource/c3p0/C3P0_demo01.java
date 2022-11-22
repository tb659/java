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

public class C3P0_demo01 {
  public static void main(String[] args) throws SQLException {
    // 1.创建数据库连接池对象
    DataSource dataSource = new ComboPooledDataSource();
//    System.out.println(dataSource);
    // 2.获取连接对象
    Connection connection = dataSource.getConnection();
    System.out.println(connection);
  }
}
