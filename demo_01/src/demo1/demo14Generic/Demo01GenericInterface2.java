package demo1.demo14Generic;

public class Demo01GenericInterface2<T> implements GenericInterface<T> {

  @Override
  public void method(T name) {
    System.out.println(name);
  }
}
