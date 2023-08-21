package com.zxl.dailypractice.rocketmq.demo;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

public class Consumer {

    public static void main(String[] args) {
        try {
            // 创建消费者实例
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group");

            // 设置Nameserver地址
            consumer.setNamesrvAddr("121.5.129.115:9876");

            // 订阅一个Topic和标签
            consumer.subscribe("hello", "tag_name");

            // 设置消息监听器
            consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
                for (MessageExt msg : msgs) {
                    System.out.println("接收到消息: " + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });

            // 启动消费者
            consumer.start();

            System.out.println("消费者已启动。按 Ctrl+C 可退出。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
