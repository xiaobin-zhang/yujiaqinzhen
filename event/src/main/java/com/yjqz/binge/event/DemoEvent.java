package com.yjqz.binge.event;

import org.springframework.context.ApplicationEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class DemoEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private String msg;
	
	public DemoEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}
	
}
