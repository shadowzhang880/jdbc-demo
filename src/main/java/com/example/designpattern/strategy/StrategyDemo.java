package com.example.designpattern.strategy;

/**
 * 折扣策略接口
 */
interface DiscountStrategy {
    double discount(double price);
}

/**
 * 无折扣
 */
class NoDiscount implements DiscountStrategy {
    @Override
    public double discount(double price) {
        return price;
    }
}

/**
 * 9 折
 */
class TenPercentDiscount implements DiscountStrategy {
    @Override
    public double discount(double price) {
        return price * 0.9;
    }
}

/**
 * 8 折
 */
class TwentyPercentDiscount implements DiscountStrategy {
    @Override
    public double discount(double price) {
        return price * 0.8;
    }
}

/**
 * 上下文：持有策略，调用策略计算
 */
class PriceContext {
    private DiscountStrategy strategy;

    public PriceContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double finalPrice(double price) {
        return strategy.discount(price);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        double price = 100.0;

        // 无折扣
        PriceContext ctx1 = new PriceContext(new NoDiscount());
        System.out.println("普通用户：" + ctx1.finalPrice(price));

        // 9 折
        PriceContext ctx2 = new PriceContext(new TenPercentDiscount());
        System.out.println("VIP 用户：" + ctx2.finalPrice(price));

        // 8 折
        PriceContext ctx3 = new PriceContext(new TwentyPercentDiscount());
        System.out.println("SVIP 用户：" + ctx3.finalPrice(price));

        // 动态切换策略
        PriceContext ctx = new PriceContext(new NoDiscount());
        System.out.println("默认：" + ctx.finalPrice(price));

        ctx = new PriceContext(new TwentyPercentDiscount());
        System.out.println("切换后：" + ctx.finalPrice(price));
    }
}