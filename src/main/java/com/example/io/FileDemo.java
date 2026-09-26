package com.example.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        // 1. 创建 File 对象
        File file = new File("test.txt");

        // 2. 判断是否存在
        System.out.println("文件是否存在：" + file.exists());

        // 3. 创建文件
        if (!file.exists()) {
            boolean created = file.createNewFile();
            System.out.println("创建文件：" + created);
        }

        // 4. 获取文件信息
        System.out.println("文件名：" + file.getName());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("文件大小：" + file.length() + " 字节");
        System.out.println("是文件吗：" + file.isFile());
        System.out.println("是目录吗：" + file.isDirectory());

        // 5. 创建目录
        File dir = new File("testDir");
        if (!dir.exists()) {
            boolean mk = dir.mkdirs();
            System.out.println("创建目录：" + mk);
        }

        // 6. 遍历目录
        File currentDir = new File(".");
        File[] files = currentDir.listFiles();
        System.out.println("\n当前目录下的文件：");
        if (files != null) {
            for (File f : files) {
                System.out.println((f.isDirectory() ? "[目录] " : "[文件] ") + f.getName());
            }
        }

        // 7. 删除文件
        // file.delete();
    }
}