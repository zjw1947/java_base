package io.stream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件输入输出-字节
 */
public class FileInputOutputStreamTest {

    /**
     * 读操作
     */
    @Test
    public void fileInputStreamTest(){
        File file = new File("src/io/hello.txt");
        FileInputStream fileInputStream = null;
        try {
            String str = null;
            fileInputStream = new FileInputStream(file);
            byte[] arr = new byte[4];
            int len = -1;
            while ( (len = fileInputStream.read(arr)) != -1){
                str = new String(arr, 0, len);
                System.out.print(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void fileOutputStreamTest(){
        File file = new File("src/io/zz.png");
        File file2 = new File("src/io/cc.png");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            String str = null;
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);
            byte[] arr = new byte[1000];
            int len = -1;
            //写入文件不存在时会自动创建
            while ( (len = fileInputStream.read(arr)) != -1){
                fileOutputStream.write(arr);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
