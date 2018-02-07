package com.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WsController {
	
	// Spring-WebSocket内置的一个消息发送工具，可以将消息发送到指定的客户端
	//@Autowired
	//private SimpMessagingTemplate simpMessagingTemplate;
	
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){        
        return "hello";
    } 
	
	@RequestMapping(value = "/ws",method = RequestMethod.GET)
	public String ws(){        
		return "ws";
	} 
	
	// WebSocket请求映射注解，功能类似于@RequestMapping
	@MessageMapping("/msg")
	@SendTo("/topic/msg")
	public String msg(String msg) {
		return msg;
	}
	
}
