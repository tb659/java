package demo1.demo16Thread;

public class Demo03RunnableTicket {
  public static void main(String[] args) {
    MyRunnableImpl myRunnable = new MyRunnableImpl();
    Thread t0 = new Thread(myRunnable);
    Thread t1 = new Thread(myRunnable);
    Thread t2 = new Thread(myRunnable);

    t0.start();
    t1.start();
    t2.start();
  }
}
