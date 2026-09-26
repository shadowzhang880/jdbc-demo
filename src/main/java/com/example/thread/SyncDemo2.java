package com.example.thread;

public class SyncDemo2 {
    private static int count = 0;

    // 同步静态方法，锁是当前类的 Class 对象
    public static synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("最终 count = " + count);  // 20000
    }
}
