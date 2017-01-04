package com.yjqz.binge.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	@Async
	@Scheduled(fixedDelay = 1000)
	public void reportCurrentTime() {
		System.out.println(Thread.currentThread().getName() + " fixedDelay 每个5秒执行一次 " + DATE_FORMAT.format(new Date()));
	}
	
	@Async
	@Scheduled(cron = "0 28 11 ? * *")
	public void fixTimeExecution() {
		System.out.println(Thread.currentThread().getName() + " 在指定时间 " + DATE_FORMAT.format(new Date()) + "执行");
	}
	
	@Async
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime2() throws Exception {
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName() + " fixedRate 每个5秒执行一次 " + DATE_FORMAT.format(new Date()));
	}
}
