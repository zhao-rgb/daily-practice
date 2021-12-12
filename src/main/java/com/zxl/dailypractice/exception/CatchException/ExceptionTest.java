package com.zxl.dailypractice.exception.CatchException;

import java.util.Arrays;

/**
 * @author zhao
 * @className ExceptionTest
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
//自定义异常测试     https://www.lanqiao.cn/courses/1230/learning/?id=9470
public class ExceptionTest {
    public static void main(String[] args) {
        int[] array = new int[5];
        //声明一个长度为5的数组
        Arrays.fill(array,5);
        //将数组中的所有元素赋值为5
        for (int i = 4; i > -1; i--) {
            //使用for循环逆序遍历整个数组，i每次递减
            if(i==0){
                // 如果i除以了0，就使用带异常信息的构造方法抛出异常
                throw new MyAriException("There is an exception occured.");
            }
            System.out.println("array[" + i + "] / " + i + " = " + array[i] / i);
            // 如果i没有除以0，就输出此结果
        }
    }
}
