package com.zxl.dailypractice.commonClass.Arrays;

import java.util.Arrays;

/**
 * @author zhao
 * @className ArraysTest
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
//测试  https://www.lanqiao.cn/courses/1230/learning/?id=9468
public class ArraysTest {
    public static void main(String[] args) {
        int[] arr = {6, 17, 92, 32, 58, 22, 84, 66, 36, 33};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int i = Arrays.binarySearch(arr,33);
        System.out.println(i);
    }

}
