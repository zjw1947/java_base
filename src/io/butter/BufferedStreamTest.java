package io.butter;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流   读取与写入的速度快
 *
 *  速度快原因：内部提供了一个缓存区
 */
public class BufferedStreamTest {

    /**
     * 字节
     */
    @Test
    public void bufferedInputOutputStreamTest(){
        //文件
        File file = new File("src/io/zz.png");
        File file2 = new File("src/io/cc.png");

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //流
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            //缓冲流
            bis = new BufferedInputStream(fileInputStream);
            bos = new BufferedOutputStream(fileOutputStream);
            byte[] butter = new byte[10];
            int len = -1;
            while ((len = bis.read(butter)) != -1){
                bos.write(butter, 0, len);
                //刷新缓存区，清空缓存区并写出，会自动调用
//                bos.flush();

                //对文件加密/解密    m^n^n = m
               /* for(int i = 0; i < len; i++){
                    butter[i] = (byte)(butter[i] ^ 5);
                }
                bos.write(butter, 0, len);*/

            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //资源关闭
            // 要求：先关外层流，再关闭内层流
            //说明：关闭外层流的同时，内层流也会自动关闭
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void bufferedStreamTest(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("src/io/world.txt")));
            bw = new BufferedWriter(new FileWriter(new File("src/io/hello.txt")));
            //读取指定个数字符
            /*char[] butter = new char[10];
            int len = -1;
            while ((len = br.read(butter)) != -1){
                bw.write(butter, 0, len);
            }*/

            //直接读取一行
            String data = null;
            while ((data = br.readLine()) != null){
                bw.write(data);
                //读取一行不包含换行符，需手动换行
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
