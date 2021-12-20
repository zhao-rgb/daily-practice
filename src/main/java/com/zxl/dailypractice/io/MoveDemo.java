package com.zxl.dailypractice.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author zhao
 * @className MoveDemo
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//移动和重命名      https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class MoveDemo {
    public static void main(String[] args) {
        try {
            //将1.txt 重命名为3.txt 如果只需要移动到不同的目录，文件名不变即可
            Files.move(Paths.get("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\1.txt"),
                    Paths.get("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\3.txt"),
                    StandardCopyOption.REPLACE_EXISTING);
            //将2.txt 重命名为4.txt 如果只需要移动到不同的目录，文件名不变即可
            Files.move(Paths.get("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\2.txt"),
                    Paths.get("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\4.txt"),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
