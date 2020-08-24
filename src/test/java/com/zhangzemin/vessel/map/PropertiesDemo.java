package com.zhangzemin.vessel.map;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Properties集合
 * @author zhangzemin
 * @date 2020/4/14 11:19
 */
public class PropertiesDemo {

    /**
     * Properties作为Map集合的使用
     */
    @Test
    public void demo1(){
        //创建集合对象
        Properties prop = new Properties();

        //存储元素
        prop.put("01","1");
        prop.put("02","2");
        prop.put("03","3");

        Set<Object> keySet = prop.keySet();
        for(Object key : keySet){
            Object value = prop.get(key);
            System.out.println(key+":"+value);
        }
        
    }

    /**
     * Properties作为Map集合的特有方法
     */
    @Test
    public void demo2(){
        //创建集合对象
        Properties prop = new Properties();
        //Object setProperty(String key, String value)：设置集合的键和值，都是 String类型，底层调用Hashtable方法put
        prop.setProperty("01","1");
        prop.setProperty("02","2");
        prop.setProperty("03","3");

        //String getProperty(String key)：使用此属性列表中指定的键搜索属性
        System.out.println(prop.getProperty("01"));
        System.out.println(prop.getProperty("02"));

        System.out.println(prop);

        //Set<String> stringPropertyNames()：从该属性列表中返回一个不可修改的键集，其中 键及其对应的值是字符串
        Set<String> names = prop.stringPropertyNames();
        for(String key : names){
            String value = prop.getProperty(key);
            System.out.println(key+":"+value);

        }
    }


    @Test
    public void demo3(){
        //myStore();//把集合中的数据保存到文件
        myLoad();//把文件中的数据加载到集合
    }

    /**
     * 把集合中的数据保存到文件
     */
    private void myStore(){
        Properties prop = new Properties();
        prop.setProperty("01","1");
        prop.setProperty("02","2");
        prop.setProperty("03","3");

        //void store(Writer writer, String comments)
        try(FileWriter fw = new FileWriter("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\vessel\\map\\fw.txt")){
            prop.store(fw,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 把文件中的数据加载到集合
     */
    private void myLoad(){
        Properties prop = new Properties();
        try(FileReader fr = new FileReader("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\vessel\\map\\fw.txt")){
            prop.load(fr);
            System.out.println(prop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
