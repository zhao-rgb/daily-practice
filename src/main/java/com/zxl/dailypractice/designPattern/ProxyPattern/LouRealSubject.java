package com.zxl.dailypractice.designPattern.ProxyPattern;

/**
 * @author zhao
 * @className LouRealSubject
 * @Description TODO
 * @Date 2021/11/25
 * @Version 1.0
 **/
public class LouRealSubject implements LouSubject{
    @Override
    public void build() {
        System.out.println("建造实验楼");
    }
}
