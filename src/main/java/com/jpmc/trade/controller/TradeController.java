package com.jpmc.trade.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.trade.model.Trade;
import com.jpmc.trade.model.TradeMessage;
import com.jpmc.trade.repository.TradeRepository;
import com.jpmc.trade.service.TradeService;
import com.jpmc.trde.exception.TradeNotFoundException;

@RestController
@RequestMapping(path = "/trades")
public class TradeController {

	@Autowired
	private TradeService tradeServiceImpl;
	@Autowired
	private TradeRepository tradeRepository;

	@GetMapping(path = "/trade/{tradeId}")
	public Optional<TradeMessage> retriveTrade(@PathVariable Long tradeId) {

		Optional<TradeMessage> trademessage = tradeRepository.findByTradeId(tradeId);
		
		trademessage.orElseThrow(()-> new TradeNotFoundException("Trade Market settlement message not found for given tradeId: " + tradeId));

		return trademessage;
	}

	@PostMapping(path = "/trade")
	public ResponseEntity<TradeMessage> createMarketsettlementMsg(@RequestBody Trade trade) {
		return ResponseEntity.ok().body(tradeServiceImpl.createMarketsettlementMsg(trade));
	}

}
