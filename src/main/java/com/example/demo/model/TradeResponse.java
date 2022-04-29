package com.example.demo.model;

public class TradeResponse {
	
	private int statusCode;
	private String responseMessage;
	
	
	public TradeResponse(int statusCode, String responseMessage) {
		super();
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
	}
	
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}
