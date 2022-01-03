package com.zxl.dailypractice.java.promblem;

/**
 * @author zhao
 * @className Hello
 * @Description TODO
 * @Date 2021/12/26
 * @Version 1.0
 **/
public class Hello {
    public static void main(String[] args) {
        A c = new C();
        System.out.println(c.getNumber(10));
//        System.out.println(c.f(3,5));
//        System.out.println(c.f(3.0,5.0));
    }
}

class A{
//    double f(double x,double y){
//        return x+y;
//    }
    public int getNumber(int a){
        return a+1;
    }
}

class C extends A{
    @Override
    public int getNumber(int a) {
        return a+100;
    }
//    double f(int x,int y){
//        return x*y;
//    }
}
