package com.jms.amq.customer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Author: wangdgang
 * @Date: 2018-01-08 11:42
 */
public class CustomerMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("receive-->" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
