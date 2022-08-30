package demo11Interface;

public class MyInferfaceDefaultB implements MyInterfaceDefault {

  @Override
  public void methodAbs() {
    System.out.println("实现的抽象方法：BBB");
  }

  @Override
  public void methodDefault() {
    System.out.println("实现类B 覆盖重写了接口的默认方法");
  }
}
