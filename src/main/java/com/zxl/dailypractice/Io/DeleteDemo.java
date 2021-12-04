package com.zxl.dailypractice.Io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author zhao
 * @className DeleteDemo
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
// 删除    https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class DeleteDemo {
    public static void main(String[] args) {
        try {
            //删除文件，文件必须存在，否则抛出异常
            Files.delete(Paths.get("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\3.txt"));
            //删除文件，返回是否删除成功 即使文件不存在，也不会保存，直接返回false
            System.out.println(Files.deleteIfExists(Paths.get("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\3.txt")));
            //或者使用File类的delete方法
            File file = new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\4.txt");
            System.out.println(file.delete());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
