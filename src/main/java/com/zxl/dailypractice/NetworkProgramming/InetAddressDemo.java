package com.zxl.dailypractice.NetworkProgramming;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhao
 * @className InetAddressDemo
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
//InetAddress 类    https://www.lanqiao.cn/courses/1230/learning/?id=9473
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress shiyanlou = InetAddress.getByName("www.lanqiao.cn");
            //toString 方法将输出主机名和ip地址
            System.out.println(shiyanlou.toString());
            //获取id地址
            String ip = shiyanlou.toString().split("/")[1];
            //根据IP地址获取主机名
            InetAddress byaddress = InetAddress.getByName(ip);
            System.out.println("get hostname by IP address:"+byaddress.getHostAddress());
            System.out.println("localhost: "+InetAddress.getLocalHost());
        } catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
