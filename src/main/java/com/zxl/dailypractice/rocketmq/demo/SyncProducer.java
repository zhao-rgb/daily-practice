package com.zxl.dailypractice.rocketmq.demo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

public class SyncProducer {
    public static void main(String[] args) {
        try {
            // 创建生产者实例
            DefaultMQProducer producer = new DefaultMQProducer("producer_group");

            // 设置Nameserver地址
            producer.setNamesrvAddr("121.5.129.115:9876");

            // 启动生产者
            producer.start();

            // 创建一条消息
            Message message = new Message("hello", "tag_name", "赵肖龙hhh".getBytes());

            // 发送消息
            producer.send(message, 10000);

            // 休眠 1000 秒（这里可能是为了给足够的时间让消息发送完成）
            TimeUnit.SECONDS.sleep(1000);

            // 关闭生产者
            producer.shutdown();

            System.out.println("消息发送成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
