package com.zhangzemin.io.byte_straem;

import org.junit.Test;

import java.io.*;

/**
 * 字节数组输出流
 * @author zhangzemin
 * @date 2020/4/17 13:33
 */
public class ByteArrayOutputStreamDemo {
    /**
     * 使用ByteArrayOutputStream把数据写到字节数组中
     */
    @Test
    public void demo01(){
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\project\\study_project\\javase\\src\\test\\java\\com\\zhangzemin\\io\\byte_straem\\fos.txt"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ){
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1){
                baos.write(bytes,0,len);
            }
            byte[] content = baos.toByteArray();
            System.out.println(content.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用ByteArrayOutputStream把数据从字节数组中读出来
     */
    @Test
    public void demo02(){
        byte[] byteStr = "HelloWorld".getBytes();
        try(ByteArrayInputStream bais = new ByteArrayInputStream(byteStr)){
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bais.read(bytes)) != -1){
                String s = new String(bytes,0,len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
