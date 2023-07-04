package com.zxl.dailypractice.rocketmq.demo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

public class SyncProducer {
    public static void main(String[] args) {
        try {
            // Create a producer instance
            DefaultMQProducer producer = new DefaultMQProducer("producer_group");

            // Set the nameserver address
            producer.setNamesrvAddr("81.69.18.228:9876");

            // Start the producer
            producer.start();

            // Create a message
            Message message = new Message("topic_name", "tag_name", "赵肖龙hhh".getBytes());

            // Send the message
            producer.send(message,10000);

            TimeUnit.SECONDS.sleep(1000);
            // Shut down the producer
            producer.shutdown();

            System.out.println("Message sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
