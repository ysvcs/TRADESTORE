package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.Date;

import com.example.demo.model.Trade;
import com.example.demo.service.TradeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


@ExtendWith(MockitoExtension.class)
class TradeServiceTests {
	
	@Mock
	TradeRepo tr;
	
	TradeService service;
	
	@Test
	void testSaveToDb() {
		
		Trade trade = new Trade("T2", 2, "CP-2", "b2", new Date(2022, 05, 20), new Date(2022, 05, 30), false);
		service.saveToDb(trade);
		verify(tr).save(trade);
	}
	
	@BeforeEach
	public void setUp() {
		this.service = new TradeService(this.tr);
		
	}

}
