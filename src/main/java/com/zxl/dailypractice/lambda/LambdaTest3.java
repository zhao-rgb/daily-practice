package com.zxl.dailypractice.lambda;

import java.util.Arrays;

/**
 * @author zhao
 * @className LambdaTest3
 * @Description TODO
 * @Date 2021/12/1
 * @Version 1.0
 **/
//练习题：lambda      https://www.lanqiao.cn/courses/1230/learning/?id=9471
public class LambdaTest3 {
    public static void main(String[] args) {
        int[] arr = {1, 23, 4, 4, 22, 34, 45, 11, 33};
        System.out.println("最小数:"+ Arrays.stream(arr));
        System.out.println("最小数:"+ Arrays.stream(arr).min());
        System.out.println("最小数:"+ Arrays.stream(arr).max());
        System.out.println("数组去重乘2求和："+Arrays.stream(arr).distinct().map((i)->i*2).sum());
    }
}
