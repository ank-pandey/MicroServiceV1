package com.example.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.bean.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {

	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsFromConfiguration() {
		
		return new LimitsConfiguration(1000, 1);
	}
}
