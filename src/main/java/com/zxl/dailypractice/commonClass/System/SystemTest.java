package com.zxl.dailypractice.commonClass.System;

import java.util.Arrays;

/**
 * @author zhao
 * @className SystemTest
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//练习题   https://www.lanqiao.cn/courses/1230/learning/?id=9468
public class SystemTest {
    public static void main(String[] args) {
        int[] a = {7, 8, 9, 10, 11};
        int[] b = {1, 2, 3, 4, 5, 6};
        //从数组a的第二个元素开始，复制到b数组的第三个位置 复制的元素长度为3
        System.arraycopy(a,1,b,2,3);
        //输出结果
        System.out.println(Arrays.toString(b));
        System.out.println("java安装路径：" + System.getProperty("java.home"));
    }
}
