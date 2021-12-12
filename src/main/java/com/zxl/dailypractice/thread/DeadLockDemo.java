package com.zxl.dailypractice.thread;

/**
 * @author zhao
 * @className DeadLockDemo
 * @Description TODO
 * @Date 2021/11/28
 * @Version 1.0
 **/
//死锁    https://www.lanqiao.cn/courses/1230/learning/
public class DeadLockDemo {
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void main(String[] args) {
        //这里使用lambda表达式创建了一个线程
        //线程  1
        new Thread(()->{
            synchronized (lockA){
                try {
                    //线程休眠一段时间  确保另外一个线程可以获取到b锁
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("D");
                synchronized(lockB){
                }
            }
        }).start();
        //线程2
        new Thread(()->{
            synchronized (lockB){
                System.out.println("死锁。。。");
                synchronized (lockA){
                }
            }
        }).start();
    }
}
