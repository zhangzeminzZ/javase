package com.zhangzemin.io.character_stream;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * 字符流
 * @author zhangzemin
 * @date 2020/4/13 17:03
 */
public class Demo {
    /**
     * 字符串中的编码解码
     * @throws UnsupportedEncodingException
     */
    @Test
    public void demo1() throws UnsupportedEncodingException {
        String s = "中国";
        byte[] bytes1 = s.getBytes();//[-28, -72, -83, -27, -101, -67]
        byte[] bytes2 = s.getBytes("UTF-8");//[-28, -72, -83, -27, -101, -67]
        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes2));

        String s1 = new String(bytes1);
        System.out.println(s1);//中国

        String s2 = new String(bytes1,"UTF-8");
        System.out.println(s2);//中国
    }

    /**
     * 字符流中的编码解码
     */
    @Test
    public void demo2(){
        try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\character_stream\\osw.txt"),"UTF-8");
            InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\character_stream\\osw.txt"),"UTF-8")){
            osw.write("中国");
            osw.flush();
            int ch;
            while ((ch=isr.read()) != -1){
                System.out.println((char)ch);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流写数据的5种方式
     */
    @Test
    public void demo3(){
        try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\character_stream\\osw.txt"))){
            //void write(int c)：写一个字符
            //osw.write(97);
            //osw.write(98);
            //osw.write(99);

            //void writ(char[] cbuf)：写入一个字符数组
            char[] chs = {'a','b','c','d','e'};
            //osw.write(chs);

            //void write(char[] cbuf, int off, int len)：写入字符数组的一部分
            //osw.write(chs,0,chs.length);
            //osw.write(chs,1,3);

            //void write(String str)：写一个字符串
            //osw.write("abcde");

            //void write(String str, int off, int len)：写一个字符串的一部分
            //osw.write("abcde", 0, "abcde".length());
            osw.write("abcde",1,3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流读数据的两种方式
     */
    @Test
    public void demo4(){
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\character_stream\\osw.txt"));){
            //int read()：一次读一个字符数据
            /*int ch;
            while((ch=isr.read()) != -1){
                System.out.println((char)ch);
            }*/

            //int read(char[] cbuf)：一次读一个字符数组数据
            char[] chs = new char[1024];
            int len;
            while((len = isr.read()) != -1){
                System.out.println(new String(chs,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流复制Java文件
     */
    @Test
    public void demo5(){
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\copy.java"));
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\character_stream\\copy1.java"))){
            char[] chs = new char[1024];
            int len;
            while((len=isr.read(chs)) != -1){
                osw.write(chs,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流复制Java文件改进版
     */
    @Test
    public void demo6(){
        //根据数据源创建字符输入流对象
        try(FileReader fr = new FileReader("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\copy.java");
            FileWriter fw = new FileWriter("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\character_stream\\copy2.java")){
            char[] chs = new char[1024];
            int len;
            while((len = fr.read(chs)) != -1){
                fw.write(chs,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 字符缓冲流
     */
    @Test
    public void demo7(){
        //BufferedWriter(Writer out)
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\character_stream\\bw.txt"));
            //BufferedReader(Reader in)
            BufferedReader br = new BufferedReader(new FileReader("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\character_stream\\bw.txt"))){
            bw.write("hello\r\n");
            bw.write("world\r\n");
            bw.flush();
            char[] chs = new char[1024];
            int len;
            while((len = br.read(chs)) != -1){
                System.out.println(new String(chs,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符缓冲流特有功能
     */
    @Test
    public void demo8(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\character_stream\\bw.txt"));
            BufferedReader br = new BufferedReader(new FileReader("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\character_stream\\bw.txt"))){
            for(int i = 0;i < 10; i++){
                bw.write("hello"+i);
                bw.newLine();
                bw.flush();
            }

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
