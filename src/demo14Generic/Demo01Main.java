package demo14Generic;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo01Main {
  public static void main(String[] args) {
    Demo01GenericInterface gi = new Demo01GenericInterface();
    gi.method("泛型接口");

    Demo01GenericInterface2 gi2 = new Demo01GenericInterface2();

    ArrayList<Integer> list1 = new ArrayList(){};
    list1.add(1);
    list1.add(2);

    ArrayList<String> list2 = new ArrayList(){};
    list2.add("1");
    list2.add("2");

    printList(list1);
    printList(list2);
  }

  /*
      泛型迭代通配符
  */
  private static void printList(ArrayList<?> list) {
    Iterator<?> it = list.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }
  }
}
