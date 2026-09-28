package com.example.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("你好，我是 " + name + "，今年 " + age + " 岁");
    }

    private void secret() {
        System.out.println("这是一个私有方法");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // 1. 获取 Class 对象
        Class<?> clazz = Class.forName("com.example.reflect.Person");
        System.out.println("类名：" + clazz.getName());

        // 2. 用无参构造创建对象
        Object obj1 = clazz.getDeclaredConstructor().newInstance();
        System.out.println("无参创建：" + obj1);

        // 3. 用有参构造创建对象
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        Object obj2 = constructor.newInstance("张三", 20);
        System.out.println("有参创建：" + obj2);

        // 4. 调用 public 方法
        Method sayHello = clazz.getDeclaredMethod("sayHello");
        sayHello.invoke(obj2);

        // 5. 访问私有字段
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println("私有字段 name：" + nameField.get(obj2));
        nameField.set(obj2, "李四");
        sayHello.invoke(obj2);

        // 6. 调用私有方法
        Method secret = clazz.getDeclaredMethod("secret");
        secret.setAccessible(true);
        secret.invoke(obj2);
    }
}