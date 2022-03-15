package com.zxl.dailypractice.java.practice.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhao
 * @className ArrayToCollection
 * @Description TODO
 * @Date 2022/3/15
 * @Version 1.0
 **/
//使用 Java Util 类的 Arrays.asList(name) 方法将数组转换为集合  https://www.twle.cn/l/yufei/java/java-basic-collection-array.html
public class ArrayToCollection {
    public static void main(String[] args) {
        int n = 5;
        String[] name = new String[n];
        for (int i = 0; i < 5; i++) {
            name[i] = String.valueOf(i);
        }
        List<String> list = Arrays.asList(name);
        for (String li : list){
            System.out.print(li + " ");
        }
    }
}
