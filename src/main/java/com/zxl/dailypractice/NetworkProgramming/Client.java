package com.zxl.dailypractice.NetworkProgramming;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhao
 * @className Client
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
//练习题：多线程服务器       https://www.lanqiao.cn/courses/1230/learning/?id=9473
public class Client {
    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        //socket端口
        int port = 1080;
        Scanner userIn = new Scanner(System.in);
        try{
            //建立socket连接
            Socket socket = new Socket(hostname,port);
            //获取socket输出流
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //获取输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String userInput;
            System.out.println("请输入信息：");
            //当用户输入exit时退出
            while (!"exit".equals(userInput = userIn.nextLine())){
                out.println(userInput);
                System.out.println("收到服务端回应：" + in.readLine());
            }
            //关闭socket
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
