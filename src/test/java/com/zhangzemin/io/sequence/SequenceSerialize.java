package com.zhangzemin.io.sequence;

import org.junit.Test;

import java.io.*;

/**
 * @author zhangzemin
 * @date 2020/3/31 15:26
 */
public class SequenceSerialize {
    /**
     * 序列化
     */
    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("d:"+File.separator+"demoA.txt")));
            Person p = new Person("zhangzemin","111",18);
            oos.writeObject(p);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 反序列化
     */
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("d:"+File.separator+"demoA.txt")));
            Object object = ois.readObject();
            Person p = (Person) object;
            System.out.println(p.getName());
            System.out.println(p.getId());
            System.out.println(p.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
