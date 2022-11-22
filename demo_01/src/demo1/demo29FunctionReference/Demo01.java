package demo1.demo29FunctionReference;

public class Demo01 {
  public static void main(String[] args) {
    printString(s -> System.out.println(s));
    printString(System.out::println);
  }

  private static void printString(print p) {
    p.print("Hello World");
  }
}
