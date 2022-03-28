package com.zxl.dailypractice.java.practice.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhao
 * @className fastCopy
 * @Description TODO
 * @Date 2022/3/28
 * @Version 1.0
 **/
//使用 NIO 快速复制文件的实例      https://pdai.tech/md/java/io/java-io-nio.html
public class fastCopy {
    public static void fastCopy1(String src, String dist) throws IOException {
        FileInputStream fin = new FileInputStream(src);
        FileChannel fcin = fin.getChannel();

        /* 获取目标文件的输出字节流 */
        FileOutputStream fout = new FileOutputStream(dist);
        /* 获取输出字节流的通道 */
        FileChannel fcout = fout.getChannel();
        /* 为缓冲区分配 1024 个字节 */
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (true){
            //从输入通道中读取数据到缓冲区中
            int r = fcin.read(buffer);
            //read() 返回 -1 表示 EOF
            if (r == -1){
                break;
            }
            //切换读写
            buffer.flip();
            //把缓冲区的内容写入输出文件中
            fcout.write(buffer);
            //清空缓冲区
            buffer.clear();
        }
    }
}
