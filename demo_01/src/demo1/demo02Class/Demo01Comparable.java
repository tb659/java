package demo1.demo02Class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo01Comparable {
  public static void main(String[] args) {
//    Student student1 = new Student("x", 11);
//    Student student2 = new Student("y", 12);

    ArrayList<Student> list = new ArrayList<>();
    list.add(new Student("张三", 19));
    list.add(new Student("李四", 32));

    Collections.sort(list);
    System.out.println(list);

    Collections.sort(list, new Comparator<Student>() {
      @Override
      public int compare(Student student, Student t1) {
        return t1.getAge() - student.getAge();
      }
    });
    System.out.println(list);
  }
}
