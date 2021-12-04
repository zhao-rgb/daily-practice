package com.zxl.dailypractice.Lambda;

/**
 * @author zhao
 * @className LambdaTest
 * @Description TODO
 * @Date 2021/11/30
 * @Version 1.0
 **/
//初步   https://www.lanqiao.cn/courses/1230/learning/?id=9471
public class LambdaTest {
    public static void main(String[] args) {
        LambdaTest tester = new LambdaTest();

        //带有类型声明的表达式
        MathOperation addition = (int a,int b) -> a + b;

        // 没有类型声明的表达式
        MathOperation subtraction = (a,b)-> a-b;

        // 带有大括号、带有返回语句的表达式
        MathOperation multiplication = (int a, int b) ->{
            return a*b;
        };

        // 没有大括号和return语句的表达式
        MathOperation division = (int a, int b)-> a/b;

        //输出结果
        System.out.println("10 + 5 = " + tester.operate(10,5,addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 没有括号的表达式
        GreetingService greetService1 = message -> System.out.println("Hello " + message);

        // 有括号的表达式
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

        // 调用sayMessage方法输出结果
        greetService1.sayMessage("Shiyanlou");
        greetService2.sayMessage("Classmate");
    }

    // 下面是定义的一些接口和方法
    interface MathOperation{
        int operation(int a, int b);
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    private int operate(int a, int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}
