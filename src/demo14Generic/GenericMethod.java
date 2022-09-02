package demo14Generic;

public class GenericMethod {
  public <T> T get(T name) {
    return name;
  }
  public static <T> T getStatic(T name) {
    return name;
  }
}
