package com.jms.amq.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * @Author: wangdgang
 * @Date: 2018-01-08 10:54
 */
public class ProducerServiceImpl implements ProducerService {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name = "queueDestination")
    private Destination destination;

    public void sendMessage(final String message) {
        // 使用jmsTemplate发送消息
        /*jmsTemplate.send(String.valueOf(destination), new MessageCreator() {
            // 创建消息
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                System.out.println("send: " + textMessage.getText() );
                return textMessage;
            }
        });*/
        jmsTemplate.send(String.valueOf(destination), (session) -> {
            TextMessage textMessage = session.createTextMessage(message);
            System.out.println("send: " + textMessage.getText() );
            return textMessage;
        });
    }

}
