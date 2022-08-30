package demo06Math;

import java.util.Random;

public class Demo01Math {
  public static void main(String[] args) {
    double num = Math.PI;
    System.out.println(num);
    System.out.println(Math.max(12, 34));
    System.out.println(Math.abs(-12));
    System.out.println(Math.ceil(4.3));
    System.out.println(Math.floor(12.3));
    System.out.println(Math.min(12, 34));
    System.out.println(Math.pow(3.12, 3.45));
    System.out.println(Math.round(3.4));
    System.out.println(Math.round(3.6));
    System.out.println(new Random().nextInt());
    System.out.println(new Random().nextInt(10));
  }
}
