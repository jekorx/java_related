package com.jms.amq;

import com.jms.amq.producer.ProducerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wangdgang
 * @Date: 2018-01-08 11:06
 */
public class ProducerTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("amq-producer.xml");
        ProducerService producerService = context.getBean(ProducerService.class);
        for (int i = 0; i < 100; i++) {
            producerService.sendMessage("msg-->" + i);
        }
        context.close();
    }

}