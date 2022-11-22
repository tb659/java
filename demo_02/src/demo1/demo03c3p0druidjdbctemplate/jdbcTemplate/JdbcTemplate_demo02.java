package demo1.demo03c3p0druidjdbctemplate.jdbcTemplate;

import demo1.demo03c3p0druidjdbctemplate.domain.Emp;
import demo1.demo03c3p0druidjdbctemplate.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JdbcTemplate_demo02
 * @Description TODO
 * @Author @TB659
 * @Date 2022-11-03 10:05
 * @Version 1.0
 */

public class JdbcTemplate_demo02 {

  private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  @Test
  public void test1() {
    String sql = "update emp set salary = 10000 where id = 1001";
    int count = template.update(sql);
    System.out.println(count);
  }

  @Test
  public void test2() {
    String sql = "insert into emp(id, ename, dept_id) values(?,?,?)";
    int count = template.update(sql, 1015, "郭靖", 10);
    System.out.println(count);
  }

  @Test
  public void test3() {
    String sql = "delete from emp where id = ?";
    int count = template.update(sql, 1015);
    System.out.println(count);
  }

  @Test
  public void test4() {
    String sql = "select * from emp where id = ?";
    Map<String, Object> stringObjectMap = template.queryForMap(sql, 1001);
    System.out.println(stringObjectMap);
    // {id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}
  }

  @Test
  public void test5() {
    String sql = "select * from emp where id = ? or id = ?";
    Map<String, Object> stringObjectMap = template.queryForMap(sql, 1001, 1002);
    System.out.println(stringObjectMap); // Incorrect result size: expected 1, actual 2
  }

  @Test
  public void test6() {
    String sql = "select * from emp";
    List<Map<String, Object>> list = template.queryForList(sql);
    System.out.println(list);
  }

  @Test
  public void test7() {
    String sql = "select * from emp";
    List<Emp> list = template.query(sql, new RowMapper<Emp>() {

      @Override
      public Emp mapRow(ResultSet rs, int i) throws SQLException {
        Emp emp = new Emp();
        int id = rs.getInt("id");
        String ename = rs.getString("ename");
        int job_id = rs.getInt("job_id");
        int mgr = rs.getInt("mgr");
        Date joindate = rs.getDate("joindate");
        double salary = rs.getDouble("salary");
        double bonus = rs.getDouble("bonus");
        int dept_id = rs.getInt("dept_id");

        emp.setId(id);
        emp.setEname(ename);
        emp.setJob_id(job_id);
        emp.setMgr(mgr);
        emp.setJoindate(joindate);
        emp.setSalary(salary);
        emp.setBonus(bonus);
        emp.setDept_id(dept_id);

        return emp;
      }
    });

    for (Emp emp : list) {
      System.out.println(emp);
    }
    System.out.println(list);
  }

  @Test
  public void test71() {
    List<Emp> list = null;

    String sql = "select * from emp";
    template.query(sql, (rs) -> {
      Emp emp = new Emp();
      int id = rs.getInt("id");
      String ename = rs.getString("ename");
      int job_id = rs.getInt("job_id");
      int mgr = rs.getInt("mgr");
      Date joindate = rs.getDate("joindate");
      double salary = rs.getDouble("salary");
      double bonus = rs.getDouble("bonus");
      int dept_id = rs.getInt("dept_id");

      emp.setId(id);
      emp.setEname(ename);
      emp.setJob_id(job_id);
      emp.setMgr(mgr);
      emp.setJoindate(joindate);
      emp.setSalary(salary);
      emp.setBonus(bonus);
      emp.setDept_id(dept_id);

      System.out.println(emp);
    });

  }


  @Test
  public void test72(){
    String sql = "select * from emp";
    List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
    for (Emp emp : list) {
      System.out.println(emp);
    }
    System.out.println(list);
  }

  @Test
  public void test8() {
    String sql = "select count(id) from emp";
    Long total = template.queryForObject(sql, Long.class);
    System.out.println(total);
  }

}
