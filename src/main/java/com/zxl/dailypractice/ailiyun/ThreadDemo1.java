package com.zxl.dailypractice.ailiyun;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zhao
 * @className ThreadDemo1
 * @Description TODO
 * @Date 2021/12/28
 * @Version 1.0
 **/
//竞争抢答   https://developer.aliyun.com/learning/course/20/detail/301?spm=a2c6h.21258778.0.0.189b11a6dXgboP
public class ThreadDemo1 {
    public static void main(String[] args) throws Exception{
        MyThread myThread = new MyThread();
        FutureTask<String> taskA = new FutureTask<>(myThread);
        FutureTask<String> taskB = new FutureTask<>(myThread);
        FutureTask<String> taskC = new FutureTask<>(myThread);
        new Thread(taskA,"竞赛者A").start();
        new Thread(taskB,"竞赛者B").start();
        new Thread(taskC,"竞赛者C").start();
        System.out.println(taskA.get());
        System.out.println(taskB.get());
        System.out.println(taskC.get());

    }
}

class MyThread implements Callable<String>{
    private boolean flag = false;  //抢答处理

    @Override
    public String call() throws Exception {
        synchronized (this){
            if (this.flag ==  false){
                this.flag = true;
                return Thread.currentThread().getName() + "抢答成功！";
            } else {
                return Thread.currentThread().getName() + "抢答失败！";
            }
        }
    }
}
