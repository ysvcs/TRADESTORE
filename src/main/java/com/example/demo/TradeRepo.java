package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Trade;

public interface TradeRepo extends JpaRepository<Trade, Integer> {

}
