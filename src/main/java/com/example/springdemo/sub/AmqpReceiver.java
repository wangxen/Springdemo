package com.example.springdemo.sub;

import com.example.springdemo.configure.AmqpConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AmqpReceiver {

    /**
     * 简单模式
     * @param msg
     */
    @RabbitListener(queues = AmqpConfiguration.SIMPLE_QUEUE)
    public void simpleReceive(String msg){
        System.out.println("接收消息："+msg);
    }

    /**
     * 发布/订阅模式
     * @param msg
     */
    @RabbitListener(queues = AmqpConfiguration.PS_QUEUE_1)
    public void psReceive1(String msg){
        System.out.println(AmqpConfiguration.PS_QUEUE_1+"接收消息："+msg);
    }

    //@RabbitListener(queues = AmqpConfiguration.PS_QUEUE_2)
    //public void psReceive2(String msg){
    //    System.out.println(AmqpConfiguration.PS_QUEUE_2+"接收消息："+msg);
    //}

    /**
     * 路由模式
     * @param msg
     */
    @RabbitListener(queues = AmqpConfiguration.ROUTING_QUEUE_1)
    public void routReceive1(String msg){
        System.out.println(AmqpConfiguration.ROUTING_QUEUE_1+"接收消息："+msg);
    }

    @RabbitListener(queues = AmqpConfiguration.ROUTING_QUEUE_2)
    public void routReceive2(String msg){
        System.out.println(AmqpConfiguration.ROUTING_QUEUE_2+"接收消息："+msg);
    }

    /**
     * 主题模式
     * @param msg
     */
    @RabbitListener(queues = AmqpConfiguration.TOPIC_QUEUE_1)
    public void topicReceive1(String msg){
        System.out.println(AmqpConfiguration.TOPIC_QUEUE_1+"接收消息："+msg);
    }

    @RabbitListener(queues = AmqpConfiguration.TOPIC_QUEUE_2)
    public void topicReceive2(String msg){
        System.out.println(AmqpConfiguration.TOPIC_QUEUE_2+"接收消息："+msg);
    }

}
