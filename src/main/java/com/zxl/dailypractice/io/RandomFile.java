package com.zxl.dailypractice.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author zhao
 * @className RandomFile
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//随机访问文件    https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class RandomFile {
    public static void main(String[] args) {
        RandomAccessFile file;
        try {
            File d = new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\randomAccess.file");
            file = new RandomAccessFile(d, "rw");
            file.seek(10);
            byte[] b = new byte[(int)file.length()-10];
            file.read(b);
            System.out.println(new String(b));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
