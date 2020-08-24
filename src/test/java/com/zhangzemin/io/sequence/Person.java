package com.zhangzemin.io.sequence;

import java.io.Serializable;

/**
 * @author zhangzemin
 * @date 2020/3/31 15:29
 */
public class Person implements Serializable {
    private String id;
    private String name;
    private Integer age;
    public Person(String id,String name,Integer age){
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
