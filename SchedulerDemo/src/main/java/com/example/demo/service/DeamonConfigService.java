package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DeamonConfigRepository;
import com.example.demo.domain.DeamonConfig;

@Service
public class DeamonConfigService {
	@Autowired
	private DeamonConfigRepository deamonConfigRepository;

	public Optional<DeamonConfig> getRefreshInterval() {
		return (Optional<DeamonConfig>) deamonConfigRepository.findById(1);
	}
}
