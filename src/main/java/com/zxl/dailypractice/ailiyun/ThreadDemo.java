package com.zxl.dailypractice.ailiyun;

/**
 * @author zhao
 * @className ThreadDemo
 * @Description TODO
 * @Date 2021/12/28
 * @Version 1.0
 **/
//生产电脑     https://developer.aliyun.com/learning/course/20/detail/300?spm=a2c6h.21258778.0.0.189b11a6dXgboP
public class ThreadDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(new Producer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }
}

class Producer implements Runnable{
    private Resource resource;
    public Producer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.make();
            }catch (Exception e){
             e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    private Resource resource;
    public Consumer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.get();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Computer{
    private static int count = 0; //表示生产的个数
    private String name;
    private double price;

    public Computer(String name, double price) {
        this.name = name;
        this.price = price;
        count++;
    }

    @Override
    public String toString() {
        return "第+"+count+"台电脑" +
                "电脑名字'" + name + '\'' +
                ", 价值" + price +
                '}';
    }
}

class Resource{
    private Computer computer;
    public synchronized void make() throws Exception{
        if (this.computer != null){
            super.wait();
        }
        Thread.sleep(100);
        this.computer = new Computer("zxl牌电脑",1.1);
        System.out.println("生产电脑" +this.computer);
        super.notifyAll();
    }
    public synchronized void get() throws Exception{
        if (this.computer == null){
            super.wait();
        }
        Thread.sleep(10);
        System.out.println("取走电脑" +this.computer);
        this.computer = null; //已经取走了
        super.notifyAll();
    }
}
