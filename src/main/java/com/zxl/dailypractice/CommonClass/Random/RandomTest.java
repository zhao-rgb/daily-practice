package com.zxl.dailypractice.CommonClass.Random;

import java.util.Random;
import java.util.Scanner;

/**
 * @author zhao
 * @className RandomTest
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//练习题：输出随机数      https://www.lanqiao.cn/courses/1230/learning/?id=9468
public class RandomTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int i1 = scanner.nextInt();
        Random random = new Random();
        System.out.println(i+random.nextInt(i1-i+1));
    }
}
