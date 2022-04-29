package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.TradeRepo;
import com.example.demo.model.Trade;
import com.example.demo.model.TradeResponse;

@Service
public class TradeService {
	
	@Autowired
	TradeRepo tradeRepo;
	
	public TradeService(TradeRepo tradeRepo) {
		super();
		this.tradeRepo = tradeRepo;	
	}
	
	public TradeResponse saveToDb(Trade trade) {	
		return this.validateAndProcessData(trade);
	}
	
	private TradeResponse validateAndProcessData(Trade trade) {
		// TODO Auto-generated method stub
		List<Trade> trades = tradeRepo.findByTradeID(trade.getTradeID());
		int max=1;
		
		for(Trade tradeElement: trades) 
			max = max>tradeElement.getVersion()? max : tradeElement.getVersion();
		
		
		if(max>trade.getVersion()) 
			return new TradeResponse(201, "Lower verssion for trade is not allowed");
		
		
		else if (trade.getMaturityDate().compareTo(new Date() ) <0 ) 
			return new TradeResponse(202, "Maturity date is lesser than today's date");
		
		else if (max==trade.getVersion() && !(trades.isEmpty()) ) { 
			Trade tradeToUpdate = tradeRepo.findWhere(trade.getTradeID(), trade.getVersion()).get(0);
			Trade tradeToUpdateReference = tradeRepo.getOne(tradeToUpdate.getSerialNo());
			tradeToUpdateReference.setBookID(trade.getBookID());
			tradeToUpdateReference.setCounterPartyID(trade.getCounterPartyID());
			tradeToUpdateReference.setCreatedDate(trade.getCreatedDate());
			tradeToUpdateReference.setMaturityDate(trade.getMaturityDate());
			tradeToUpdateReference.setExpired(trade.isExpired());
			tradeRepo.save(tradeToUpdateReference);
			return new TradeResponse(200, "Successfully updated the entry");
		}
		else {
			tradeRepo.save(trade);
			return new TradeResponse(200, "Trade order accepted");
		}
	}
};