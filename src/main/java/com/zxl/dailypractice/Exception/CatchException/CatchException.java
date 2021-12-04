package com.zxl.dailypractice.Exception.CatchException;

/**
 * @author zhao
 * @className CatchException
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
//捕获异常编程实例   https://www.lanqiao.cn/courses/1230/learning/?id=9470
public class CatchException {
    public static void main(String[] args) {
        try {
            // 下面定义了一个try语句块
            System.out.println("I am try block.");
            Class<?> tempClass = Class.forName("");
            // 声明一个空的Class对象用于引发“类未发现异常”
            System.out.println("Bye! Try block.");
        } catch (ClassNotFoundException e){
            // 下面定义了一个catch语句块
            System.out.println("I am catch block.");
            e.printStackTrace();
            //printStackTrace()的意义在于在命令行打印异常信息在程序中出错的位置及原因
            System.out.println("Goodbye! Catch block.");
        } finally {
            // 下面定义了一个finally语句块
            System.out.println("I am finally block.");
        }

    }
}
