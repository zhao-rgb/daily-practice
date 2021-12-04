package com.zxl.dailypractice.DesignPattern.ProxyPattern;

/**
 * @author zhao
 * @className LouClient
 * @Description TODO
 * @Date 2021/11/25
 * @Version 1.0
 **/
//代理模式      https://www.lanqiao.cn/courses/1230/learning/?id=11050
public class LouClient {
    public static void main(String[] args) {
        LouSubject proxy = new LouProxy();
        proxy.build();
    }
}
