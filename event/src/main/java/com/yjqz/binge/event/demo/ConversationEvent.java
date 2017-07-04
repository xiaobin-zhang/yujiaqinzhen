package com.yjqz.binge.event.demo;

import org.springframework.context.ApplicationEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ConversationEvent extends ApplicationEvent{

	public ConversationEvent(Object source) {
		super(source);
	}

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String content;
	
	private String usedLanguage = "zh";
	
}
