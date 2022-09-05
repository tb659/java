package demo02Array;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Demo03LinkedHashMap {
  public static void main(String[] args) {
    Map<String, String> lhm = new LinkedHashMap<>();
    System.out.println(lhm);
    lhm.put("name", "张三");
    lhm.put("age", "12");
    lhm.put("sex", "男");
    lhm.put(null, null);
    System.out.println(lhm);

    System.out.println("==================");

    Set<String> strings = lhm.keySet();
    for (String string : strings) {
      System.out.println(string);
      System.out.println(lhm.get(string));
    }

    System.out.println("=====================");

    for (Map.Entry<String, String> entry : lhm.entrySet()) {
      String key = entry.getKey();
      String value = entry.getValue();
      System.out.println(key + " = " + value);
    }

  }
}
