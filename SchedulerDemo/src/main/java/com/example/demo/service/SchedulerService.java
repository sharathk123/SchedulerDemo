package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SchedulerRepository;
import com.example.demo.domain.Scheduler;

@Service
public class SchedulerService {

	@Autowired
	private SchedulerRepository schedulerRepository;

	public List<Scheduler> getAllSchedulers() {
		List<Scheduler> schedulers = new ArrayList<Scheduler>();
		schedulerRepository.findByStatus("OPEN").forEach(scheduler -> schedulers.add(scheduler));
		return schedulers;
	}
}
