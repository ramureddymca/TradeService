package com.jpmc.trade.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.trade.model.PayerBank;
import com.jpmc.trade.model.ReceiverBank;
import com.jpmc.trade.model.SSIData;
import com.jpmc.trade.model.Trade;
import com.jpmc.trade.model.TradeMessage;
import com.jpmc.trade.repository.SSIDataRepository;
import com.jpmc.trade.repository.TradeRepository;
import com.jpmc.trade.util.TradeUtil;
import com.jpmc.trde.exception.SSIDataNotFoundException;
import com.jpmc.trde.exception.TradeDuplicateException;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeRepository tradeRepository;
	@Autowired
	SSIDataRepository ssiDataRepository;

	@Override
	public TradeMessage createMarketsettlementMsg(Trade trade) {
		Optional<TradeMessage> optionalTrademessage =tradeRepository.findByTradeId(trade.getTradeId());
		if(optionalTrademessage.isPresent()) {
			throw new TradeDuplicateException("Trade message allready exit with the given tradeId: "+trade.getTradeId());
		}
		
		TradeMessage tradeMessage = getTradeMessage(trade);
		tradeRepository.save(tradeMessage);
		return tradeMessage;
	}

	private TradeMessage getTradeMessage(Trade trade) {

		SSIData ssidata = ssiDataRepository.findBySsiCode(trade.getSsiCode());
		if(ssidata == null ) {
			throw new SSIDataNotFoundException("Trade Market settlement message not found for given ssiCode: " + trade.getSsiCode());
		}
		TradeMessage tradeMessage = new TradeMessage();
		tradeMessage.setTradeId(trade.getTradeId());
		tradeMessage.setMessageId(TradeUtil.generateUUID());
		tradeMessage.setAmount(trade.getAmount());
		tradeMessage.setValueDate(trade.getValueDate());
		tradeMessage.setCurrency(trade.getCurrency());
		PayerBank payerBank = new PayerBank();
		payerBank.setAccountNumber(ssidata.getPayerAccountNumber());
		payerBank.setBankCode(ssidata.getPayerBank());
		tradeMessage.setPayerParty(payerBank);		
		ReceiverBank reciverBank = new ReceiverBank();		
		reciverBank.setAccountNumber(ssidata.getReceiverAccountNumber());
		reciverBank.setBankCode(ssidata.getReceiverBank());
		tradeMessage.setReceiverParty(reciverBank);
		tradeMessage.setSupportingInformation(ssidata.getSupportingInformation());
		return tradeMessage;
	}

}
