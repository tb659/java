package demo1.demo02Jdbc.domain;

import java.util.Date;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author @TB659
 * @Date 2022-10-11 11:41
 * @Version 1.0
 */

public class Emp {
  private int id;
  private String name;
  private int job_id;
  private int mgr;
  private Date joindate;
  private double salary;
  private double bonus;
  private int dept_id;

  @Override
  public String toString() {
    return "emp{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", job_id=" + job_id +
      ", mgr=" + mgr +
      ", joindate=" + joindate +
      ", salary=" + salary +
      ", bonus=" + bonus +
      ", dept_id=" + dept_id +
      '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getJob_id() {
    return job_id;
  }

  public void setJob_id(int job_id) {
    this.job_id = job_id;
  }

  public int getMgr() {
    return mgr;
  }

  public void setMgr(int mgr) {
    this.mgr = mgr;
  }

  public Date getJoindate() {
    return joindate;
  }

  public void setJoindate(Date joindate) {
    this.joindate = joindate;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public double getBonus() {
    return bonus;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  public int getDept_id() {
    return dept_id;
  }

  public void setDept_id(int dept_id) {
    this.dept_id = dept_id;
  }
}
