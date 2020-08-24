package com.zhangzemin.io.decorator;

/**
 * @author zhangzemin
 * @date 2020/3/31 12:46
 */
public abstract  class Decorator implements  Human{
    private Human human;

    public Decorator(Human human){
        this.human = human;
    }
    public void wearClothes(){
        human.wearClothes();
    }

    public void walkToWhere() {
        human.walkToWhere();
    }
}
