package com.zxl.dailypractice.networkProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhao
 * @className Server
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
//练习题：多线程服务器       https://www.lanqiao.cn/courses/1230/learning/?id=9473
public class Server {
    public static void main(String[] args) {
        try {
            //服务端需要使用ServerSocket类
            ServerSocket serverSocket = new ServerSocket(1080);
            //阻塞 等待客户端连接
            while (true){
                Thread thread = new Thread(new ServerThread(serverSocket.accept()));
                thread.start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    static class ServerThread implements Runnable{
        Socket client;

        public ServerThread(Socket client){
            this.client = client;
        }

        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String userIn;
                while ((userIn = in.readLine())!=null){
                    System.out.println("收到客户端消息："+userIn);
                    //发回客户端
                    out.println(userIn);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
