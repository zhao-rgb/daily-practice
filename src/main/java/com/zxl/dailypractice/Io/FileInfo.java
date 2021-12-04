package com.zxl.dailypractice.Io;

import java.io.File;
import java.util.Arrays;

/**
 * @author zhao
 * @className FileInfo
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//文件属性    https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class FileInfo {
    public static void main(String[] args) {
        File file = new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io");
        System.out.println("文件或者目录名：" +file.getName());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("父路径：" + file.getParent());
        System.out.println("文件路径：" + file.getPath());
        //判断文件是否是目录
        if(file.isDirectory()) {
            //打印目录中的文件
            Arrays.stream(file.list()).forEach(System.out::println);
        }
        System.out.println("是否隐藏：" + file.isHidden());
        System.out.println("是否存在：" + file.exists());
    }
}
