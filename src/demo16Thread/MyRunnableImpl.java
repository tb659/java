package demo16Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyRunnableImpl implements Runnable {

  private int ticket = 1;
  private static int ticketStatic = 1;

  Object obj = new Object();

  Lock lock = new ReentrantLock();

  @Override
  public void run() {
    while (true) {
      lock.lock();
      if (ticket > 100) {
        lock.unlock();
        break;
      }
      System.out.println(Thread.currentThread().getName() + " " + ticket);
      ticket++;
      lock.unlock();

//      lock.lock();
//      if (ticket > 100) {
//        lock.unlock();
//        break;
//      }
//      try {
//        Thread.sleep(1);
//        System.out.println(Thread.currentThread().getName() + " " + ticket);
//        ticket++;
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      } finally {
//        lock.unlock();
//      }
    }
  }
//
//  @Override
//  public void run() {
//    while (true) {
////      synchronized (obj) {
////        if (ticket > 100) return;
////        System.out.println(Thread.currentThread().getName() + " " + ticket);
////        ticket++;
//////        try {
//////          Thread.sleep(10);
//////        } catch (InterruptedException e) {
//////          e.printStackTrace();
//////        }
////      }
////      payTicket();
//      payTicketStatic();
//    }
//  }

//  private synchronized void payTicket() {
//    if (ticket > 100) return;
//    System.out.println(Thread.currentThread().getName() + " " + ticket);
//    ticket++;
////    try {
////      Thread.sleep(1000);
////    } catch (InterruptedException e) {
////      e.printStackTrace();
////    }
//  }

  private void payTicket() {
    synchronized (this) {
      if (ticket > 100) return;
      System.out.println(Thread.currentThread().getName() + " " + ticket);
      ticket++;
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    }
  }

//  private static synchronized void payTicketStatic() {
//    if (ticketStatic > 100) return;
//    System.out.println(Thread.currentThread().getName() + " " + ticketStatic);
//    ticketStatic++;
////    try {
////      Thread.sleep(1000);
////    } catch (InterruptedException e) {
////      e.printStackTrace();
////    }
//  }

  private static void payTicketStatic() {
    synchronized (MyRunnable.class) {
      if (ticketStatic > 100) return;
      System.out.println(Thread.currentThread().getName() + " " + ticketStatic);
      ticketStatic++;
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    }
  }
}
