package com.zxl.dailypractice.io;

import java.io.File;

/**
 * @author zhao
 * @className PrintDirTree
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//目录树        https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class PrintDirTree {
    public static void main(String[] args) {
        PrintDirTree.printDirTree(new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice"),"");
    }

    public static void printDirTree(File file,String s){
        if(file.isDirectory()){
            File[] files;
            System.out.println(s + file.getName());
            if((files = file.listFiles()) != null){
                s = s + " ";
                for (File file1 : files){
                    printDirTree(file1,s);
                }
            }
        } else {
            System.out.println(s + file.getName());
        }
    }
}
