package demo14Generic;

public class Demo01GenericInterface implements GenericInterface<String> {

  @Override
  public void method(String name) {
    System.out.println(name);
  }
}
