package com.zxl.dailypractice.Io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author zhao
 * @className FileDemo1
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//代码练习     https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class FileDemo1 {
    public static void main(String[] args) {
        int[] data_arr = {12, 32, 43, 45, 1, 5};
        try {
            RandomAccessFile randf = new RandomAccessFile("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\temp.dat", "rw");
            for (int i = 0; i < data_arr.length; i++) {
               randf.writeInt(data_arr[i]);
            }
            for (int i = data_arr.length-1; i >= 0 ; i--) {
                //int 数据占4个字节
                randf.seek(i * 4L);
                System.out.println(randf.readInt());
            }
            randf.close();
        } catch (IOException e){
            System.out.println("File access error" + e);
        }
    }
}
