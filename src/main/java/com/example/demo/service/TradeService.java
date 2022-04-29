package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.TradeRepo;
import com.example.demo.model.Trade;

@Component
@Scope(value="prototype")
public class TradeService {
	
	@Autowired
	TradeRepo tradeRepo;
	
	public void saveToDb(Trade trade) {
		
		tradeRepo.save(trade);
	}
}
