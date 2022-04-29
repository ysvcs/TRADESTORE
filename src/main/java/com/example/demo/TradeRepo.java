package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Trade;

public interface TradeRepo extends JpaRepository<Trade, Integer> {
	
	List<Trade> findByTradeID(String tradeId);
	
	@Query("FROM Trade WHERE tradeID=?1 AND version=?2")
	List<Trade> findWhere(String tradeId, int version);
		
}
