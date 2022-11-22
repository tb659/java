package demo1.demo16Thread;

public class Demo01Thread {
  public static void main(String[] args) {
    MyThread mt = new MyThread();
//    mt.setName("自定义线程名称");
    mt.start();

    System.out.println(Thread.currentThread().getName());

    new MyThread("自定义线程名称222222").start();

    for (int i = 1; i <= 10; i++) {
      System.out.println("main " + i);
    }
  }
}
