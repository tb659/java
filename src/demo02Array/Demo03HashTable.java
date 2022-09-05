package demo02Array;

import java.util.Hashtable;
import java.util.Map;

public class Demo03HashTable {
  public static void main(String[] args) {
    Hashtable<String, Integer> ht = new Hashtable<>();
    ht.put("id", 1);
    ht.put("flag", 1);
    ht.put("status", 0);
//    ht.put(null, null); // NullPointerException
    System.out.println(ht.put("tabs", 1));

    System.out.println("====================");

    for (String s : ht.keySet()) {
      String key = s;
      Integer value = ht.get(s);
      System.out.println(key + " = " + value);
    }

    System.out.println("====================");

    for (Map.Entry<String, Integer> entry : ht.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println(key + " = " + value);
    }
  }
}
