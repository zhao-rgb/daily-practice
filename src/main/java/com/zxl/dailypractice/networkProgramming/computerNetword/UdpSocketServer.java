package com.zxl.dailypractice.networkProgramming.computerNetword;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author zhao
 * @className UdpSocketServer
 * @Description TODO
 * @Date 2022/5/4
 * @Version 1.0
 **/
public class UdpSocketServer {
    /**
     * 服务端程序
     */
    public void server() throws IOException {

        Scanner scanner = new Scanner(System.in);

        // 服务端监听 1080 端口
        DatagramSocket serverSocket = new DatagramSocket(1080);
        while (true) {
            // 获取客户端输入流
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            System.out.println("****服务器端已经启动，等待客户端发送数据");
            serverSocket.receive(datagramPacket);
            // 客户端发来的消息
            System.out.println("客户端：" + new String(datagramPacket.getData(), 0, datagramPacket.getLength(), Charset.defaultCharset()));

            // 给客户端发端东西
            System.out.print("请输入：");
            String nextLine = scanner.next();
            if ("out".equals(nextLine)) {
                break;
            }
            byte[] bytes1 = nextLine.getBytes(StandardCharsets.UTF_8);
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length, datagramPacket.getAddress(), datagramPacket.getPort());
            serverSocket.send(datagramPacket1);
        }


    }

    public static void main(String[] args) throws IOException {
        UdpSocketServer tcpSocketServer = new UdpSocketServer();
        tcpSocketServer.server();
        ;
    }
}
