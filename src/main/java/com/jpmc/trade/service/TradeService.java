package com.jpmc.trade.service;

import com.jpmc.trade.model.Trade;
import com.jpmc.trade.model.TradeMessage;

public interface TradeService {

	public TradeMessage createMarketsettlementMsg(Trade trade);
}
