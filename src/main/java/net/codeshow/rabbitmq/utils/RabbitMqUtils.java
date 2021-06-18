package net.codeshow.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Description
 * @Author eric
 * @Version V1.0.0
 * @Date 2021/6/18
 */
public class RabbitMqUtils {
    //得到一个连接的 channel
    public static Channel getChannel() throws Exception {
//创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("Hadoop02");
        factory.setUsername("eric");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        return channel;
    }
}