package com.example.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyTest {
}

class TestCase {
    @MyTest
    public void test1() {
        System.out.println("执行 test1");
    }

    public void test2() {
        System.out.println("执行 test2（没有注解，不执行）");
    }

    @MyTest
    public void test3() {
        System.out.println("执行 test3");
    }
}

public class AnnotationReflectDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = TestCase.class;
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)) {
                method.invoke(obj);
            }
        }
    }
}