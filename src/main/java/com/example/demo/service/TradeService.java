package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.TradeRepo;
import com.example.demo.model.Trade;

@Service
public class TradeService {
	
	@Autowired
	TradeRepo tradeRepo;
	
	public TradeService(TradeRepo tradeRepo) {
		super();
		this.tradeRepo = tradeRepo;	
	}
	
	public void saveToDb(Trade trade) {	
		tradeRepo.save(trade);
	}
}
