package demo1.demo24InputOutputStreamReaderWriter;

import java.io.Serializable;

public class Employee implements Serializable {
  public static final long serialVersionUID = 111L; // 防止反序列化失败
  public String name;
  public String address;
  public transient int age;

  public Employee() {
  }

  public Employee(String name, String address, int age) {
    this.name = name;
    this.address = address;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Employee{" +
      "name='" + name + '\'' +
      ", address='" + address + '\'' +
      ", age=" + age +
      '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void addressCheck() {
    System.out.println(this.name + ":" + this.address);
  }
}
