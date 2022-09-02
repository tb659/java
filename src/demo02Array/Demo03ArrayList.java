package demo02Array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Demo03ArrayList {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    System.out.println(list);

    list.add("mt");
    list.add("mt2");
    list.add("mt3");

    ArrayList<String> list2 = new ArrayList<>();
    list2.add("赵张三");
    list.addAll(list2);
    list.addAll(1, list2);
    Collections.addAll(list2, "李四", "王五");
    System.out.println(list);

    Collections.shuffle(list2);
    System.out.println(list2);

    Collections.sort(list2);
    System.out.println(list2);
  }
}
