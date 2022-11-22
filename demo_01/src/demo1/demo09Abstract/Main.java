package demo1.demo09Abstract;

public class Main {
  public static void main(String[] args) {

    Cat cat = new Cat();
    cat.eat();

    System.out.println("========================");
//    Dog dog = new Dog();
//    dog.eat();

    Dog2Ha ha = new Dog2Ha();
    ha.eat();
    ha.sleep();

    System.out.println("========================");

    DogGolden golden = new DogGolden();
    golden.eat();
    golden.sleep();
  }
}
