package com.zxl.dailypractice.Io;

import java.io.*;

/**
 * @author zhao
 * @className Test
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//文件流       https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class Test {
    public static void main(String[] args) {
        try {
            //inFile 作为输入流的数据文件必须存在，否则抛出异常
            File inFile = new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\file1.txt");
            //file2.txt没有，系统可以创建
            File outFile = new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\file2.txt");
            FileInputStream fis = new FileInputStream(inFile);
            FileOutputStream fos = new FileOutputStream(outFile);
            int c;
            while ((c = fis.read()) != -1){
                fos.write(c);
            }
            //打开了文件一定要记着关，释放系统资源
            fis.close();
            fos.close();
        }catch (FileNotFoundException e){
            System.out.println("FileStreamsTest:" + e);
        } catch (IOException e){
            System.err.println("FileStreamTest:" + e);
        }
    }
}
