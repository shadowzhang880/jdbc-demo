package com.example.designpattern.singleton;

/**
 * 饿汉式单例：类加载时就创建实例
 */
class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    public void sayHello() {
        System.out.println("我是饿汉式单例：" + this.hashCode());
    }
}

/**
 * 懒汉式单例：双重检查 + volatile
 */
class Singleton2 {
    private static volatile Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

    public void sayHello() {
        System.out.println("我是懒汉式单例：" + this.hashCode());
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        // 饿汉式
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();
        s1.sayHello();
        s2.sayHello();
        System.out.println("饿汉式是否是同一对象：" + (s1 == s2));

        // 懒汉式
        Singleton2 s3 = Singleton2.getInstance();
        Singleton2 s4 = Singleton2.getInstance();
        s3.sayHello();
        s4.sayHello();
        System.out.println("懒汉式是否是同一对象：" + (s3 == s4));
    }
}