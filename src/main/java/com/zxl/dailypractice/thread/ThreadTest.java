package com.zxl.dailypractice.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhao
 * @className ThreadTest
 * @Description TODO
 * @Date 2021/11/28
 * @Version 1.0
 **/
//顺序打印字母       https://www.lanqiao.cn/courses/1230/learning/
public class ThreadTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static int count = 0;
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread A = new Thread(()->{
            //加锁 一次只有一个线程输出
            lock.lock();
            try {
                while (true){
                    //因为只循环3次 所以到9的时候就结束循环
                    if(count == 9){
                        break;
                    }
                    //当余数为0 就输出A
                    if(count % 3 == 0){
                        count++;
                        System.out.println("A");
                        //唤醒其他等待线程
                        condition.signalAll();
                    } else {
                        try {
                            //等待
                            condition.await();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        });
        Thread B = new Thread(()->{
            //加锁 一次只有一个线程输出
            lock.lock();
            try {
                while (true){
                    //因为只循环3次 所以到9的时候就结束循环
                    if(count == 9){
                        break;
                    }
                    //当余数为0 就输出A
                    if(count % 3 == 1){
                        count++;
                        System.out.println("B");
                        //唤醒其他等待线程
                        condition.signalAll();
                    } else {
                        try {
                            //等待
                            condition.await();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        });

        Thread C = new Thread(()->{
            //加锁 一次只有一个线程输出
            lock.lock();
            try {
                while (true){
                    //因为只循环3次 所以到9的时候就结束循环
                    if(count == 9){
                        break;
                    }
                    //当余数为0 就输出A
                    if(count % 3 == 2){
                        count++;
                        System.out.println("C");
                        //唤醒其他等待线程
                        condition.signalAll();
                    } else {
                        try {
                            //等待
                            condition.await();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        });
        A.start();
        B.start();
        C.start();
    }
}
