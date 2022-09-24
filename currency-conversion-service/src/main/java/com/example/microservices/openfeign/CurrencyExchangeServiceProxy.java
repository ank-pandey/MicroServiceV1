package com.example.microservices.openfeign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservices.bean.CurrencyConversion;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "zuul-api-gateway-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	@GetMapping("currency-exchange-service/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String fromCurrency, 
			@PathVariable String toCurrency);	
}
