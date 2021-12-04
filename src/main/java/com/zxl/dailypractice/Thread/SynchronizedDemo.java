package com.zxl.dailypractice.Thread;

/**
 * @author zhao
 * @className SynchronizedDemo
 * @Description TODO
 * @Date 2021/11/28
 * @Version 1.0
 **/
//Synchronized       https://www.lanqiao.cn/courses/1230/learning/
public class SynchronizedDemo {
    private static Object lock = new Object();

    public static void main(String[] args) {
        //同步代码块  锁住lock
        synchronized (lock){
            //doSomething
        }
    }

    //静态同步方法  锁住当前类class对象
    public synchronized static void staticMethod(){

    }
    //普通同步方法  锁住当前实例对象
    public synchronized void memberMethod(){

    }

}
