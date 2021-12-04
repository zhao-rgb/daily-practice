package com.zxl.dailypractice.Exception.Throw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author zhao
 * @className ThrowsTest1
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
//throw 抛出异常    https://www.lanqiao.cn/courses/1230/learning/?id=9470
public class ThrowsTest1 {
    public static void main(String[] args) throws FileNotFoundException {
        //由方法的调用者捕获异常或者继续向上抛出
        throwsTest();
    }

    public static void throwsTest() throws FileNotFoundException{
        new FileInputStream("/home/project/shiyanlou.file");
    }
}
