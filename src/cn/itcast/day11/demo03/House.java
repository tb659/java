package cn.itcast.day11.demo03;

public class House {

  int num = 10;

  public class Bed {

    int num = 20;

    public void sleep() {
      int num = 30;
      System.out.println("在床上睡觉");
      System.out.println(num);
      System.out.println(this.num);
      System.out.println(House.this.num);
    }
  }

  private String name;

  public House() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void method() {
    Bed bed = new Bed();
    bed.sleep();
  }

}
