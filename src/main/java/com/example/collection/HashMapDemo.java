package com.example.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String,Integer> students = new HashMap<>();
        students.put("张三", 20);
        students.put("李四", 21);
        students.put("王五", 19);
        students.put("赵六", 22);
        students.put("孙七", 20);
        System.out.println("初始集合：" + students);

        int liAge = students.get("李四");
        System.out.println("\n李四的年龄为："+liAge);

        // 3. 遍历所有键值对
        System.out.println("\n遍历所有键值对：");
        for (Map.Entry<String,Integer> entry : students.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
        //判断是否包含某个键
        System.out.println("\n是否包含王五"+students.containsKey("王五"));
        System.out.println("\n是否包含周八"+ students.containsKey("周八"));

        //删除一个键
        students.remove("赵六");
        System.out.println("\n删除赵六后："+students);

        //打印集合大小
        System.out.println("当前集合大小："+students.size());
    }
}
