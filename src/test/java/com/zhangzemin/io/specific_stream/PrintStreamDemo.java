package com.zhangzemin.io.specific_stream;

import org.junit.Test;

import java.io.*;

/**
 * 打印流
 * @author zhangzemin
 * @date 2020/4/14 10:55
 */
public class PrintStreamDemo {
    @Test
    public void demo1(){
        //PrintStream(String fileName)：使用指定的文件名创建新的打印流
        try(PrintStream ps = new PrintStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\specific_stream\\ps.txt");){
            //写数据
            //字节输出流有的方法
            //ps.write(97);

            //使用特有方法写数据
            ps.print(97);
            ps.print(98);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo2(){
        //PrintWriter(String fileName) ：使用指定的文件名创建一个新的PrintWriter，而 不需要自动执行行刷新
        try(PrintWriter pw = new PrintWriter("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\specific_stream\\pw.txt");
            //PrintWriter(Writer out, boolean autoFlush)：创建一个新的PrintWriter
            PrintWriter pw1 = new PrintWriter(new FileWriter("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\specific_stream\\pw1.txt"),true)){
            /*pw.write("hello");
            pw.write("\r\n");
            pw.flush();
            pw.write("world");*/

            pw1.println("hello");
            pw1.println("world");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
