package com.zxl.dailypractice.NetworkProgramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhao
 * @className EchoServer
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
//编译一个简单的 Socket 应用，实现客户端发送信息给服务端，服务端再将信息发送回客户端的回显的功能  https://www.lanqiao.cn/courses/1230/learning/?id=9473
public class EchoServer {
    public static void main(String[] args) {
        try {
            //服务端需要使用ServerSocket类
            ServerSocket serverSocket = new ServerSocket(1080);
            //阻塞 等待客户端连接
            Socket client = serverSocket.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String userIn;
            while ((userIn = in.readLine()) != null){
                System.out.println("收到客户端消息：" + userIn);
                //发回客户端
                out.println(userIn);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
