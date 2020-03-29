package com.jpmc.trade.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TradeMessage")  
@PrimaryKeyJoinColumn(name="tradeId")  
public class TradeMessage extends Trade {
	
	private String messageId;
	@OneToOne(cascade = CascadeType.ALL)
	private PayerBank payerParty;
	@OneToOne(cascade = CascadeType.ALL)
	private ReceiverBank receiverParty;
	private String supportingInformation;

	public TradeMessage() {
		super();
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public PayerBank getPayerParty() {
		return payerParty;
	}

	public void setPayerParty(PayerBank payerParty) {
		this.payerParty = payerParty;
	}

	public ReceiverBank getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(ReceiverBank receiverParty) {
		this.receiverParty = receiverParty;
	}

	public String getSupportingInformation() {
		return supportingInformation;
	}

	public void setSupportingInformation(String supportingInformation) {
		this.supportingInformation = supportingInformation;
	}
	
	
	
}
