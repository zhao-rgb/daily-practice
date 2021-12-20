package com.zxl.dailypractice.io;

import java.io.*;

/**
 * @author zhao
 * @className DataStream
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//数据流   https://www.lanqiao.cn/courses/1230/learning/?id=9472
public class DataStream {
    public static void main(String[] args) throws IOException {
        //向文件 a.txt 写入
        FileOutputStream fos = new FileOutputStream("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\a.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        try {
            dos.writeBoolean(true);
            dos.writeByte((byte)123);
            dos.writeChar('J');
            dos.writeDouble(3.1415926);
            dos.writeFloat(2.122f);
            dos.writeInt(123);
        } finally {
            dos.close();
        }
        //从文件 a.txt 读出
        FileInputStream fis = new FileInputStream("E:\\daily-practice\\src\\main\\java\\com\\zxl\\dailypractice\\Io\\a.txt");
        DataInputStream dis = new DataInputStream(fis);
        try {
            System.out.println("\t" + dis.readBoolean());
            System.out.println("\t" + dis.readByte());
            System.out.println("\t" + dis.readChar());
            System.out.println("\t" + dis.readDouble());
            System.out.println("\t" + dis.readFloat());
            System.out.println("\t" + dis.readInt());
        }
        finally {
            dis.close();
        }
    }
}
