package demo18Lambda;

public class RunnableImpl implements Runnable {
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
  }
}
