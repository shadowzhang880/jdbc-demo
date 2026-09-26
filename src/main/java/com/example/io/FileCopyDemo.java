package com.example.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo {
    public static void main(String[] args) {
        copyFile("source.jpg", "target.jpg");
    }

    /**
     * 字节流复制文件（适合所有类型文件）
     */
    public static void copyFile(String src, String dest) {
        long start = System.currentTimeMillis();

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[1024];  // 1KB 缓冲区
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("复制完成：" + src + " → " + dest);

        } catch (IOException e) {
            System.err.println("复制失败：" + e.getMessage());
        }

        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + " 毫秒");
    }
}