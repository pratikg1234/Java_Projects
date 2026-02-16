package com.boot.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {
	
	//to use rabbitmq.queue.name we have to declare this in application.properties
	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.queue.json.name}")
	private String jsonQueue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchnage;
	
	@Value("${rabbitmq.routingkey.name}")
	private String routingKey;
	
	@Value("${rabbitmq.routingkey.json.name}")
	private String routingJsonKey;
	
	//spring bean for rabbitmq queue
	@Bean
	public Queue queue() {
		return new Queue(queue);
	}
	
	//queue for storing json data
	@Bean
	public Queue jsonQueue() {
		return new Queue(jsonQueue);
	}
	
	//spring bean for rabbitmq exchange
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchnage);
	}
	
	//Binding between queue with exchnage using a routing key
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue())
				.to(exchange())
				.with(routingKey);
	}
	
	//Binding between jsonQueue with exchnage using a routing key
	@Bean
	public Binding jsonBinding() {
		return BindingBuilder.bind(jsonQueue())
				.to(exchange())
				.with(routingJsonKey);
	}
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	//For RabbitTemplate to support Json communication
	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
	//ConnectionFactory, RabbitTemplate, RabbitAdmin these 3 beans will be autoconfigured by spring
	//We just need to inject & we can use
}
