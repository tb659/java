package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname User
 * @Description TODO
 * @Date 2022-11-20 20:20
 * @Created by @tb659
 */

public class User {
  private String name;
  private Integer age;
  private Date birthday;

  public User(String name, Integer age, Date birthday) {
    this.name = name;
    this.age = age;
    this.birthday = birthday;
  }

  public User() {
  }

  public String getBirthdayStr() {
    if (birthday != null) {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(birthday);
    } else {
      return "";
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
}
