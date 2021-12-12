package com.zxl.dailypractice.exception.CatchException;

/**
 * @author zhao
 * @className ExceptionStackTrace
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
//当异常抛出后，我们可以通过异常堆栈追踪程序的运行轨迹，以便我们更好的 DEBUG。        https://www.lanqiao.cn/courses/1230/learning/?id=9470
public class ExceptionStackTrace {
    private static void method1() {
        method2();
    }

    private static void method2() {
        throw new NullPointerException();
    }

    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e){
            //打印堆栈轨迹
            e.printStackTrace();
        }
    }
}
