package com.zxl.dailypractice.Io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author zhao
 * @className FileCut
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//文件分割     https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class FileCut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        File file = new File("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\1.txt");
        //需要分隔的文件份数
        int num;
        //如果不能整除，那么需要多加一个文件 用于保存剩余的数据
        if (file.length() % n ==0){
            num = (int) (file.length() / n );
        } else {
            num = (int) (file.length() / n) + 1;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            //读取文件到bytes
            fileInputStream.read(bytes);
            fileInputStream.close();
            for (int i = 1; i <= num; i++) {
                //文件名
                String fileName = "E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\" + i +".txt";
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                //最后一份文件需要特殊处理 因为他的大小不是n
                if (i == num){
                    //(file.length()-n*(i-1)) 文件的总字节数 再减去前面已经读取的字节数 就是剩余的字节数
                    fileOutputStream.write(bytes,n*(i-1),(int) (file.length() -n*(i-1)));
                } else {
                    fileOutputStream.write(bytes,n*(i-1),n);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
