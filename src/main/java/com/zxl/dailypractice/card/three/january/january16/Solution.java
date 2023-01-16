package com.zxl.dailypractice.card.three.january.january16;

import java.text.DecimalFormat;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhaoxl
 * @date: 2023/1/13
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + " 被执行,线程名:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        String s = new Solution().dealRadio(2);
        System.out.println(s);
    }

    public String dealRadio(Object num){
        DecimalFormat df = new DecimalFormat("#.00");
        String result = df.format(num);
        if(result.startsWith(".")){
            result="0"+result;
        }
        return result;
    }
}
