package com.example.collection;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;

public class SetMapDemo {
    public static void main(String[] args) {
        // ========== 1. HashSet 去重演示 ==========
        System.out.println("===== HashSet 去重演示 =====");
        Set<String> set = new HashSet<>();
        set.add("张三");
        set.add("李四");
        set.add("王五");
        set.add("张三");  // 重复，不会添加
        set.add("李四");  // 重复，不会添加

        System.out.println("HashSet 内容：" + set);
        System.out.println("元素个数：" + set.size());
        System.out.println("是否包含“张三”：" + set.contains("张三"));
        System.out.println("是否包含“周八”：" + set.contains("周八"));

        // ========== 2. TreeMap 排序演示 ==========
        System.out.println("\n===== TreeMap 排序演示 =====");
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("张三", 20);
        treeMap.put("李四", 21);
        treeMap.put("王五", 19);
        treeMap.put("赵六", 22);
        treeMap.put("孙七", 20);

        System.out.println("TreeMap 内容：" + treeMap);
        System.out.println("遍历（按键排序）：");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ========== 3. LinkedHashMap 插入顺序演示 ==========
        System.out.println("\n===== LinkedHashMap 插入顺序演示 =====");
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put("张三", 20);
        linkedMap.put("李四", 21);
        linkedMap.put("王五", 19);
        linkedMap.put("赵六", 22);
        linkedMap.put("孙七", 20);

        System.out.println("LinkedHashMap 内容：" + linkedMap);
        System.out.println("遍历（按插入顺序）：");
        for (Map.Entry<String, Integer> entry : linkedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}