package com.zxl.dailypractice;

/**
 * @author zhao
 * @className B
 * @Description TODO
 * @Date 2021/12/23
 * @Version 1.0
 **/
public interface B {
    int MAX = 100;
    void f();
}

abstract class Cao implements B{
    int MIN;
}

class Dog extends Cao{
    @Override
    public void f() {
        MIN = 10;
        int MAX = 200;
    }
}
