package com.example.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.bean.LimitConfiguration;
import com.example.microservices.configuration.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
	
	@GetMapping("/fault-tolerance-limits")
	@HystrixCommand(fallbackMethod = "fallBackRetrieveConfiguration")
	public LimitConfiguration retrieveConfiguration() {
		
		throw new RuntimeException("Not Available");
	}
	
	public LimitConfiguration fallBackRetrieveConfiguration() {
		
		return new LimitConfiguration(9,99);
	}
}
