package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Scheduler;
import com.example.demo.service.SchedulerService;

@RestController
public class SchedulerController {
	@Autowired
	private SchedulerService sehedulerService;

	@GetMapping("/schedulers")
	private List<Scheduler> getAllOpenScheules() {
		return sehedulerService.getAllSchedulers();
	}
}
