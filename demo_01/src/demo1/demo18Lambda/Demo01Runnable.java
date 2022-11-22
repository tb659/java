package demo1.demo18Lambda;

public class Demo01Runnable {
  public static void main(String[] args) {
    RunnableImpl rb = new RunnableImpl();
    Thread t = new Thread(rb);
    t.start();

    new Thread(new Runnable(){
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName());
      }
    }).start();

    new Thread(){
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName());
      }
    }.start();

    // lambda
    new Thread(() -> {
      System.out.println(Thread.currentThread().getName());
    }).start();
  }
}
