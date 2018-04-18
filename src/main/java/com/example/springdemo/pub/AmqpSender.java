package com.example.springdemo.pub;

import com.example.springdemo.configure.AmqpConfiguration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmqpSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 简单模式发送
     * @param msg
     */
    public void simpleSend(String msg){
        this.amqpTemplate.convertAndSend(AmqpConfiguration.SIMPLE_QUEUE,msg);
    }

    /**
     * 发布/订阅模式
     * @param msg
     */
    public void psSend(String msg){
        this.amqpTemplate.convertAndSend(AmqpConfiguration.FANOUT_EXCHANGE,"",msg);
    }

    /**
     * 路由模式
     * @param msg
     * @param routingKey
     */
    public void routSend(String msg,String routingKey){
        this.amqpTemplate.convertAndSend(AmqpConfiguration.DIRECT_EXCHANGE,routingKey,msg);
    }

    /**
     * 主题模式
     * @param msg
     * @param routingKey
     */
    public void topicSend(String msg,String routingKey){
        this.amqpTemplate.convertAndSend(AmqpConfiguration.TOPIC_EXCHANGE,routingKey,msg);
    }

}
