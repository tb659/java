package demo15Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Demo01Exception {
  public static void main(String[] args)/* throws ParseException */{
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
//      date = sdf.parse("2222-0202");
      date = sdf.parse("2222-02-02");
    } catch (ParseException e) {
      e.printStackTrace();
    }
    System.out.println(date);

    int[] list = new int[]{1,2,3};
    try {
      System.out.println(list[3]);
    } catch (Exception e) {
      System.out.println(e);
    }

//    int[] err = new int[1024 * 1024 * 1024]; // 内存溢出
//    Objects.requireNonNull(null, "对象为空");
    Objects.requireNonNull(1, "对象为空");
    System.out.println("后续代码");
  }
}
