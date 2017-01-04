package com.yjqz.binge.scheduled;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yjqz.binge.thread.TaskExecutorConfig;

public class Main {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class,TaskExecutorConfig.class);
	}
}
