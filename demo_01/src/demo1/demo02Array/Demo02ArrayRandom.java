package demo1.demo02Array;

import java.util.Arrays;
import java.util.Random;

public class Demo02ArrayRandom {
  public static void main(String[] args) {

    Random random = new Random();

    int[] list = new int[10];

    for (int i = 0; i < 10; i++) {
      int i1 = random.nextInt();
      list[i]= i1;
    }
    System.out.println(Arrays.toString(list));

    int[] list1 = new int[10];
    for (int i = 0; i < 10; i++) {
      int i1 = random.nextInt(10);
      list1[i]= i1;
    }
    System.out.println(Arrays.toString(list1));
  }
}
