package com.example.thread;

public class TicketDemo {
    private static int tickets = 100;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Runnable sell = ()->{
          while (true) {
              synchronized (lock) {
                  if (tickets<=0) {
                      break;
                  }
                  System.out.println(Thread.currentThread().getName()+"卖出第"+tickets+"张票");
                  tickets--;
              }
              try {
                  Thread.sleep(50);
              }catch (InterruptedException e) {}
          }
        };

        new Thread(sell,"窗口1").start();
        new Thread(sell,"窗口2").start();
        new Thread(sell,"窗口3").start();
    }
}
