package com.zxl.dailypractice.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhao
 * @className ABQDemo
 * @Description TODO
 * @Date 2021/11/29
 * @Version 1.0
 **/
// 编程实战   https://www.lanqiao.cn/courses/1230/learning/
public class ABQDemo {
    //构建大小为10的阻塞队列
    private static ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for(int i = 1;i <= 10;i++){
                arrayBlockingQueue.add(i);
            }
        });
        thread1.start();
        try {
            //等待线程1执行完毕
            thread1.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(()->{
            //如果插入失败
            if(!arrayBlockingQueue.offer(11)) {
                System.out.println("插入元素11失败");
            }
            try {
                //一直阻塞直到插入元素11，注意这里阻塞的不是主线程，main方法还是继续运行
                arrayBlockingQueue.put(11);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread thread2 = new Thread(() ->{
            Integer element;
            System.out.println("开始出队：");
            //打印队列中的元素
            while ((element = arrayBlockingQueue.poll()) != null) {
                System.out.print("\t" + element);
            }
        });
        thread2.start();
    }
}
