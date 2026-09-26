package com.example.io;

import java.io.*;

// 要实现序列化的类，必须实现 Serializable
class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class SerializableDemo {
    public static void main(String[] args) {
        String fileName = "person.dat";

        // 1. 序列化：对象 → 文件
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            Person p = new Person("张三", 20);
            oos.writeObject(p);
            System.out.println("序列化成功：" + p);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 反序列化：文件 → 对象
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName))) {
            Person p = (Person) ois.readObject();
            System.out.println("反序列化成功：" + p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}