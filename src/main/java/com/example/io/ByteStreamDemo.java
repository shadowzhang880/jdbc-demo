package com.example.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
    public static void main(String[] args) {
        // 1. 写入文件
        writeFile("output.txt", "Hello, 字节流！".getBytes());

        // 2. 读取文件
        readFile("output.txt");
    }

    /**
     * 用 FileOutputStream 写入字节
     */
    public static void writeFile(String fileName, byte[] data) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(data);
            System.out.println("写入成功，共 " + data.length + " 字节");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用 FileInputStream 读取字节
     */
    public static void readFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int b;
            System.out.print("文件内容：");
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}