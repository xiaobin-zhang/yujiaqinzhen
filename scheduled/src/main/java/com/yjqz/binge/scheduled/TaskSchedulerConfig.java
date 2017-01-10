package com.yjqz.binge.scheduled;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.yjqz.binge.scheduled")
@EnableScheduling
public class TaskSchedulerConfig {

}
