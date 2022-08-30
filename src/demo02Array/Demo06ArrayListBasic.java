package demo02Array;

import java.util.ArrayList;
import java.util.Random;

public class Demo06ArrayListBasic {
  public static void main(String[] args) {

    ArrayList<String> listA = new ArrayList<>();

    ArrayList<Byte> listB = new ArrayList<>();

    ArrayList<Short> listC = new ArrayList<>();

    ArrayList<Integer> listD = new ArrayList<>();

    ArrayList<Long> listE = new ArrayList<>();

    ArrayList<Float> listF = new ArrayList<>();

    ArrayList<Double> listG = new ArrayList<>();

    ArrayList<Character> listH = new ArrayList<>();

    ArrayList<Boolean> listI = new ArrayList<>();

    Random random = new Random();
    for (int i = 0; i < 5; i++) {
      int num = random.nextInt(10) + 1;
      listD.add(num);
    }
    for (int i = 0; i < listD.size(); i++) {
      System.out.println(listD.get(i));
    }
//    for (Integer i : listD) {
//      System.out.println(i);
//    }

    ArrayList<Student> stuList = new ArrayList<>();
    Student one = new Student("张三", 12);
    Student two = new Student("李四", 13);
    Student three = new Student("王二", 14);
    stuList.add(one);
    stuList.add(two);
    stuList.add(three);

    for (Student student : stuList) {
      System.out.println("姓名：" + student.getName() + ", 年龄：" + student.getAge());
    }
  }
}
