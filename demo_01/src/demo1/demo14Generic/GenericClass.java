package demo1.demo14Generic;

public class GenericClass<E, T> {

  private E name;
  private T age;

  public E getName() {
    return name;
  }

  public void setName(E name) {
    this.name = name;
  }

  public T getAge() {
    return age;
  }

  public void setAge(T age) {
    this.age = age;
  }
}
