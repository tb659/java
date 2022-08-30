package demo11Interface;
/*
java8开始， 可以定义默认方法
public default 返回值类型 方法名称(参数列表) {
  // ...
}
tips: 接口当中的默认方法，可以解决接口升级的问题
*/
public interface MyInterfaceDefault {

  public abstract void methodAbs();

  public default void methodDefault() {
    System.out.println("新建一个默认方法");
  }
}
