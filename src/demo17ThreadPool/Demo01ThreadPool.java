package demo17ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01ThreadPool {
  public static void main(String[] args) {

//    new Thread(new ThreadPool()).start();

    ExecutorService es = Executors.newFixedThreadPool(2);
    es.submit(new ThreadPool());
    es.submit(new ThreadPool());
    es.submit(new ThreadPool());

//    es.shutdown();
  }
}
