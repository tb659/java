package demo1.demo08Super;

public class Person {
  public Person() {
    System.out.println("父类构造方法");
  }
  public Person(int num) {
    System.out.println("父类构造方法");
  }

  int num = 30;

  public void method() {
    System.out.println("父类方法！");
  }
}
