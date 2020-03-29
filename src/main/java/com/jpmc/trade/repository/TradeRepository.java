package com.jpmc.trade.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpmc.trade.model.TradeMessage;

@Repository
public interface TradeRepository extends JpaRepository<TradeMessage, Long> {

	public Optional<TradeMessage> findByTradeId(Long tradeId);

}
