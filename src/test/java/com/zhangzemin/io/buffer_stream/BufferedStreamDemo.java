package com.zhangzemin.io.buffer_stream;

import org.junit.Test;

import java.io.*;

/**
 * 字节缓冲流
 * @author zhangzemin
 * @date 2020/4/13 12:29
 */
public class BufferedStreamDemo {
    /**
     * 字节缓冲输出流写数据
     */
    @Test
    public void demo1(){
        //字节缓冲输出流：BufferedOutputStream(OutputStream out)
        try(BufferedOutputStream bos  = new BufferedOutputStream(new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\buffer_stream\\bos.txt"))){
            bos.write("hello\r\n".getBytes());
            bos.write("world\r\n".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 字节缓冲输出流读数据
     */
    @Test
    public void demo2(){
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\buffer_stream\\bos.txt"))){
            byte[] bytes = new byte[1024];
            int len;
            while((len = bis.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 不同方式读写数据性能比较
     */
    @Test
    public void demo3(){
        //记录开始时间
        long startTime = System.currentTimeMillis();

        //基本字节流一次读写一个字节
        //method01();

        //基本字节流一次读写一个字节数组
        //method02();

        //字节缓冲流一次读写一个字节
        //method03();

        //字节缓冲流一次读写一个字节数组
        method04();

        //记录结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("共耗时:"+(endTime-startTime)+"毫秒");
    }

    /**
     * 字节缓冲流一次读写一个字节数组
     */
    public void method04(){
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\shiping.mp4"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\buffer_stream\\shiping.mp4"))){
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节缓冲流一次读写一个字节
     */
    public void method03(){
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\shiping.mp4"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\buffer_stream\\shiping.mp4"))){
            int by;
            while ((by = bis.read()) != -1){
                bos.write(by);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基本字节流一次读写一个字节数组
     */
    public void method02(){
        try(FileInputStream fis = new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\shiping.mp4");
            FileOutputStream fos = new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\buffer_stream\\shiping.mp4")){

            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基本字节流一次读写一个字节
     */
    public void method01(){
        try(FileInputStream fis = new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\shiping.mp4");
            FileOutputStream fos = new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\buffer_stream\\shiping.mp4")){

            int by;
            while((by = fis.read()) != -1){
                fos.write(by);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
