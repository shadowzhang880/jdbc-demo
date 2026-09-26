package com.example.io;

import java.io.*;

public class ConvertStreamDemo {
    public static void main(String[] args) {
        String fileName = "utf8_output.txt";

        // 1. 用 OutputStreamWriter 指定 UTF-8 写文件
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(fileName), "UTF-8")) {
            writer.write("UTF-8 编码的内容：你好世界");
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 用 InputStreamReader 指定 UTF-8 读文件
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(fileName), "UTF-8")) {
            int c;
            System.out.print("文件内容：");
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}