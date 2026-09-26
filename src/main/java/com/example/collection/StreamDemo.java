package com.example.collection;

import java.util.*;
import java.util.stream.Collectors;
import com.example.student.model.Student;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("张三", "李四", "王五", "赵六", "孙七", "周八");

        // ========== 1. filter：过滤 ==========
        System.out.println("===== filter =====");
        List<String> result1 = names.stream()
                .filter(name -> name.startsWith("张"))
                .collect(Collectors.toList());
        System.out.println("姓张的：" + result1);

        // ========== 2. map：转换 ==========
        System.out.println("\n===== map =====");
        List<Integer> lengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("每个名字的长度：" + lengths);

        // ========== 3. sorted：排序 ==========
        System.out.println("\n===== sorted =====");
        List<String> sorted = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("排序后：" + sorted);

        // ========== 4. count：计数 ==========
        System.out.println("\n===== count =====");
        long count = names.stream()
                .filter(name -> name.length() == 2)
                .count();
        System.out.println("长度为2的名字个数：" + count);

        // ========== 5. distinct：去重 ==========
        System.out.println("\n===== distinct =====");
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        List<Integer> distinct = nums.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("去重后：" + distinct);

        // ========== 6. 链式操作 ==========
        System.out.println("\n===== 链式操作 =====");
        List<String> chain = names.stream()
                .filter(name -> name.length() >= 2)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("过滤+转换+排序：" + chain);

        // ========== 7. groupingBy：分组 ==========
        System.out.println("\n===== groupingBy =====");
        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("按名字长度分组：" + grouped);

        // ========== 8. 对对象集合操作 ==========
        System.out.println("\n===== 对对象集合操作 =====");
        List<Student> students = Arrays.asList(
                new Student(1, "张三", 20, "软件技术", 1),
                new Student(2, "李四", 21, "计算机应用", 1),
                new Student(3, "王五", 19, "软件技术", 2),
                new Student(4, "赵六", 22, "网络工程", 2)
        );

        // 筛选软件技术专业
        List<Student> softStudents = students.stream()
                .filter(s -> "软件技术".equals(s.getMajor()))
                .collect(Collectors.toList());
        System.out.println("软件技术专业：" + softStudents);

        // 按专业分组
        Map<String, List<Student>> byMajor = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor));
        System.out.println("按专业分组：" + byMajor);

        // 统计每个专业人数
        Map<String, Long> majorCount = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor, Collectors.counting()));
        System.out.println("每个专业人数：" + majorCount);
    }
}