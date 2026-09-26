package com.example.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        // ========== 1. Runnable：匿名内部类 vs Lambda ==========
        System.out.println("===== Runnable =====");

        // 匿名内部类
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类方式");
            }
        };
        r1.run();

        // Lambda 写法
        Runnable r2 = () -> System.out.println("Lambda 方式");
        r2.run();

        // ========== 2. Comparator：排序 ==========
        System.out.println("\n===== Comparator =====");
        List<String> list = new ArrayList<>();
        list.add("banana");
        list.add("apple");
        list.add("cherry");

        // 匿名内部类排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("匿名内部类排序：" + list);

        // Lambda 排序
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
        System.out.println("Lambda 排序：" + list);

        // 更简洁：方法引用
        Collections.sort(list, String::compareTo);
        System.out.println("方法引用排序：" + list);

        // ========== 3. 自定义函数式接口 ==========
        System.out.println("\n===== 自定义函数式接口 =====");

        // 定义在类外部或用内部接口，这里用 Lambda 直接实现
        Calculator add = (a, b) -> a + b;
        Calculator sub = (a, b) -> a - b;

        System.out.println("10 + 5 = " + add.calc(10, 5));
        System.out.println("10 - 5 = " + sub.calc(10, 5));
    }

    // 自定义函数式接口
    @FunctionalInterface
    interface Calculator {
        int calc(int a, int b);
    }
}