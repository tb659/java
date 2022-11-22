package demo1.demo08Super;
/*
    super：
*     1、子类成员方法中 访问父类的成员属性
*     2、子类成员方法中 访问父类的成员方法
*     3、子类构造方法中 访问父类的构造方法(放在第一行)

    this：
      1、本类的成员方法中 访问本类的属性
      2、本类的成员方法中 访问本类的另一个方法
      3、本类的构造方法中 访问本类的另一个构造方法(放在第一行)

* */
public class Student extends Person {
  public Student() {
    super(); // 3、访问父类构造方法
//    super(12);
    System.out.println("子类构造方法");
  }

  public Student(int num) {
    System.out.println(num);
  }

  public Student(String str) {
    this(123);
    System.out.println(str);
  }

  int num = 20;

  @Override
  public void method() {
    System.out.println(num); // 20
    System.out.println(super.num); // 30 访问父类属性
    super.method(); // 访问父类方法
  }
}
