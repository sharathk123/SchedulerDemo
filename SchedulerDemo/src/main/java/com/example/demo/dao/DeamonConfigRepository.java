package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.DeamonConfig;

public interface DeamonConfigRepository extends CrudRepository<DeamonConfig, Integer> {
}
