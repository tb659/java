package demo02Class;

public class Student implements Comparable<Student> {
//
  String name;
  int age;
//
//  public void eat() {
//    System.out.println("吃饭");
//  }
//
//  public void sleep() {
//    System.out.println("睡觉");
//  }
//
//  public void study() {
//    System.out.println("学习");
//  }

//  private String name;
//  private int age;

  public Student() {
  }

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
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
  public int compareTo(Student student) {
    return this.getAge() - student.getAge(); // 升序
//    return student.getAge() - this.getAge(); // 降序
  }
}
