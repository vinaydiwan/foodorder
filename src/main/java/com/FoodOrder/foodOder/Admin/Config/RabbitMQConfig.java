//package com.FoodOrder.foodOder.Admin.Config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;
//import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
//
//@Configuration
//public class RabbitMQConfig {
//	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConfig.class);
//
//	@Value("${spring.rabbitmq.host:localhost}")
//	private String rabbitMqHost;
//
//	@Value("${spring.rabbitmq.port:5672}")
//	private int rabbitMqPort;
//
//	@Value("${spring.rabbitmq.username:guest}")
//	private String rabbitMqUser;
//
//	@Value("${spring.rabbitmq.password:guest}")
//	private String rabbitMqPass;
//
//	@Value("${spring.rabbitmq.virtual-host:/}")
//	private String virtualHost;
//
//	@Value("${spring.rabbitmq.ssl.enabled:false}")
//	private String sslenabled;
//
//	@Bean
//	com.rabbitmq.client.ConnectionFactory rabbitMqConnectionFactory() {
//		com.rabbitmq.client.ConnectionFactory connectionFactory = new com.rabbitmq.client.ConnectionFactory();
//		connectionFactory.setHost(rabbitMqHost);
//		connectionFactory.setPort(rabbitMqPort);
//		connectionFactory.setUsername(rabbitMqUser);
//		connectionFactory.setPassword(rabbitMqPass);
//		connectionFactory.setVirtualHost(virtualHost);
//
//		if ("true".equalsIgnoreCase(sslenabled)) {
//			try {
//				connectionFactory.useSslProtocol();
//			} catch (Exception e) {
//				logger.error("error while configuring connection factory ", e);
//			}
//		}
//
//		return connectionFactory;
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
//	SimpleRabbitListenerContainerFactory jsaFactory(ConnectionFactory connectionFactory,
//			SimpleRabbitListenerContainerFactoryConfigurer configuer) {
//		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//		configuer.configure(factory, connectionFactory);
//		factory.setMessageConverter(jsonMessageConverter());
//		return factory;
//	}
//
////    @Bean
////    CamelContext camelContext() {
////        CamelContext camelContext = new DefaultCamelContext();
////        camelContext.setStartupConditionStrategy(new DefaultStartupConditionStrategy());
////        return camelContext;
////    }
//	
////	@Bean
////    public CamelContext camelContext() {
////        return new DefaultCamelContext();
////    }
//}
