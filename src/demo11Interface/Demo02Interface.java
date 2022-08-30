package demo11Interface;

public class Demo02Interface {
  public static void main(String[] args) {

    MyInferfaceDefaultA a = new MyInferfaceDefaultA();
    a.methodAbs();
    a.methodDefault();

    System.out.println("===============");
    
    MyInferfaceDefaultB b = new MyInferfaceDefaultB();
    b.methodAbs();
    b.methodDefault();
  }
}
