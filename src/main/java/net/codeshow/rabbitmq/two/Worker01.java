package net.codeshow.rabbitmq.two;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import net.codeshow.rabbitmq.utils.RabbitMqUtils;

/**
 * @Description 这是一个工作线程，相当于之前的消费者
 * @Author eric
 * @Version V1.0.0
 * @Date 2021/6/18
 */
public class Worker01 {
    //队列名称
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //接收消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println(new String(message.getBody()));

        };

        //取消消息时的回调
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println(consumerTag + "消费者取消消费接口回调逻辑");
        };
        System.out.println("C2等待接收消息");
        channel.basicConsume(QUEUE_NAME, true,deliverCallback,cancelCallback);

    }
}
