package com.zxl.dailypractice.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author zhao
 * @className CopyDemo
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//拷贝       https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class CopyDemo {
    public static void main(String[] args) {
        try {
            //被拷贝的文件一定要存在 否则会抛出异常  这里的1.txt一定要存在
            Files.copy(Paths.get("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\1.txt"),
                    Paths.get("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\2.txt"),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
