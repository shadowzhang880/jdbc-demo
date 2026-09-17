package com.example.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        // 1. 用 LinkedList 创建集合
        List<String> list = new LinkedList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("孙七");
        System.out.println("初始集合：" + list);

        // 2. 修改第一个元素
        list.set(0, "小明");
        System.out.println("修改后：" + list);

        // 3. 排序
        Collections.sort(list);
        System.out.println("排序后：" + list);

        // 4. 删除第 3 个元素
        list.remove(2);
        System.out.println("删除后：" + list);

        // 5. 判断包含
        System.out.println("是否包含“李四”：" + list.contains("李四"));
    }
}