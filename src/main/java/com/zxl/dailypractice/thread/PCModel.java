package com.zxl.dailypractice.thread;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhao
 * @className PCModel
 * @Description TODO
 * @Date 2021/11/29
 * @Version 1.0
 **/
//生产者消费者模式编程实例    https://www.lanqiao.cn/courses/1230/learning/
public class PCModel {
    //阻塞队列
    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        //生产者
        Thread provider = new Thread(()->{
            Random random = new Random();
            for (int j = 0; j < 5; j++) {
                try {
                    int i = random.nextInt();
                    //注释直到插入数据
                    queue.put(i);
                    System.out.println("生产数据：" + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //消费者
        Thread consumer = new Thread(()->{
            Integer data;
            for (int i = 0; i < 5; i++) {
                try {
                   //阻塞直到取出数据
                    data = queue.take();
                    System.out.println("消费数据：" + data);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动线程
        provider.start();
        consumer.start();
    }
}
