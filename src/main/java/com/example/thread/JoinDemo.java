package com.example.thread;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t =new Thread(()->{
            for (int i=0;i<3;i++) {
                System.out.println("子线程："+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        });
        t.start();
        t.join();
        System.out.println("主线程继续执行");
    }
}
