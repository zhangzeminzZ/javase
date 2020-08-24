package com.zhangzemin.io.specific_stream;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * 标准输入输出流
 * @author zhangzemin
 * @date 2020/4/14 10:24
 */
public class StandardInputOutputStreamDemo {
    /**
     * 自己实现键盘录入数据
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符串:");
        String line = br.readLine();
        System.out.println("你输入的字符串是:"+line);

        //自己实现键盘录入数据太麻烦了，所以Java就提供了一个类供我们使用
        /*Scanner sc = new Scanner(System.in);
        System.out.println("x:");
        int x = sc.nextInt();//输入为整数
        System.out.println("你输入的数据是："+x);*/
    }

    /**
     * 标准输出流
     */
    @Test
    public void demo1(){
        PrintStream ps = System.out;
        ps.print("hello");

        //System.out的本质是一个字节输出流
        System.out.println("hello");
    }
}
