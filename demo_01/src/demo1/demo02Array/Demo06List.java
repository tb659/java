package demo1.demo02Array;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo06List {
  public static void main(String[] args) {
    List<String> list = List.of("a", "b", "c", "d");
    System.out.println(list);
    Set<Integer> set = Set.of(1, 2, 3, 4);
    System.out.println(set);
    Map<String, Boolean> map = Map.of("sex", false,"flag", true);
    System.out.println(map);
  }
}
