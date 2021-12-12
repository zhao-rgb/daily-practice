package com.zxl.dailypractice.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhao
 * @className LockDemo
 * @Description TODO
 * @Date 2021/11/28
 * @Version 1.0
 **/
//编程实战     https://www.lanqiao.cn/courses/1230/learning/
public class LockDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            lock.lock();
            try{
                //需要同步的代码块
                System.out.println("线程1加锁");
            }finally {
                //一定要在finally中解锁，否则可能造成死锁
                lock.unlock();
                System.out.println("线程1解锁");
            }
        });
        thread1.start();
        Thread thread2 = new Thread(()->{
            lock.lock();
            try{
                System.out.println("线程2加锁");
            }finally {
                lock.unlock();
                System.out.println("线程2解锁");
            }
        });
        thread2.start();
    }
}
