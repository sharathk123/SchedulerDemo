package com.example.demo.scheduler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Scheduler;
import com.example.demo.service.SchedulerService;

@Component
public class TaskSchedulerService {

	@Autowired
	private SchedulerService schedulerService;

	public void scheduleTasks(ThreadPoolTaskScheduler taskScheduler) {
		List<Scheduler> appSchedules = this.schedulerService.getAllSchedulers();
		
		for (Scheduler sch : appSchedules) {
			taskScheduler.schedule(new RunnableTask("Scheduler" + sch.getId()),
					new Date(sch.getStart_date().getTime()));
		}
	}

	class RunnableTask implements Runnable {
		private String message;

		public RunnableTask(String message) {
			this.message = message;
		}

		@Override
		public void run() {
			System.out.println("Runnable Task with " + message);
		}
	}
}
