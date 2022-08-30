package cn.itcast.day11.demo03;

public class Demo03InnerClass {
  public static void main(String[] args) {
    House house = new House();
    house.method();

    House.Bed bed = new House().new Bed();
    bed.sleep();
  }
}
