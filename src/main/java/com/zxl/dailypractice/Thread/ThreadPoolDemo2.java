package com.zxl.dailypractice.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhao
 * @className ThreadPoolDemo2
 * @Description TODO
 * @Date 2021/11/30
 * @Version 1.0
 **/
//Java 线程池可以通过 Executors 工具类创建，Executors 常用方法：   https://www.lanqiao.cn/courses/1230/learning/
public class ThreadPoolDemo2 {
    private static ExecutorService executorService = new ThreadPoolExecutor(
            5,        //核心线程数为5
            10,  //最大线程数为10
            0L, TimeUnit.MILLISECONDS,   //非核心线程存活时间
            new LinkedBlockingQueue<>());          //任务队列

    public static void main(String[] args) {
        //提交任务
        executorService.submit(()->{
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        });
        //关闭线程池
        executorService.shutdown();
    }
}
