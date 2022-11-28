package doMain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @Classname user
 * @Description TODO
 * @Date 2022-11-27 13:35
 * @Created by @tb659
 */

public class User {
  private String name;
  private int age;

  // @JsonIgnore
  @JsonFormat(pattern="yyyy-MM-dd")
  private Date birthday;

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }
}
