package com.cg.allyworld.chatsender.entity;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private RabbitMessagingTemplate template;

	public void send(int senderId, int receiverId, String message) {
		System.out.println(senderId + "" + receiverId + "" + message);
		template.convertAndSend("chatQ", new Object[] { senderId, receiverId, message });
	}

}
