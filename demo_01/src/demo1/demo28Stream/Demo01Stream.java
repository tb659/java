package demo1.demo28Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Demo01Stream {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList();
    list.add("张无忌");
    list.add("赵敏");
    list.add("周芷若");

    list.stream()
      .filter(name -> name.startsWith("张"))
      .filter(name -> name.length() == 3)
      .forEach(name -> System.out.println(name));

    list.forEach(name -> {
      System.out.println(name);
    });

    Map<String, Integer> map = new HashMap<>();
    map.put("age1", 12);
    map.put("age2", 123);
    map.forEach(new BiConsumer<String, Integer>() {
      @Override
      public void accept(String key, Integer value) {
        System.out.println(key + ": " + value);
      }
    });

    Stream<String> list2 = list.stream().map(name -> name + "s");
    list2.forEach(name -> System.out.println(name));

    System.out.println(list.stream().count());

    list.stream().limit(2).forEach(name -> System.out.println(name));

    list.stream().skip(1).forEach(name -> System.out.println(name));

    Stream.concat(list.stream().limit(1), list.stream().skip(1)).forEach(name -> System.out.println(name));
  }
}
