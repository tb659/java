package demo1.demo02Array;

import java.util.*;

public class Demo03HashMap {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    String put = map.put("name", "张三");

    System.out.println(put);

    String put1 = map.put("name", "张三儿");

    System.out.println(put1);

    map.put("job", "教师");
    map.put(null, null);

    map.replace("job", "教师", "老板");
    map.replace("name", "李四");

    System.out.println(map.size());
    System.out.println(map.containsKey("name"));
    System.out.println(map.containsKey("name1"));
    System.out.println(map.get("name"));

    System.out.println("=======================");

//    System.out.println(map.keySet());
    Set<String> strings = map.keySet();
    Iterator<String> iterator = strings.iterator();
    while (iterator.hasNext()) {
      String key = iterator.next();
      System.out.println(key);
      System.out.println(map.get(key));
    }

    System.out.println("=======================");

    for (String s : map.keySet()) {
      System.out.println(s);
      System.out.println(map.get(s));
    }

    System.out.println("=======================");

    Set<Map.Entry<String, String>> entries = map.entrySet();
    for (Map.Entry<String, String> entry : entries) {
      System.out.println(entry);
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }

    System.out.println("=======================");

    System.out.println(entries);
    System.out.println(map);

    System.out.println("=======================");

    String job = map.remove("job");
    String job1 = map.remove("job");
    System.out.println(job);
    System.out.println(job1);
    System.out.println(map);

    System.out.println("=======================");

    HashMap<Character, Integer> hashMap = new HashMap<>();
    String str = new Scanner(System.in).next();
    for (char c : str.toCharArray()) {
      System.out.println(c);
      if (hashMap.containsKey(c)) {
        Integer value = hashMap.get(c);
        value++;
        hashMap.put(c, value);
      } else {
        hashMap.put(c, 1);
      }
    }
    for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
      Character key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println(key + " = " + value);
    }
  }
}
