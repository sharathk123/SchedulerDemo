package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Scheduler;

public interface SchedulerRepository extends CrudRepository<Scheduler, Integer> {

	Iterable<Scheduler> findByStatus(String string);

}
