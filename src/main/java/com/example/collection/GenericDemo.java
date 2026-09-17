package com.example.collection;

class Box<T> {
    private T content;
    public void set(T content){
        this.content = content;
    }
    public T get(){
        return content;
    }

}

public class GenericDemo {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        String s = stringBox.get();
        System.out.println("String 类型："+s);

        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        Integer n = intBox.get();
        System.out.println("Integer 类型："+n);

        String[] names = {"张三","李四","王五"};
        System.out.println("\n字符串数组：");
        printArray(names);

        Integer[] nums = {1,2,3,4,5};
        System.out.println("\n整数数组：");
        printArray(nums);
    }

    public static <T> void  printArray(T[] arr){
        for(T item : arr){
            System.out.println(item);
        }
    }
}
