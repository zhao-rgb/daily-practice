package com.zxl.dailypractice.Io;

import java.io.*;

/**
 * @author zhao
 * @className FileToUnicode
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//BufferedReader 和 BufferedWrite    https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class FileToUnicode {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\file1.txt");
            InputStreamReader dis = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(dis);
            String s;
            //每次读取一行，当改行为空时结束
            while ((s = reader.readLine()) != null) {
                System.out.println("read:" + s);
            }
            dis.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
