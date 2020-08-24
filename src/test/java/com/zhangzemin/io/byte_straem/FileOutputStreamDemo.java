package com.zhangzemin.io.byte_straem;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author zhangzemin
 * 文件字节输出流
 * @date 2020/4/1 19:26
 */
public class FileOutputStreamDemo {
    /**
     * 字节流写数据
     */
    @Test
    public void demo1(){
        //创建字节输出流对象
        //FileOutputStream(String name)：创建文件输出流以指定的名称写入文件
        try (FileOutputStream fos = new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\fos.txt"
                /*A:调用系统功能创建了文件
                 B:创建了字节输出流对
                 C:让字节输出流对象指向创建好的文件*/
        )){
            fos.write(97);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流写数据的3种方式
     */
    @Test
    public void demo2(){
        try(FileOutputStream fos = new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\fos.txt")){
//            fos.write(97);
//            fos.write(98);
//            fos.write(99);
//            fos.write(100);
//            byte[] bytes = {97,98,99,100,101};
//            fos.write(bytes);
            byte[] bytes1 = "abcdef".getBytes();
//            fos.write(bytes1);
            fos.write(bytes1,1,3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流写数据实现换行
     */
    @Test
    public void demo3(){
        try(FileOutputStream fos = new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\fos.txt")){
            byte[] bytes = "a\r\nbcdef".getBytes();
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流写数据实现追加写入
     */
    @Test
    public void demo4(){
        try(FileOutputStream fos = new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\fos.txt",true)){
            byte[] bytes = "a\r\nbcdef".getBytes();
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
