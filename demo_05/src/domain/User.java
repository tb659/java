package domain;

/**
 * @ClassName User
 * @Description 用户的实体类
 * @Author @TB659
 * @Date 2022-11-18 11:53
 * @Version 1.0
 */

public class User {
  private Integer id;
  private String username;
  private String password;

  private String gender;

  public void setHehe(String gender) {
    this.gender = gender;
  }

  public String getHehe() {
    return gender;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", gender='" + gender + '\'' +
      '}';
  }
}
