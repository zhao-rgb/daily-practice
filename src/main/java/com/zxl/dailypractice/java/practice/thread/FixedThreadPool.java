package com.zxl.dailypractice.java.practice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhao
 * @className FixedThreadPool
 * @Description TODO
 * @Date 2022/4/9
 * @Version 1.0
 **/
//线程池      https://www.liaoxuefeng.com/wiki/1252599548343744/1306581130018849
public class FixedThreadPool {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池:
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // 关闭线程池:
        es.shutdown();
    }
}

class Task implements Runnable{
    private final String name;

    public Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task" + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end task " + name);
    }
}
