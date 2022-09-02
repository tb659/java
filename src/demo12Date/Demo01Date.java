package demo12Date;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo01Date {
  public static void main(String[] args) throws ParseException {
    System.out.println("======================");

    Date date = new Date();
    System.out.println(date);
    System.out.println(date.getTime());
    System.out.println(new Date(1666666666666L));

    System.out.println("======================");

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(sdf.format(new Date()));
    Date d = sdf.parse("2022-09-01 16:31:48");

    System.out.println(d);
  }
}
