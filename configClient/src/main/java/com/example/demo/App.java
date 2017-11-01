package com.example.demo;

import com.rabbitmq.client.*;

import java.io.IOException;

public class App {
    private final static String QUEUE_NAME = "hello";
    static boolean isBreak = false;

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.3.212");
        factory.setUsername("admin");
        factory.setPassword("admin123");
        factory.setPort(5672);
        System.out.println("begin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x]dsa Sent '" + message + "'");
        channel.close();
        connection.close();
    }
}
