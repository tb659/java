package demo16Thread;

public class Demo02Runnable {
  public static void main(String[] args) {
    MyRunnable mr = new MyRunnable();
    Thread t = new Thread(mr);
    t.start();

    for (int i = 1; i <= 10; i++) {
      System.out.println(Thread.currentThread().getName() + i);
      if(i == 1) {
        int[] list = {1,2,3};
        System.out.println(list[3]);
      }
    }
  }
}
