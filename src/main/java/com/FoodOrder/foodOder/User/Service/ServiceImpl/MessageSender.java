//package com.FoodOrder.foodOder.User.Service.ServiceImpl;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MessageSender {
//	private final RabbitTemplate rabbitTemplate;
//	
//	@Value("${exchange.name}")
//	private String exchangeName;
//
//	@Value("${queue.name}")
//	private String queueName;
//
//	@Value("${routing.key}")
//	private String routingKey;
//
//    @Autowired
//    public MessageSender(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    public void sendMessage(String message) {
//        rabbitTemplate.convertAndSend(exchangeName, queueName, message);
//    }
//}
