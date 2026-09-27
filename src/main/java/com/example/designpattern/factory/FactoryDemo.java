package com.example.designpattern.factory;

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("画圆"); }
}

class Rectangle implements Shape {
    public void draw() { System.out.println("画矩形"); }
}

class ShapeFactory {
    public static Shape create(String type) {
        if ("circle".equals(type)) return new Circle();
        if ("rectangle".equals(type)) return new Rectangle();
        throw new IllegalArgumentException("未知类型：" + type);
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        Shape s1 = ShapeFactory.create("circle");
        s1.draw();

        Shape s2 = ShapeFactory.create("rectangle");
        s2.draw();
    }
}