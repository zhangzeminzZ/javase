package com.zhangzemin.io.byte_straem;

import org.junit.Test;

import java.io.*;

/**
 * @author zhangzemin
 * 文件字节输入流
 * @date 2020/4/4 23:47
 */
public class FileInputStreamDemo {
    /**
     *字节流读数据(一次读一个字节数据)
     */
    @Test
    public void demo1() {
        //创建字节输入流对象
        try (FileInputStream fis = new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\fos.txt")) {
            int by;
            /*fis.read()：读数据
            by=fis.read()：把读取到的数据赋值给by
            by != -1：判断读取到的数据是否是-1*/
            while ((by = fis.read()) != -1) {
                System.out.println((char) by);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流读数据(一次读一个字节数组数据)
     */
    @Test
    public void demo2() {
        //创建字节输入流对象
        try (FileInputStream fis = new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\fos.txt")) {
            byte[] bys = new byte[1024];
            int len;
            /*hello\r\n
            world\r\n

            第一次：hello
            第二次：\r\nwor
            第三次：ld\r\nr*/
            while ((len = fis.read(bys)) != -1) {
                System.out.println(new String(bys, 0, len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流复制文本文件
     */
    @Test
    public void demo3() {
        try (FileInputStream fis = new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\fos.txt");
             FileOutputStream fos = new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\byte_straem\\fos.txt")) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流复制图片
     */
    @Test
    public void demo4() {
        try (
                //根据数据源创建字节输入流对象
                FileInputStream fis = new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\mn.jpg");
                //根据目的地创建字节输出流对象
                FileOutputStream fos = new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\byte_straem\\mn.jpg")) {

            //读写数据，复制图片(一次读取一个字节数组，一次写入一个字节数组)
            byte[] bys = new byte[1024];
            int len;
            while ((len = fis.read(bys)) != -1) {
                fos.write(bys, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
