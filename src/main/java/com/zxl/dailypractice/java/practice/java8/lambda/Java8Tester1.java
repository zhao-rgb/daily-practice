package com.zxl.dailypractice.java.practice.java8.lambda;

/**
 * @author zhao
 * @className Java8Tester1
 * @Description TODO
 * @Date 2022/3/13
 * @Version 1.0
 **/
//变量作用域  lambda 表达式只能引用 final 或 final 局部变量，这就是说不能在 lambda 内部修改定义在域外的变量，否则会编译错误
public class Java8Tester1 {
    final static String salutation = "Hello!";

    interface GreetingService{
        void saymessage(String message);
    }

    public static void main(String[] args) {
        GreetingService greetingService = message ->
                System.out.println(salutation + message);
        greetingService.saymessage("Twle");
    }

}
