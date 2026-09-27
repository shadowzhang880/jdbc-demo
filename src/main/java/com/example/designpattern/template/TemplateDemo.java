package com.example.designpattern.template;

/**
 * 抽象父类：定义游戏流程模板
 */
abstract class Game {
    // 抽象步骤，由子类实现
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // 模板方法：定义固定流程，用 final 修饰，子类不能改
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

/**
 * 板球游戏
 */
class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("板球游戏初始化");
    }

    @Override
    void startPlay() {
        System.out.println("板球游戏开始");
    }

    @Override
    void endPlay() {
        System.out.println("板球游戏结束");
    }
}

/**
 * 足球游戏
 */
class Football extends Game {
    @Override
    void initialize() {
        System.out.println("足球游戏初始化");
    }

    @Override
    void startPlay() {
        System.out.println("足球游戏开始");
    }

    @Override
    void endPlay() {
        System.out.println("足球游戏结束");
    }
}

public class TemplateDemo {
    public static void main(String[] args) {
        System.out.println("===== 板球 =====");
        Game cricket = new Cricket();
        cricket.play();

        System.out.println("\n===== 足球 =====");
        Game football = new Football();
        football.play();
    }
}