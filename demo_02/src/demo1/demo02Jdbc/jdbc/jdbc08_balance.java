package demo1.demo02Jdbc.jdbc;

import demo1.demo02Jdbc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @ClassName jdbc08_balance
 * @Description TODO
 * @Author @TB659
 * @Date 2022-10-12 14:27
 * @Version 1.0
 */

public class jdbc08_balance {
  public static void main(String[] args) {
    Connection connection = null;
    PreparedStatement preparedStatement1 = null;
    PreparedStatement preparedStatement2 = null;

    try {
      String sql1 = "update account set balance = balance - ? where id = ?";
      String sql2 = "update account set balance = balance + ? where id = ?";

      connection = JDBCUtils.getConnection();
      // 开启事务
      connection.setAutoCommit(false);

      preparedStatement1 = connection.prepareStatement(sql1);
      preparedStatement2 = connection.prepareStatement(sql2);

      preparedStatement1.setDouble(1, 500);
      preparedStatement1.setInt(2, 1);

      preparedStatement2.setDouble(1, 500);
      preparedStatement2.setInt(2, 2);

      preparedStatement1.executeUpdate();

      int i = 3 / 0;

      preparedStatement2.executeUpdate();

      // 事务提交
      connection.commit();

    } catch (Exception throwables) {
      throwables.printStackTrace();

      // 事务回滚
      try {
        if (connection != null)
          connection.rollback();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } finally {
      JDBCUtils.close(preparedStatement1, connection);
      JDBCUtils.close(preparedStatement2, null);
    }
  }
}
