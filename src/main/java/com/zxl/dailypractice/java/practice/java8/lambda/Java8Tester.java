package com.zxl.dailypractice.java.practice.java8.lambda;

/**
 * @author zhao
 * @className Java8Tester
 * @Description TODO
 * @Date 2022/3/13
 * @Version 1.0
 **/
//lambda表达式  https://www.twle.cn/l/yufei/java/java-basic-java8-lambda-expressions.html
public class Java8Tester {
    interface MathOperation{
        int operate(int a, int b);
    }
    interface GreetingService {
        void sayMessage(String message);
    }
    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operate(a,b);
    }

    public static void main(String[] args) {
        Java8Tester tester = new Java8Tester();
        MathOperation addition = (int a ,int b) -> a + b;
        MathOperation subtraction = (a,b)-> a-b;
        MathOperation multiplication = (int a, int b)->{
            return a*b;
        };
        MathOperation division = (int a, int b)-> a/b;
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        GreetingService greetingService1 = message -> System.out.println("Hello" + message);
        GreetingService greetingService2 = (message) -> System.out.println("Hello" + message);
        greetingService1.sayMessage("Twle");
        greetingService2.sayMessage("Google");
    }
}
