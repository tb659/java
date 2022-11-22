package demo1.demo19Recursion;

public class Demo01 {
  public static void main(String[] args) {
    int i = 0;
    a(i);
  }

  private static void a(int i) {
    System.out.println(i);
    if (i > 20000) return;
    a(++i);

  }
}
