//package com.FoodOrder.foodOder.Admin.Config;
//
//import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.component.jackson.JacksonDataFormat;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import com.FoodOrder.foodOder.User.DTOs.Checkout;
//
//@Component
//public class RabbitMqConsumerRoute extends RouteBuilder{
//	private static final Logger logger = LoggerFactory.getLogger(RabbitMqConsumerRoute.class);
//	
//	@Value("${exchange.name}")
//	private String exchangeName = "foodorderexchange";
//
//	@Value("${queue.name}")
//	private String queueName = "foodorderqueue";
//
//	@Value("${routing.key}")
//	private String routingKey = "food.order";
//	
//	private int concurrentConsumers=1;
//
//	@Override
//	public void configure() throws Exception {
//		logger.debug("rabbitmq:" + exchangeName + "?queue=" + queueName + "&routingKey=" + routingKey +
//				"&exchangeType=direct&concurrentConsumers=" + concurrentConsumers + 
//				"&connectionFactory=rabbitMqConnectionFactory&autoDelete=false&exclusive=false&arg.queue.x-single-active-consumer=true");
//		
//		var jsonDataFormat = new JacksonDataFormat(Checkout.class);
//		from("direct:orderFood").id("orderFood").marshal(jsonDataFormat)
//		.to("rabbitmq:" + exchangeName + "?queue=" + queueName + "&routingKey=" + routingKey +
//				"&exchangeType=direct&concurrentConsumers=" + concurrentConsumers + 
//				"&connectionFactory=rabbitMqConnectionFactory&autoDelete=false&exclusive=false&arg.queue.x-single-active-consumer=true")
//		.end();
//		
//	}
//	
//}
