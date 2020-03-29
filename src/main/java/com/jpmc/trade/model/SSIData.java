package com.jpmc.trade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class SSIData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	private String ssiCode;
	private String payerAccountNumber;
	private String payerBank;
	private String receiverAccountNumber;
	private String receiverBank;
	private String supportingInformation;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsiCode() {
		return ssiCode;
	}

	public void setSsiCode(String ssiCode) {
		this.ssiCode = ssiCode;
	}

	public String getPayerAccountNumber() {
		return payerAccountNumber;
	}

	public void setPayerAccountNumber(String payerAccountNumber) {
		this.payerAccountNumber = payerAccountNumber;
	}

	public String getPayerBank() {
		return payerBank;
	}

	public void setPayerBank(String payerBank) {
		this.payerBank = payerBank;
	}

	public String getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(String receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public String getReceiverBank() {
		return receiverBank;
	}

	public void setReceiverBank(String receiverBank) {
		this.receiverBank = receiverBank;
	}

	public String getSupportingInformation() {
		return supportingInformation;
	}

	public void setSupportingInformation(String supportingInformation) {
		this.supportingInformation = supportingInformation;
	}
	
	
	
	
	
	

}
