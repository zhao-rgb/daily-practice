package com.zxl.dailypractice.rocketmq.demo;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

public class Consumer {

    public static void main(String[] args) {
        try {
            // Create a consumer instance
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group");

            // Set the nameserver address
            consumer.setNamesrvAddr("81.69.18.228:9876");

            // Subscribe to a topic and tag
            consumer.subscribe("topic_name", "tag_name");

            // Set the message listener
            consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
                for (MessageExt msg : msgs) {
                    System.out.println("Received message: " + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });

            // Start the consumer
            consumer.start();

            System.out.println("Consumer started. Press Ctrl+C to exit.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
