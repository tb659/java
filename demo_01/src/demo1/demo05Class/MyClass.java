package demo1.demo05Class;

public class MyClass {

  int num = 0;
  static int numStatic = 0;

  public void method() {
    System.out.println("这是一个成员方法");

    System.out.println(numStatic);
    System.out.println(num);
    System.out.println(this.num);
  }
  public static void methodStatic() {
    System.out.println("这是一个静态方法");

    System.out.println(numStatic);
//    System.out.println(num); // 静态不能访问非静态
//    System.out.println(this); // 静态不能使用this关键字
  }
}
