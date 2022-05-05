package com.zxl.dailypractice.networkProgramming.computerNetword;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author zhao
 * @className UdpSocketClient
 * @Description TODO
 * @Date 2022/5/4
 * @Version 1.0
 **/
public class UdpSocketClient {
    /**
     * 客户端程序
     */
    public void client() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.connect(new InetSocketAddress("127.0.0.1", 1080));
            String next = scanner.next();
            if ("out".equals(next)) {
                break;
            }
            byte[] bytes = next.getBytes(StandardCharsets.UTF_8);
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.send(datagramPacket);

            // 获取客户端输入流
            byte[] bytes1 = new byte[1024];
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length);
            datagramSocket.receive(datagramPacket1);

            // 客户端发来的消息
            System.out.println("服务端：" + new String(datagramPacket1.getData(), 0, datagramPacket1.getLength(), Charset.defaultCharset()));

        }
    }

    public static void main(String[] args) throws IOException {
        UdpSocketClient tcpSocketServer = new UdpSocketClient();
        tcpSocketServer.client();
    }
}
