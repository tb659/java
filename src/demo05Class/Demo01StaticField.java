package demo05Class;

public class Demo01StaticField {
  public static void main(String[] args) {

    Student one = new Student("张三", 11);
    one.room = "101教室";
    System.out.println("学号：" + one.getId()
        + "，姓名：" + one.getName() + "，年龄：" + one.getAge() + "，教室：" + one.room);

    Student two = new Student("李四", 12);
    System.out.println("学号：" + two.getId()
        + "，姓名：" + two.getName() + "，年龄：" + two.getAge() + "，教室：" + two.room);
  }
}
