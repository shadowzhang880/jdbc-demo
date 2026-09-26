package com.example.thread;

import java.util.concurrent.locks.Lock;

public class AlternatePrint {
    private static final Object lock = new Object();
    private static int num = 1;

    public static void main(String[] args) {
        Runnable task =()->{
            while (true) {
                synchronized (lock) {
                    if(num>10) break;
                    System.out.println(Thread.currentThread().getName()+":"+num++);
                    lock.notify();
                    try {
                        if (num<=10) lock.wait();
                    }catch (InterruptedException e) {}
                }
            }
        };

        new Thread(task,"线程A").start();
        new Thread(task,"线程B").start();
    }
}
