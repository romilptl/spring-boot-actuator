package com.learning.monitoring.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class ScheduledTasks {

	@Scheduled(cron = "0 0/10 * * * ?")
	public void sendNotifications() {
		System.out.println("Sending notification to users...");
	}
	
	@Scheduled(fixedDelay = 60000) 
	public void scheduleTask_fixedDelay() {
		System.out.println("Running fixed delayed scheduled task...");
	}
	
	@Scheduled(fixedRate = 10000)
	public void scheduleTask_fixedRate() {
		System.out.println("Running fixed rated scheduled task...");
	}
}
