package com.zxl.dailypractice.Exception.CatchException;

/**
 * @author zhao
 * @className MyAriException
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
//自定义异常     https://www.lanqiao.cn/courses/1230/learning/?id=9470
public class MyAriException extends ArithmeticException{
    //自定义异常类，该类继承自ArithmeticException
    public MyAriException(){

    }
    //实现默认的无参构造方法
    public MyAriException(String msg){
        super(msg);
    }
    //实现可以自定义输出信息的构造方法，将待输出信息作为参数传入即可
}
