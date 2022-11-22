package demo1.demo07Extends;

public class Teacher extends Employee {

  int num = 20;

  public void printNum() {
    int num = 30;
    System.out.println(num); // 30
    System.out.println(this.num); // 20
    System.out.println(super.num); // 10
  }

}
