package com.zxl.dailypractice.java.practice.java8.method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className Java8Tester2
 * @Description TODO
 * @Date 2022/3/13
 * @Version 1.0
 **/
//Java 8 方法引用
public class Java8Tester2 {
    public static void main(String[] args) {
        List names = new ArrayList();

        names.add("Google");
        names.add("Twle");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
