package demo17ThreadPool;

public class ThreadPool implements Runnable {
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
  }
}
