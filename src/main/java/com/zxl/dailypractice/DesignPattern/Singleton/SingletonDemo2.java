package com.zxl.dailypractice.DesignPattern.Singleton;

/**
 * @author zhao
 * @className SingletonDemo2
 * @Description TODO
 * @Date 2021/12/6
 * @Version 1.0
 **/
//懒汉式：线程不安全   https://www.jianshu.com/p/3f5eb3e0b050
public class SingletonDemo2 {
    //线程不安全的
    private static SingletonDemo2 instance = null;

    private SingletonDemo2(){

    }

    //运行时加载对象
    public static SingletonDemo2 getInstance(){
        if(instance == null) {
            instance = new SingletonDemo2();
        }
        return instance;
    }
}
