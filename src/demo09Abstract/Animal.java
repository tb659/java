package demo09Abstract;
/*
*     抽象类：  加上 abstract 去掉大括号 直接分号结束
*             1、不能直接创建new抽象类对象
*             2、必须用一个子类继承抽象类
*             3、子类必须重写抽象父类的所有抽象方法
*             4、创建子类对象进行使用
* */
public abstract class Animal {
  public Animal() {
    System.out.println("抽象父类构造方法");
  }

//  public void method() {
//    System.out.println("抽象父类成员方法");
//  }

  public abstract void eat();

  public abstract void sleep();
}
