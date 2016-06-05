package com.jpexample.stockMarket.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;

public class StockDetails {
	
	private String stockSymbol;
	private String type;
	private Double lastDividend;
	private Double fixedDividend;
	private Integer	parValue;
	private List<Trades> trades;
	
		public StockDetails(){		
		}
		public StockDetails(String stockSymbol,String type,Double lastDividend,Double  fixedDividend,Integer parValue){
		this.stockSymbol=stockSymbol;
		this.type=type;
		this.lastDividend=lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public Double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public Integer getParValue() {
		return parValue;
	}
	public void setParValue(Integer parValue) {
		this.parValue = parValue;
	}
	public List<Trades> getTrades() {
		return trades;
	}
	public void setTrades(List<Trades> trades) {
		this.trades = trades;
	}
	//Stocks Available
	@Bean
	public List<StockDetails> stocks(){
		List<StockDetails> stocksval = new ArrayList<StockDetails>();		
		stocksval.add(new StockDetails("TEA","Common", 0.0, 0.0, 100));
		stocksval.add(new StockDetails("POP", "Common", 8.0, 0.0, 100));
		stocksval.add( new StockDetails("ALE", "Common", 23.0, 0.0, 60));
		stocksval.add( new StockDetails("GIN","Preferred", 8.0, 0.2, 100));
		stocksval.add( new StockDetails("JOE", "Common", 13.0, 0.0, 250));					
		return stocksval;		
	}
	
	

}
