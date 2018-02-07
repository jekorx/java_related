package com.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 使用JavaConfig的形式配置WebSocket全局的配置信息
 * @author wang_donggang
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	
	// 添加一个服务端点，来接收客户端的连接
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// 添加了一个/socket端点，客户端就可以通过这个端点来进行连接
		registry.addEndpoint("/socket")
			// 开启SockJS支持
			.withSockJS();
	}
	
	// 定义消息代理，设置消息连接请求的各种规范信息
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 客户端接收服务端消息的地址的前缀信息
		registry.enableSimpleBroker("/topic");
		// 客户端给服务端发消息的地址的前缀
        registry.setApplicationDestinationPrefixes("/app");
	}

}
