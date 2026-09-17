package com.example.collection;

// 1. 自定义异常：继承 RuntimeException
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {
        // 2. 演示 try-catch-finally
        System.out.println("===== try-catch-finally 演示 =====");
        try {
            int result = 10 / 0;  // 会抛 ArithmeticException
            System.out.println("这行不会执行");
        } catch (ArithmeticException e) {
            System.out.println("捕获到算术异常：" + e.getMessage());
        } finally {
            System.out.println("finally 块一定会执行");
        }

        // 3. 演示多个 catch
        System.out.println("\n===== 多个 catch 演示 =====");
        try {
            String str = null;
            System.out.println(str.length());  // NullPointerException
        } catch (ArithmeticException e) {
            System.out.println("算术异常");
        } catch (NullPointerException e) {
            System.out.println("捕获到空指针异常：" + e.getMessage());
        } catch (Exception e) {
            System.out.println("其他异常");
        }

        // 4. 演示 throw 和自定义异常
        System.out.println("\n===== 自定义异常演示 =====");
        try {
            checkAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("捕获到自定义异常：" + e.getMessage());
        }

        try {
            checkAge(20);
            System.out.println("年龄合法");
        } catch (InvalidAgeException e) {
            System.out.println("捕获到自定义异常：" + e.getMessage());
        }
    }

    // 5. 使用 throw 抛出自定义异常
    public static void checkAge(int age) {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("年龄不合法：" + age);
        }
    }
}