package com.jpmc.trade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Trade")  
@Inheritance(strategy=InheritanceType.JOINED)  
public class Trade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tradeId", updatable = false, nullable = false)
	private long tradeId;
	private String ssiCode;
	private String currency;
	@DateTimeFormat(pattern="yyyyMMdd")
	private String valueDate;
	private double amount;
	
		
	public Trade() {
		super();
	}

	public long getTradeId() {
		return tradeId;
	}


	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}


	public String getSsiCode() {
		return ssiCode;
	}


	public void setSsiCode(String ssiCode) {
		this.ssiCode = ssiCode;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getValueDate() {
		return valueDate;
	}


	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}



	
	
	

}
