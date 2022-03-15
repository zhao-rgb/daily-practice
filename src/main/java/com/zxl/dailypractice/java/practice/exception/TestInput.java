package com.zxl.dailypractice.java.practice.exception;

/**
 * @author zhao
 * @className TestInput
 * @Description TODO
 * @Date 2022/3/15
 * @Version 1.0
 **/
//自定义异常     https://www.twle.cn/l/yufei/java/java-basic-exception-user.html
public class TestInput {
    public static void main(String[] args) {
        try {
            new Input().method();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }
}

class WrongInputException extends Exception{
    WrongInputException(String s){
        super(s);
    }
}

class Input{
    void method() throws WrongInputException{
        throw new WrongInputException("Wrong input");
    }
}
