package demo1.demo02Jdbc.jdbc;

import demo1.demo02Jdbc.domain.Emp;
import demo1.demo02Jdbc.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName jdbc06_quert_list
 * @Description TODO
 * @Author @TB659
 * @Date 2022-10-11 11:45
 * @Version 1.0
 */

public class jdbc06_quert_list {
  public static void main(String[] args) {
//    List<Emp> list = findAll();
    List<Emp> list = findAll2();
    System.out.println(list);
    System.out.println(list.size());
  }

  /**
   * @desc: 查询所有epm对象
   * @author: @TB659
   * @date: 2022-10-11
   * @params:
   * @returns:
   */
  public static List<Emp> findAll() {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    ArrayList<Emp> list = null;
    try {
      // 注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 获取数据库连接对象
      connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
      // 获取执行sql语句的对象
      statement = connection.createStatement();
      // 定义sql语句
      String sql = "select * from emp";
      // 执行sql
      resultSet = statement.executeQuery(sql);

      // 遍历循环 封装对象 装载集合
      Emp emp = null;
      list = new ArrayList<>();
      while (resultSet.next()) {
        // 获取数据
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int job_id = resultSet.getInt("job_id");
        int mgr = resultSet.getInt("mgr");
        Date joindate = resultSet.getDate("joindate");
        double salary = resultSet.getDouble("salary");
        double bonus = resultSet.getDouble("bonus");
        int dept_id = resultSet.getInt("dept_id");
        // 创建emp对象 并赋值
        emp = new Emp();
        emp.setId(id);
        emp.setName(name);
        emp.setJob_id(job_id);
        emp.setMgr(mgr);
        emp.setJoindate(joindate);
        emp.setSalary(salary);
        emp.setBonus(bonus);
        emp.setDept_id(dept_id);
        // 装载集合
        list.add(emp);
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
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
    return list;
  }

  public static List<Emp> findAll2() {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    ArrayList<Emp> list = null;
    try {
      /*// 注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 获取数据库连接对象
      connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");*/
      connection = JDBCUtils.getConnection();
      // 获取执行sql语句的对象
      statement = connection.createStatement();
      // 定义sql语句
      String sql = "select * from emp";
      // 执行sql
      resultSet = statement.executeQuery(sql);

      // 遍历循环 封装对象 装载集合
      Emp emp = null;
      list = new ArrayList<>();
      while (resultSet.next()) {
        // 获取数据
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int job_id = resultSet.getInt("job_id");
        int mgr = resultSet.getInt("mgr");
        Date joindate = resultSet.getDate("joindate");
        double salary = resultSet.getDouble("salary");
        double bonus = resultSet.getDouble("bonus");
        int dept_id = resultSet.getInt("dept_id");
        // 创建emp对象 并赋值
        emp = new Emp();
        emp.setId(id);
        emp.setName(name);
        emp.setJob_id(job_id);
        emp.setMgr(mgr);
        emp.setJoindate(joindate);
        emp.setSalary(salary);
        emp.setBonus(bonus);
        emp.setDept_id(dept_id);
        // 装载集合
        list.add(emp);
      }
    } catch (SQLException e) {
      e.printStackTrace();
//    } catch (ClassNotFoundException e) {
//      e.printStackTrace();
    } finally {
      /*if (resultSet != null) {
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
      }*/
      JDBCUtils.close(resultSet, statement, connection);
    }
    return list;
  }
}
