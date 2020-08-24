package com.zhangzemin.vessel.iterator;

/**
 * @author zhangzemin
 * @date 2020/4/21 13:30
 */
public class Person {
    private String name;
    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
