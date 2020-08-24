package com.zhangzemin.vessel.iterator;
import org.junit.Test;

import java.util.*;

/**
 * @author zhangzemin
 * @date 2020/4/20 9:22
 */
public class IteratorDemo {
    @Test
    public void demo01(){
        List<String> list = new ArrayList<>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        list.add("str4");
        list.add("str5");
        list.add("str6");
        list.add("str7");
        list.add("str8");

        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            list.add("11");
        }

        Map map = new HashMap<>();
    }

    @Test
    public void demo02(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("p1"));
        list.add(new Person("p2"));
        list.add(new Person("p3"));
        Iterator<Person> iterator = list.iterator();

        for(Person p : list){
            System.out.println(p);
        }

        for(Person p : list){
            p.setName("p");
        }

        while (iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }

    }

    @Test
    public void demo03(){
        Map map = new HashMap();
        for(int i = 0; i < 10; i++){
            map.put(i,String.valueOf("map"+i));
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry strmap = (Map.Entry) iterator.next();
            System.out.println("key为:"+strmap.getKey()+",value为:"+strmap.getValue());
        }
    }
}
