package demo09Abstract;

public abstract class Dog extends Animal {

  public Dog() {
    System.out.println("子类构造方法");
  }
  @Override
  public void eat() {
    System.out.println("狗吃肉");
  }
}
