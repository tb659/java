package demo1.demo02Array;

import java.util.Arrays;

public class Demo01Array {
  public static void main(String[] args) {

    int[] list1 = new int[4];
    System.out.println(list1.length);

    String[] list2 = new String[12];
    System.out.println(list2.length);

    int[] list3 = new int[]{1, 2, 3};
    System.out.println(list3.length);

    int[] list4 = {1, 2};
    System.out.println(list4.length);

    int[] list5;
    list5 = new int[2];
    System.out.println(list5.length);

    int[] list6;
    list6 = new int[]{1, 1, 1};
    System.out.println(list6.length);

    System.out.println("********************");
    System.out.println(list1[0]);
    System.out.println(list1[1]);
    System.out.println(list2[0]);
    System.out.println(list3[2]);
    System.out.println(list4[1]);
    list4[1] = 122;
    System.out.println(list4[1]);

    int[] list7 = new int[]{10, 20, 30, 40, 50, 60};
    for (int min = 0, max = list7.length - 1; min < max; min++, max--) {
      int temp = list7[min];
      list7[min] = list7[max];
      list7[max] = temp;
    }
    for (int i = 0; i < list7.length; i++) {
      System.out.println(list7[i]);
    }

    System.out.println("**********************");

    System.out.println(Arrays.toString(list7));

    int[] list8 = new int[]{111, 10, 20, 30, 40, 50, 60};
    Arrays.sort(list8);
    System.out.println(Arrays.toString(list8));
  }
}
