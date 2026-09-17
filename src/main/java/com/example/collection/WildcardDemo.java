package com.example.collection;

import java.util.ArrayList;
import java.util.List;

public class WildcardDemo {
    public static void main(String[] args) {
        // ========== 1. ? extends Number：可以接收 Number 及其子类的 List ==========
        System.out.println("===== ? extends Number 演示 =====");

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);

        System.out.println("Integer 列表：");
        printNumbers(intList);

        System.out.println("Double 列表：");
        printNumbers(doubleList);

        // ========== 2. ? super Integer：可以接收 Integer 及其父类的 List ==========
        System.out.println("\n===== ? super Integer 演示 =====");

        List<Integer> intList2 = new ArrayList<>();
        addNumbers(intList2);
        System.out.println("List<Integer> 添加后：" + intList2);

        List<Number> numberList = new ArrayList<>();
        addNumbers(numberList);
        System.out.println("List<Number> 添加后：" + numberList);

        List<Object> objectList = new ArrayList<>();
        addNumbers(objectList);
        System.out.println("List<Object> 添加后：" + objectList);
    }

    /**
     * 接收 Number 及其子类的 List
     * 可以读取，但不能添加（除了 null）
     */
    public static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

    /**
     * 接收 Integer 及其父类的 List
     * 可以添加 Integer，但读取只能当作 Object
     */
    public static void addNumbers(List<? super Integer> list) {
        list.add(100);
        list.add(200);
    }
}