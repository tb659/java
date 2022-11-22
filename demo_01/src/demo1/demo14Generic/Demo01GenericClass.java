package demo1.demo14Generic;

public class Demo01GenericClass {
  public static void main(String[] args) {
    /*
        泛型类
    * */
    GenericClass g = new GenericClass();
    g.setName("张三");
    Object name = g.getName();
    System.out.println(name);

    System.out.println("=====================");

    GenericClass<Integer, String> g1 = new GenericClass();
    g1.setName(123);
    g1.setAge("12");
    Integer name1 = g1.getName();
    String age = g1.getAge();
    System.out.println(name1);
    System.out.println(age);

    System.out.println("=======================");

    GenericClass<Boolean, Double> g2 = new GenericClass<>();
    g2.setName(true);
    Boolean name2 = g2.getName();
    System.out.println(name2);

  }

}
