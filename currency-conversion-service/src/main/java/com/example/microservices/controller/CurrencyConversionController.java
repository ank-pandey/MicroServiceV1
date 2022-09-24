package com.example.microservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.bean.CurrencyConversion;
import com.example.microservices.openfeign.CurrencyExchangeServiceProxy;

@RestController
@RequestMapping("/currency-converter")
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy serviceProxy;
	
	@GetMapping("/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String fromCurrency, 
			@PathVariable String toCurrency, @PathVariable BigDecimal quantity) {
		Map<String, String> variables = new HashMap<>();
		variables.put("fromCurrency", fromCurrency);
		variables.put("toCurrency", toCurrency);
		ResponseEntity<CurrencyConversion> entity = new RestTemplate()
		.getForEntity("http://localhost:8000/currency-exchange/from/{fromCurrency}/to/{toCurrency}", 
				CurrencyConversion.class, variables);
		CurrencyConversion response = entity.getBody();
		return new CurrencyConversion(response.getId(), fromCurrency, toCurrency, 
				response.getConversionRate(), quantity, 
				quantity.multiply(response.getConversionRate()), response.getPort());
	}
	
	@GetMapping("/feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeign(@PathVariable String fromCurrency, 
			@PathVariable String toCurrency, @PathVariable BigDecimal quantity) {
		CurrencyConversion response = serviceProxy.retrieveExchangeValue(fromCurrency, toCurrency);
		logger.info("{}", response);
		return new CurrencyConversion(response.getId(), fromCurrency, toCurrency, 
				response.getConversionRate(), quantity, 
				quantity.multiply(response.getConversionRate()), response.getPort());
	}
}
