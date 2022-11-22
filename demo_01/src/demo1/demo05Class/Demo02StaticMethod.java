package demo1.demo05Class;

import static demo1.demo05Class.MyClass.methodStatic;

public class Demo02StaticMethod {
  public static void main(String[] args) {
    MyClass obj = new MyClass();
    obj.method();

    methodStatic(); // 引入
    methodStatic(); // 不推荐
    methodStatic(); // 推荐
    
    myMethod();
    // 和下面等效
    Demo02StaticMethod.myMethod();
  }

  private static void myMethod() {
    System.out.println("这是自己的方法");
  }

}
