package demo11Interface;
/*
*   接口 多个类的公共规范
*   定义格式：
*   public interface 接口名称 {
*     // 接口内容
*   }
*
*   java7 接口可以包括
*     1、常量
*     2、抽象方法
*
*   java8 接口额外可以包括
*     3、默认方法
*     4、静态方法
*
*   java9 接口额外可以包括
*     5、私有方法
*
*   接口作用步骤
*     1、接口不能直接作用，必须有一个“实现类”来”实现“接口
*   格式：
*     class：      public class 子类名称 extends 父类名称
*     interface：  public class 实现类名称 implements 接口名称 {
*                   // ...
*                  }
*     2、接口的实现类必须覆盖重写（实现）接口中的所有抽象方法 (如果不重写全部方法，实现类自身要是一个抽象类)
*        实现：去掉 abstract 关键字 加上 方法体{}
*     3、创建实现类的对象，进行使用。
* */
public class Demo01Interface {
  public static void main(String[] args) {
    MyInterfaceAbstractImplements anImplements = new MyInterfaceAbstractImplements();
    anImplements.methodAbs1();
    anImplements.methodAbs2();
    anImplements.methodAbs3();
    anImplements.methodAbs4();
  }
}
