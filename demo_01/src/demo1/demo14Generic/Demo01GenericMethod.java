package demo1.demo14Generic;

public class Demo01GenericMethod {
  public static void main(String[] args) {

    /*
        泛型方法
    * */
    GenericMethod gm = new GenericMethod();

    System.out.println(gm.get(123));
    System.out.println(gm.get("泛型方法"));
    System.out.println(gm.get(true));
    System.out.println(GenericMethod.getStatic("泛型静态方法"));

  }

}
