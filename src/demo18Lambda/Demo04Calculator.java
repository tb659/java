package demo18Lambda;

public class Demo04Calculator {
  public static void main(String[] args) {
//    invokeCalc(120, 130, new Calculator() {
//      @Override
//      public int calc(int a, int b) {
//        return a + b;
//      }
//    });
//  }

//    invokeCalc(120, 130, (int a, int b) -> {
//      return a + b;
//    });

    invokeCalc(120, 130, (a, b) -> a + b);
  }

  private static void invokeCalc(int a, int b, Calculator calculator) {
    int result = calculator.calc(a, b);
    System.out.println(result);
  }
}
