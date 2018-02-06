package com.jms.amq;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wangdgang
 * @Date: 2018-01-08 11:06
 */
public class CustomerTest {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        new ClassPathXmlApplicationContext("amq-customer.xml");
    }

}