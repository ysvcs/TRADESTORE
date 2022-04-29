package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Trade;

@RestController
public class TradeController {
	
	@Autowired
	TradeRepo repo;
	
	@PostMapping("/trade")
	public String addTrades(@RequestBody Trade trade) {
		
		repo.save(trade);
		return "ok";
	}
}
