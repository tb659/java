package demo1.demo12Date;

import java.util.Calendar;

public class Demo02Calender {
  public static void main(String[] args) {
    Calendar rightNow = Calendar.getInstance();
    System.out.print(rightNow.get(Calendar.YEAR));
    System.out.print(rightNow.get(Calendar.MONTH) + 1);
    System.out.print(rightNow.get(Calendar.DAY_OF_MONTH));
    System.out.print(rightNow.get(Calendar.HOUR_OF_DAY));
    System.out.print(rightNow.get(Calendar.MINUTE));
    System.out.println(rightNow.get(Calendar.SECOND));

    System.out.println("=====================");

    rightNow.set(Calendar.YEAR, 9999);
    System.out.println(rightNow.get(Calendar.YEAR));

    System.out.println("=====================");

    rightNow.set(1234, 3, 24, 12, 12, 12);
    System.out.print(rightNow.get(Calendar.YEAR));
    System.out.print(rightNow.get(Calendar.MONTH) + 1);
    System.out.print(rightNow.get(Calendar.DAY_OF_MONTH));
    System.out.print(rightNow.get(Calendar.HOUR_OF_DAY));
    System.out.print(rightNow.get(Calendar.MINUTE));
    System.out.println(rightNow.get(Calendar.SECOND));

    System.out.println("=====================");

    rightNow.add(Calendar.MONTH, 1);
    System.out.println(rightNow.get(Calendar.MONTH) + 1);

    System.out.println("=====================");

    System.out.println(rightNow.getTime());

  }
}
