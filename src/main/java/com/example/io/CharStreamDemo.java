package com.example.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo {
    public static void main(String[] args) {
        // 1. 写入文本
        writeText("char_output.txt", "你好，字符流！\nHello, Character Stream!");

        // 2. 读取文本
        readText("char_output.txt");
    }

    public static void writeText(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readText(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
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