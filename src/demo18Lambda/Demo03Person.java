package demo18Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Demo03Person {
  public static void main(String[] args) {
    Person[] user = {
      new Person("张三", 18),
      new Person("李四", 12)
    };

//    Arrays.sort(user, new Comparator<Person>() {
//      @Override
//      public int compare(Person person, Person t1) {
//        return person.getAge() - t1.getAge();
//      }
//    });

//    Arrays.sort(user, (Person u1, Person u2) -> {
//      return u2.getAge() - u1.getAge();
//    });

    Arrays.sort(user, (u1, u2) -> u2.getAge() - u1.getAge());

    for (Person person : user) {
      System.out.println(person);
    }
  }
}
