package com.example.thread;

public class DownloadDemo {
    public static void main(String[] args) {
        String[] files = {"文件A","文件B","文件C"};

        for (String file : files) {
            new Thread(()->{
                for (int i=0;i<=5;i++) {
                    System.out.println(file+"下载进度"+(i*20)+"%");
                    try {Thread.sleep(300);}catch (InterruptedException e) {}
                }
                System.out.println(file+"下载进度");
            }).start();
        }
    }
}
