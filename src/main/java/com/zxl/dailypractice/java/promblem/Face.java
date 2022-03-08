package com.zxl.dailypractice.java.promblem;

/**
 * @author zhao
 * @className Face
 * @Description TODO
 * @Date 2022/3/8
 * @Version 1.0
 **/
//面试题不懂的点
public class Face {
    int[] arr = new int[10];

    public static void main(String[] args) {
//        System.out.println(new Face().arr[1]);
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        String str3 = "he" +"ll0";
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }
}
