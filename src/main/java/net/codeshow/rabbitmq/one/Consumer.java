package net.codeshow.rabbitmq.one;

import com.rabbitmq.client.*;

import java.util.Arrays;

/**
 * @Description
 * @Author eric
 * @Version V1.0.0
 * @Date 2021/6/18
 */
public class Consumer {
    //队列名称
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("Hadoop02");
        //用户名
        factory.setUsername("eric");
        //密码
        factory.setPassword("123456");
        //创建连接
        Connection connection = factory.newConnection();
        //获取信道
        Channel channel = connection.createChannel();
        /*
        消费者消费消息
        1. 消费哪个队列
        2. 消费成功之后是否要自动应答 true代表自动应答  false 手动应答
        3. 消费者未成功消费的回调
        4. 消费者取消消费的回调
         */

        //接收消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println(new String(message.getBody()));

        };
        //取消消息时的回调
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("消息消费被中断");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback,cancelCallback);
    }
}
