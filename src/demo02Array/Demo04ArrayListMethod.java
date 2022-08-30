package demo02Array;

import java.util.ArrayList;

public class Demo04ArrayListMethod {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();

    boolean success = list.add("张三");
    list.add("高园园");
    list.add("李四");
    list.add("王二麻子");
    System.out.println(success);
    System.out.println(list);

    String whoGet = list.get(2);
    System.out.println("拿到的是：" + whoGet);
    System.out.println(list);

    String whoRemoved = list.remove(3);
    System.out.println("删除的是：" + whoRemoved);
    System.out.println(list);

    System.out.println(list.size());
  }
}
