package com.zhangzemin.io.decorator;

/**
 * @author zhangzemin
 * @date 2020/3/31 12:55
 */
public class Test {
    public static void main(String[] args) {
        Human person = new Person();
        Decorator decorator = new Decorator_two(new Decorator_first(new Decorator_zero(person)));
        decorator.wearClothes();
        decorator.walkToWhere();
    }
}
