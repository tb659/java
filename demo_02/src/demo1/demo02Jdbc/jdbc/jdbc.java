package demo1.demo02Jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @ClassName mt.demo.jdbc
 * @Description TODO
 * @Author @TB659
 * @Date 2022-10-10 15:28
 * @Version 1.0
 */

public class jdbc {
  public static void main(String[] args) throws Exception {
    // 1.导入jar包
    // 2.注册驱动 mysql5之后的驱动包可以省略（自动注册）
    Class.forName("com.mysql.jdbc.Driver");
    // 3.获取数据库连接对象 // localhost:3306 可以忽略不写
//    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
    Connection connection = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
    // 4.定义sql语句
    String sql = "update account set balance = 500 where id = 1";
    // 5.获取执行sql语句的对象 statement
    Statement statement = connection.createStatement();
    // 6.执行sql
    int count = statement.executeUpdate(sql);
    // 7.处理结果
    System.out.println(count);
    // 8.释放资源
    statement.close();
    connection.close();
  }
}
