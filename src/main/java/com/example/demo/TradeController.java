package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Trade;
import com.example.demo.model.TradeResponse;
import com.example.demo.service.TradeService;

@RestController
public class TradeController {
	
	@Autowired
	TradeService tradeService;
	
	@PostMapping("/trade")
	public TradeResponse addTrades(@RequestBody Trade trade) {
		
		return tradeService.saveToDb(trade);
	}
}
