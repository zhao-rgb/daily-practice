package com.zxl.dailypractice.Io;

import java.io.File;

/**
 * @author zhao
 * @className ReadDir
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//目录读取      https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class ReadDir {
    public static void main(String[] args) {
        ReadDir.readDir(new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice"));
    }
    static void readDir(File file){
        if (file == null){
            return;
        }
        //如果当前file是目录
        if(file.isDirectory()){
            File[] files;
            //如果目录不为空
            if((files = file.listFiles()) != null) {
                for(File file1 : files){
                    //递归读取目录内容
                    readDir(file1);
                }
            }
        } else {
            //如果不是目录 直接输出文件名
            System.out.println(file.getName());
        }
    }
}
