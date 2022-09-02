package demo13Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo01 {
  public static void main(String[] args) {
    Collection<String> list = new ArrayList();
    list.add("迪丽热巴");
    list.add("古丽那扎");
    list.add("马尔扎哈");
    Iterator<String> i = list.iterator();

    while (i.hasNext()) {
      String name = i.next();
      System.out.println(name);
    }

    System.out.println("====================");

    for (String s: list) {
      System.out.println(s);
    }
    System.out.println("====================");

    for (Iterator<String> it = list.iterator();it.hasNext();) {
      String s = it.next();
      System.out.println(s);
    }
  }
}
