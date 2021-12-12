package com.zxl.dailypractice.lambda;

/**
 * @author zhao
 * @className LambdaTest1
 * @Description TODO
 * @Date 2021/11/30
 * @Version 1.0
 **/
//作用域    https://www.lanqiao.cn/courses/1230/learning/?id=9471
public class LambdaTest1 {
    final static String salutation = "Hello";//正确，不可再次赋值
    //static String salutation = "Hello "; //正确，可再次赋值
    //String salutation = "Hello "; //报错
    //final String salutation = "Hello "; //报错

    public static void main(String[] args) {
        //final String salutation = "Hello "; //正确，不可再次赋值
        //String salutation = "Hello "; //正确，隐性为 final , 不可再次赋值

        // salutation = "welcome to "
        GreetingService greetingService = message ->
                System.out.println(salutation + message);
        greetingService.sayMessage("Shiyanlou");
    }

    interface GreetingService{
        void sayMessage(String message);
    }
}
