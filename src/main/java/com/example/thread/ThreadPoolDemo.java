package com.example.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建固定大小线程池，最多 3 个线程
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 提交 10 个任务
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            pool.submit(() -> {
                System.out.println("任务 " + taskId + " 由 " +
                        Thread.currentThread().getName() + " 执行");
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            });
        }

        // 关闭线程池
        pool.shutdown();
    }
}
