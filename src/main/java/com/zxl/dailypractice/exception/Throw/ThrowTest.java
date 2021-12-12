package com.zxl.dailypractice.exception.Throw;

/**
 * @author zhao
 * @className ThrowTest
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
//throw 抛出异常    https://www.lanqiao.cn/courses/1230/learning/?id=9470
public class ThrowTest {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = null;
        //当a或者b为null时，抛出异常
        if (a == null || b == null) {
            throw new NullPointerException();
        } else {
            System.out.println(a + b);
        }
    }
}
