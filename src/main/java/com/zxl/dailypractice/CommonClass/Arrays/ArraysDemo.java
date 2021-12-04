package com.zxl.dailypractice.CommonClass.Arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhao
 * @className ArraysDemo
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
//Arrays 编程实例  https://www.lanqiao.cn/courses/1230/learning/?id=9468
public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
        //将数组元素都设为9
        Arrays.fill(arr,9);
        System.out.println("fill:" + Arrays.toString(arr));
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            //使用100以内的随机数赋值数组
            arr[i] = random.nextInt(101);
        }
        //重新赋值后的数组
        System.out.println("重新赋值：" + Arrays.toString(arr));
        //将索引为5的元素设为50
        arr[5] = 50;
        //排序
        Arrays.sort(arr);
        //排序后的数组
        System.out.println("sort排序后：" + Arrays.toString(arr));
        //查找50的位置
        int i = Arrays.binarySearch(arr, 50);
        System.out.println("值为50的元素索引："+i);
        //复制一份新数组
        int[] newArr = Arrays.copyOf(arr,arr.length);
        //比较
        System.out.println("equals:"+Arrays.equals(arr, newArr));
    }
}
