package com.zhangzemin.io.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 文件
 * @author zhangzemin
 * @date 2020/3/25 22:46
 */
public class FileDemo {
    /*
    File：文件和目录路径名的抽象表示
          1:文件和目录是可以通过File封装成对象的
          2:对于File而言，其封装的并不是一个真正存在的文件，仅仅是一个路径名而已。它可以是存在的，也可以是不存在的。
            将来是要通过具体的操作把这个路径的内容转换为具体存在的

    构造方法：
        File(String pathname)：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
        File(String parent, String child)：从父路径名字符串和子路径名字符串创建新的 File实例。
        File(File parent, String child)：从父抽象路径名和子路径名字符串创建新的 File实例。
    */
    @Test
    public void demo1(){
        //File(String pathname)：通过将给定的路径名字符串转换为抽象路径名来创建新的 File 实例
        File f1 = new File("D:\\study\\java\\io\\java.txt");
        System.out.println(f1);

        //File(String parent, String child)：从父路径名字符串和子路径名字符串创建新的 File实例。
        File f2 = new File("D:\\study\\java\\io","java.txt");
        System.out.println(f2);

        //File(File parent, String child)：从父抽象路径名和子路径名字符串创建新的 File实例。
        File f3 = new File("D:\\study\\java\\io");
        File f4 = new File(f3,"java.txt");
        System.out.println(f4);
    }


    /*
    File类创建功能：
        public boolean createNewFile()：当具有该名称的文件不存在时，创建一个由该抽象路径名命名的新空文件
            如果文件不存在，就创建文件，并返回true
            如果文件存在，就不创建文件，并返回false

        public boolean mkdir()：创建由此抽象路径名命名的目录
            如果目录不存在，就创建目录，并返回true
            如果目录存在，就不创建目录，并返回false

        public boolean mkdirs()：创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录
            自己补齐
    */
    @Test
    public void demo2() throws IOException {
        //需求1：我要在D:\study\java\io目录下创建一个文件java.txt
        File f1 = new File("D:\\study\\java\\io\\java.txt");
        System.out.println(f1.createNewFile());
        //需求2：我要在D:\study\java\io目录下创建一个目录JavaSE
        File f2 = new File("D:\\study\\java\\io\\JavaSE");
        System.out.println(f2.mkdir());
        //需求3：我要在D:\study\java\io目录下创建一个多级目录JavaWEB\\HTML
        File f3 = new File("D:\\study\\java\\io\\JavaWEB\\HTML");
        System.out.println(f3.mkdirs());
    }


    /*
    File类的判断和获取功能：
        public boolean isDirectory()：测试此抽象路径名表示的File是否为目录
        public boolean isFile()：测试此抽象路径名表示的File是否为文件
        public boolean exists()：测试此抽象路径名表示的File是否存在

        public String getAbsolutePath()：返回此抽象路径名的绝对路径名字符串
        public String getPath()：将此抽象路径名转换为路径名字符串
        public String getName()：返回由此抽象路径名表示的文件或目录的名称

        public String[] list()：返回此抽象路径名表示的目录中的文件和目录的名称字符串数组
        public File[] listFiles()：返回此抽象路径名表示的目录中的文件和目录的File对象数组
    */
    @Test
    public void demo3(){
        File file = new File("D:\\study\\java\\io\\java.txt");
        //public boolean isDirectory()：测试此抽象路径名表示的File是否为目录
        //public boolean isFile()：测试此抽象路径名表示的File是否为文件
        //public boolean exists()：测试此抽象路径名表示的File是否存在
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println("-------------------");

        //public String getAbsolutePath()：返回此抽象路径名的绝对路径名字符串
        //public String getPath()：将此抽象路径名转换为路径名字符串
        //public String getName()：返回由此抽象路径名表示的文件或目录的名称
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println("-------------------");

        // public String[] list()：返回此抽象路径名表示的目录中的文件和目录的名称字符串数
        // public File[] listFiles()：返回此抽象路径名表示的目录中的文件和目录的File对象 数组
        File file1 = new File("D:\\study\\java\\io\\itcast");
        String[] list = file1.list();
        for(String str : list){
            System.out.println(str);
        }

        System.out.println("-------------------");
        File[] files = file1.listFiles();
        for(File file2 : files){
            System.out.println(file2);
            System.out.println(file2.getName());
            if(file.isFile()){
                System.out.println(file2.getName());
            }
        }

    }

    @Test
    public void Demo4() throws IOException {
        File file = new File("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\java.text");
        //需求1：在当前模块目录下创建java.txt文件
        //System.out.println(file.createNewFile());

        //需求2：删除当前模块目录下的java.txt文件
        //System.out.println(file.delete());
        //System.out.println("-----------------");

        //需求3：在当前模块目录下创建itcast目录
        File file1 = new File("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\itcast");
        System.out.println(file1.mkdir());

        //需求4：删除当前模块目录下的itcast目录
        //System.out.println(file1.delete());
        //System.out.println("--------------------");
    }
}
