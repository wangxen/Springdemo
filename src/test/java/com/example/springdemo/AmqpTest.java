package com.example.springdemo;

import com.example.springdemo.pub.AmqpSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpTest {

    @Autowired
    private AmqpSender sender;

    @Test
    public void testSimpleSend(){
        for (int i=0; i<5; i++){
            this.sender.simpleSend("test simpleSend "+i);
        }
    }

    @Test
    public void testPsSend(){
        for (int i=5; i<10; i++){
            this.sender.psSend("test psSend "+i);
        }
    }

    @Test
    public void testRoutSend(){
        for (int i=5; i<10; i++)
            this.sender.routSend("test routSend "+i,"order");
    }

    @Test
    public void testTopicSend(){
        for (int i=10; i<15; i++)
            this.sender.topicSend("test topicSend "+i,"user.add");
    }

}
