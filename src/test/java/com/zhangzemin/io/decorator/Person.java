package com.zhangzemin.io.decorator;

/**
 * @author zhangzemin
 * @date 2020/3/31 12:55
 */
public class Person implements Human{
    @Override
    public void wearClothes() {
        // TODO Auto-generated method stub
        System.out.println("穿什么呢。。");
    }

    @Override
    public void walkToWhere() {
        // TODO Auto-generated method stub
        System.out.println("去哪里呢。。");
    }
}
