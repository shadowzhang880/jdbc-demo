package com.example.thread;

import java.util.concurrent.*;

public class ThreadDemo3 {
    public static void main(String[] args) throws Exception {
        Callable<Integer> task = ()->{
            int sum = 0;
            for (int i=0;i<=100;i++) {
                sum+=1;
            }
            return sum;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(task);
        Thread t = new Thread(futureTask);
        t.start();

        Integer result = futureTask.get();
        System.out.println("计算结果："+result);

    }
}
