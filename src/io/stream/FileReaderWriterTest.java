package io.stream;

import org.junit.Test;

import java.io.*;

/**
 * 文件输入输出-字符
 */
public class FileReaderWriterTest {

    /**
     * 读操作
     */
    @Test
    public void fileReaderTest(){
        File file = new File("src/io/hello.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);

            //read()  返回读取的一个字符，若读取结束，返回-1
            /*int data = -1;
            while ((data = fileReader.read()) != -1){
                System.out.print((char)data);
            }*/

            //read(char[] arr)  返回每次读取的数据长度，若读取结束，返回-1
            char[] arr = new char[3];
            while (fileReader.read(arr) != -1 ){
                for(char c: arr){
                    System.out.print(c);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 写操作
     */
    @Test
    public void fileWriterTest(){
        File file = new File("src/io/world.txt");
        File file2 = new File("src/io/hello.txt");
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        try {
            fileWriter = new FileWriter(file);
            fileReader = new FileReader(file2);

            //字符串写入
//            fileWriter.write("hello 中国\n");

            //字符写入
            /*int data = -1;
            while ((data = fileReader.read()) != -1){
                fileWriter.write(data);
            }*/

            //字符数组写入
            char[] arr = new char[3];
            while (fileReader.read(arr) != -1 ){
                    fileWriter.write(arr);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
