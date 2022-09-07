package demo16Thread;

public class Demo04PlayGameNotifyAll {
  public static void main(String[] args) {

    Object obj = new Object();

    new Thread(){
      @Override
      public void run() {
        synchronized (obj) {
          System.out.println("player1 开始游戏");
          try {
            obj.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("player1 不玩了");
        }
      }
    }.start();

    new Thread(){
      @Override
      public void run() {
        synchronized (obj) {
          System.out.println("player2 开始游戏");
          try {
            obj.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("player2 不玩了");
        }
      }
    }.start();

    new Thread(){
      @Override
      public void run() {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (obj) {
          System.out.println("角色死亡，游戏结束");
          obj.notifyAll();
        }
      }
    }.start();
  }
}
