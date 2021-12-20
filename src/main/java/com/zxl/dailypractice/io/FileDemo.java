package com.zxl.dailypractice.io;

import java.io.File;
import java.io.IOException;

/**
 * @author zhao
 * @className FileDemo
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//文件     https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class FileDemo {
    public static void main(String[] args) {
        File f1 = new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\1.txt");
        File f2 = new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io","2.txt");
        //separator 跨平台分隔符
        File f3 = new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice"+File.separator+"Io");
        File f4 = new File(f3, "3.txt");

        try {
            System.out.println(f1);
            //当文件存在时返回 false；不存在时返回 true
            System.out.println(f2.createNewFile());
            //当文件不存在时返回 false
            System.out.println(f3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //列出磁盘下的文件和文件夹
        File[] files = File.listRoots();
        for (File file : files){
            System.out.println(file);
            if (file.length()>0){
                String[] filenames = file.list();
                for (String filename : filenames){
                    System.out.println(filename);
                }
            }
        }

    }
}
