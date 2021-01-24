package io.file;

import org.junit.Test;

import java.io.File;

/**
 * File 类，代表一个文件或文件目录
 */
public class FileTest {

    /**
     * 路径写法
     *      windows/DOS:  \
     *      UNIX/URL:   /
     * 可使用 File.separator 让系统自动识别
     */
    @Test
    public void baseTest(){
        //-- 通过文件路径创建
        // idea :  Junit 相对路径-当前modle
        //         main()相对路径-当前project
        //eclipse   对路径-当前project
        File file = new File("src\\io\\hello.txt");
        //绝对路径
//        File file = new File("f:\\java_base\\src\\io\\hello.txt");
        //File.separator
//        File file = new File("src"+ File.separator +"io"+ File.separator +"hello.txt");
        System.out.println((file.toString()));

        //-- 通过父目录查找指定的子目录
        File file2 = new File("src\\io" , "hello.txt");
        System.out.println((file2.toString()));

        //--
        File parentFile = new File("src\\io");
        File file3 = new File(parentFile , "hello.txt");
        System.out.println((file3.toString()));
    }

}
