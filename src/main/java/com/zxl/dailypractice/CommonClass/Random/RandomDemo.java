package com.zxl.dailypractice.CommonClass.Random;

import java.util.Random;

/**
 * @author zhao
 * @className RandomDemo
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//Random 编程实例       https://www.lanqiao.cn/courses/1230/learning/?id=9468
public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        //随机生成一个整数 int范围
        System.out.println(random.nextInt());
        //生成 [0,n] 范围的整数  设n=100
        System.out.println(random.nextInt(100+1));
        //生成 [0,n) 范围的整数  设n=100
        System.out.println(random.nextInt(100));
        //生成 [m,n] 范围的整数  设n=100 m=40
        System.out.println(40+(random.nextInt(100-40+1)));
        //随机生成一个整数 long范围
        System.out.println(random.nextLong());
        //生成[0,1.0)范围的float型小数
        System.out.println(random.nextFloat());
        //生成[0,1.0)范围的double型小数
        System.out.println(random.nextDouble());
    }
}
