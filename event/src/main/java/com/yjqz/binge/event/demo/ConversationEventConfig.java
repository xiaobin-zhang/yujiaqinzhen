package com.yjqz.binge.event.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan("com.yjqz.binge.event.demo")
public class ConversationEventConfig {

	@Bean
	public ObjectMapper json2Object (){
		return new ObjectMapper();
	}
}
