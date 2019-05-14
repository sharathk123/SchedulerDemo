package com.example.demo.scheduler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.example.demo.domain.DeamonConfig;
import com.example.demo.service.DeamonConfigService;

/**
 * Gets the polling interval from Database and initializes the
 * ThreadPoolTaskScheduler.
 * 
 * @author sharath
 */
@Component
public class DeamonConfigScheduler implements SchedulingConfigurer {
	@Autowired
	private DeamonConfigService deamonConfigService;

	@Autowired
	private TaskSchedulerService taskSchedulerService;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(10);
		taskScheduler.initialize();

		taskRegistrar.setTaskScheduler(taskScheduler);
		taskRegistrar.addTriggerTask(new Runnable() {
			@Override
			public void run() {
				System.out.println("Scheduling the task -->");
				taskSchedulerService.scheduleTasks(taskScheduler);
			}
		}, new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {

				// String cronExp = "0/1 * * * * ?";
				// Can be pulled from a db. This will run every minute
				DeamonConfig deamonConfig = new DeamonConfig();
				try {
					deamonConfig = deamonConfigService.getRefreshInterval().get();
				} catch (RuntimeException e) {
				}

				String refreshInterval = null;
				// Hack
				if (deamonConfig.getRefreshInterval() == null) {
					refreshInterval = "5";
				} else {
					refreshInterval = deamonConfig.getRefreshInterval();
				}

				StringBuilder cronExp = new StringBuilder("0/").append(refreshInterval).append(" * * * * ?");
				return new CronTrigger(cronExp.toString()).nextExecutionTime(triggerContext);
			}
		});
	}
}
