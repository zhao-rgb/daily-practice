package com.zxl.dailypractice.exception.CatchException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author zhao
 * @className MultipleCapturesDemo
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
//捕获多个异常     https://www.lanqiao.cn/courses/1230/learning/?id=9470
public class MultipleCapturesDemo {
    public static void main(String[] args) {
        try {
            new FileInputStream("");
        } catch (FileNotFoundException e){
            System.out.println("IO 异常");
        } catch (Exception e){
            System.out.println("发生异常");
        }
    }
}
