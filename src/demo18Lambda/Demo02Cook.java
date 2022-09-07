package demo18Lambda;

public class Demo02Cook {
  public static void main(String[] args) {
    invokeCook(new Cook() {
      @Override
      public void food() {
        System.out.println("制作美食");
      }
    });

    invokeCook(() -> {
      System.out.println("制作美食！！！");
    });
  }

  private static void invokeCook(Cook cook) {
    cook.food();
  }
}
