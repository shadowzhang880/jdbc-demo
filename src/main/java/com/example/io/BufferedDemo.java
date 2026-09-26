package com.example.io;

import java.io.*;

public class BufferedDemo {
    public static void main(String[] args) {
        String fileName = "buffered_output.txt";

        // 1. 用 BufferedWriter 写文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("第一行：张三");
            writer.newLine();
            writer.write("第二行：李四");
            writer.newLine();
            writer.write("第三行：王五");
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 用 BufferedReader 读文件
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("文件内容：");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}