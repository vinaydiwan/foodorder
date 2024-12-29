//package com.FoodOrder.foodOder.Admin.Config;
//
//import java.io.ByteArrayOutputStream;
//import java.io.ObjectOutputStream;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//
//@Component
//public class MessageProducer {
//	private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);
//
//	@Value("${spring.rabbitmq.host}")
//	private String rabbitMqHost;
//
//	@Value("${spring.rabbitmq.port}")
//	private int rabbitMqPort;
//
//	@Value("${spring.rabbitmq.username}")
//	private String rabbitMqUser;
//
//	@Value("${spring.rabbitmq.password}")
//	private String rabbitMqPass;
//
//	@Value("${spring.rabbitmq.virtual-host}")
//	private String virtualHost;
//
//	@Value("${spring.rabbitmq.ssl.enabled}")
//	private String sslenabled;
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
//	private ConnectionFactory connectionFactory= null;
//	public void sendMessage(Object data) {
//		try {
//			if(connectionFactory == null) {
//				connectionFactory = new ConnectionFactory();
//				connectionFactory.setHost(rabbitMqHost);
//				connectionFactory.setPort(rabbitMqPort);
//				connectionFactory.setUsername(rabbitMqUser);
//				connectionFactory.setPassword(rabbitMqPass);
//				connectionFactory.setVirtualHost(virtualHost);
//				if(sslenabled.equalsIgnoreCase("true")) {
//					connectionFactory.useSslProtocol();
//				}
//				
//				try(Connection connection = connectionFactory.newConnection(); Channel channel = connection.createChannel()) {
//					channel.queueDeclare(exchangeName, false, false, false, null);
//					channel.queueBind(queueName, exchangeName, routingKey);
//					ByteArrayOutputStream bos = new ByteArrayOutputStream();
//					ObjectOutputStream oos = new ObjectOutputStream(bos);
//					oos.writeObject(data);
//					oos.flush();
//					byte[] dataBytes = bos.toByteArray();
//					channel.basicPublish("", routingKey, null, dataBytes);
//				}
//			}
//		} catch(Exception e) {
//			logger.error("Error in message producer: ", e);
//		}
//	}
//}
