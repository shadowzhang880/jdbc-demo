package com.example.thread;

import java.awt.*;

class Mythread extends Thread {
    public  void run() {
        for (int i= 0;i<5;i++) {
            System.out.println("线程"+getName()+"执行"+i);
            try {
                Thread.sleep(500);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        Mythread t2 = new Mythread();
        t1.start();
        t2.start();
    }
}
