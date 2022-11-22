package demo1.demo05Class;

public class Demo03StudentStatic {
  public static void main(String[] args) {

    Student.room = "101教室";

    Student one = new Student("张三", 12);
//    System.out.println(one.room);
    System.out.println(one.getName() + "的教室：" + Student.room);

    Student two = new Student("李四", 13);
    System.out.println(two.getName() + "的教室：" + Student.room);
  }

}
