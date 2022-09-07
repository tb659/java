package demo16Thread;

public class MyThread extends Thread {
  public MyThread() {
  }

  public MyThread(String name) {
    super(name);
  }

  @Override
  public void run() {
//    super.run();
    System.out.println(getName());

    Thread thread = Thread.currentThread();
    System.out.println(thread);
    System.out.println(Thread.currentThread().getName());

    for (int i = 1; i <= 10; i++) {
      System.out.println("run " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
