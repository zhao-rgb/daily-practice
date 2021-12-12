package com.zxl.dailypractice.designPattern.Singleton;

/**
 * @author zhao
 * @className SingletonDemo1
 * @Description TODO
 * @Date 2021/12/6
 * @Version 1.0
 **/
//饿汉式：线程安全，调用效率高。但是不能延时加载     https://www.jianshu.com/p/3f5eb3e0b050
public class SingletonDemo1 {
    //线程安全的
    //类初始化时，立即加载这个对象
    private static SingletonDemo1 instance = new SingletonDemo1();

    private SingletonDemo1(){

    }

    //方法没有加同步块，所以它效率高
    public static SingletonDemo1 getInstance(){
        return instance;
    }
}
