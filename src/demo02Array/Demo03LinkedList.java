package demo02Array;

import java.util.LinkedList;

public class Demo03LinkedList {
  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.add(123);
    ll.addFirst(456);
    ll.push(789);
    System.out.println(ll);
    Object clone = ll.clone();
    System.out.println(clone.equals(ll));
    System.out.println(clone);
    ll.push(111);
    System.out.println(ll);
//    ll.clear();
    if (!ll.isEmpty()) {
      System.out.println(ll);
      System.out.println(ll.getFirst());
      System.out.println(ll.getLast());
      ll.remove(2);
      ll.removeFirst();
      ll.removeLast();
      System.out.println(ll);
    }
  }
}
