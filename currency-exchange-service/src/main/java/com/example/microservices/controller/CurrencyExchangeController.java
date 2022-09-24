package com.example.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.ExchangeValueRepository;
import com.example.microservices.bean.ExchangeValue;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeRepo;
	
	@GetMapping("/from/{fromCurrency}/to/{toCurrency}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String fromCurrency, 
			@PathVariable String toCurrency) {
		ExchangeValue exchangeValue = exchangeRepo.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("{}", exchangeValue);
		return exchangeValue;
	}
}
