package com.example.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class InvalidNameException extends RuntimeException {
    public InvalidNameException(String message) {
        super(message);
    }
}
class InvalidAgeException extends  RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionPractice {
    public static void main(String[] args) {
        // ========== 测试 validateStudent ==========
        System.out.println("===== 测试 validateStudent =====");

        // 合法输入
        try {
            validateStudent("张三", 20);
            System.out.println("校验通过：张三, 20");
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("校验失败：" + e.getMessage());
        }

        // 姓名太短
        try {
            validateStudent("张", 20);
            System.out.println("校验通过：张, 20");
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("校验失败：" + e.getMessage());
        }

        // 姓名为空
        try {
            validateStudent("", 20);
            System.out.println("校验通过：空, 20");
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("校验失败：" + e.getMessage());
        }

        // 年龄不合法
        try {
            validateStudent("李四", -5);
            System.out.println("校验通过：李四, -5");
        } catch (InvalidNameException | InvalidAgeException e) {
            System.out.println("校验失败：" + e.getMessage());
        }

        // ========== 测试 try-with-resources ==========
        System.out.println("\n===== 测试 try-with-resources =====");
        readFile("test.txt");
    }
    public static void validateStudent(String name,int age) {
        if(name == null || name.trim().length()<2) {
            throw new InvalidNameException("姓名不合法："+name);
        }
        if(age<0 ||age>150 ) {
            throw new InvalidAgeException("年龄不合法："+age);
        }
    }

    public static void readFile(String filename) {

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null ) {
                System.out.println(line);
            }
        }catch (IOException e) {
            System.out.println("读取文件失败："+e.getMessage());
        }
    }
}
