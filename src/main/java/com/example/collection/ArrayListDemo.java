package com.example.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("孙七");
        System.out.println("初始集合："+list);

        // 2. 遍历打印：普通 for 循环
        System.out.println("\n普通 for 循环遍历：");
        for (int i=0;i<list.size();i++){
            System.out.println("索引"+i+":"+list.get(i));
        }

        // 2. 遍历打印：增强 for 循环
        System.out.println("\n增强 for 循环遍历：");
        for (String name : list){
            System.out.println(name);
        }

        list.remove(2);
        System.out.println("删除第二个元素后为："+list);

        //判断是否包含李四
        boolean iscontain = list.contains("李四");
        System.out.println("\n是否包含李四"+iscontain);

        boolean iscontainwang = list.contains("王五");
        System.out.println("是否包含王五："+iscontainwang);

        list.clear();
        System.out.println("清空集合后为："+list);
        System.out.println("几何是否为空"+list.isEmpty());
    }
}
