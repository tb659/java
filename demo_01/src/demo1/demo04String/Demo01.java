package demo1.demo04String;

import java.util.Arrays;

public class Demo01 {
  public static void main(String[] args) {

    int[] list = {1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println(Arrays.toString(list));

    String str = new String();
    str = "Hello World!!!";
    System.out.println(str);

    String str1 = new String("This is a string");
    System.out.println(str1);

    char[] charArray = {'A', 'B', 'C'};
    String str2 = new String(charArray);
    System.out.println(str2);

    byte[] byteArray = {97, 98, 99};
    String str3 = new String(byteArray);
    System.out.println(str3);

    String str4 = "中华人民共和国";
    System.out.println(str4);
  }
}
