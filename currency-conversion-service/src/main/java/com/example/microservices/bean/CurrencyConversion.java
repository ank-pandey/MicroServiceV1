package com.example.microservices.bean;

import java.math.BigDecimal;

public class CurrencyConversion {

	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal conversionRate;
	private BigDecimal quantity;
	private BigDecimal convertedAmount;
	private Integer port;
	
	public CurrencyConversion() {
		
	}
	public CurrencyConversion(Long id, String fromCurrency, String toCurrency, BigDecimal conversionRate,
			BigDecimal quantity, BigDecimal convertedAmount, Integer port) {
		super();
		this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionRate = conversionRate;
		this.quantity = quantity;
		this.convertedAmount = convertedAmount;
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}	
}
