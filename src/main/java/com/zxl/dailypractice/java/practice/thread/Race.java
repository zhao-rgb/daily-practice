package com.zxl.dailypractice.java.practice.thread;

/**
 * @author zhao
 * @className Race
 * @Description TODO
 * @Date 2022/3/22
 * @Version 1.0
 **/
//Java多线程：龟兔赛跑 https://blog.csdn.net/daqiang012/article/details/103249995
public class Race implements Runnable{
    /**
     * 1、实例化两个线程
     * 2、判断谁是胜利者
     * 3、模拟兔子睡觉
     */

    // 胜利者
    private static String winner = null;

    @Override
    public void run() {
        for (int i = 1; i <= 150; i++) {
            //调节比赛速度
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //模拟兔子睡觉
            if ("兔子".equals(Thread.currentThread().getName()) && i % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "米");
        }

    }

    public boolean gameOver(int meters){
        //已经分出胜负
        if (winner != null){
            return true;
        }
        // 已经跑到终点
        if (meters == 100){
            winner = Thread.currentThread().getName();
            System.out.println("胜利者是：" + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        Thread thread1 = new Thread(race,"乌龟");
        Thread thread2 = new Thread(race,"兔子");
        thread1.start();
        thread2.start();
    }
}
