//package com.FoodOrder.foodOder.Admin.Config;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;
//import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
//
//@Configuration
//@EnableRabbit
//public class RabbitMqCamelConfig {
//	@Value("${exchange.name}")
//	private String exchangeName = "foodorderexchange";
//
//	@Value("${queue.name}")
//	private String queueName = "foodorderqueue";
//
//	@Value("${routing.key}")
//	private String routingKey = "food.order";
//
//	@Bean
//	DirectExchange exchange() {
//		return new DirectExchange(exchangeName);
//	}
//
//	@Bean
//	Queue queue() {
//		return new Queue(queueName, true);
//	}
//
//	@Bean
//	Binding binding() {
//		return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
//	}
//
//	@Bean
//	MessageConverter jsonMessageConverter() {
//		return new Jackson2JsonMessageConverter();
//	}
//
//	@Bean
//	MappingJackson2MessageConverter consumerJackson2MessageCnverter() {
//		return new MappingJackson2MessageConverter();
//	}
//
//	@Bean
//	DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
//		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
//		factory.setMessageConverter(consumerJackson2MessageCnverter());
//		return factory;
//	}
//
//	@Bean
//	AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//		rabbitTemplate.setMessageConverter(jsonMessageConverter());
//		return rabbitTemplate;
//	}
//
//	@Bean
//	RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//		return new RabbitAdmin(connectionFactory);
//	}
//}
