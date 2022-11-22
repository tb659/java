package demo1.demo03c3p0druidjdbctemplate.datasource.druid;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @ClassName Druid_demo01
 * @Description TODO
 * @Author @TB659
 * @Date 2022-11-02 15:23
 * @Version 1.0
 */

public class Druid_demo01 {
  public static void main(String[] args) throws Exception {

    Properties prop = new Properties();
    InputStream inputstream = Druid_demo01.class.getClassLoader().getResourceAsStream("druid.properties");
    prop.load(inputstream);

    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    Connection connection = dataSource.getConnection();
    System.out.println(connection);

  }
}
