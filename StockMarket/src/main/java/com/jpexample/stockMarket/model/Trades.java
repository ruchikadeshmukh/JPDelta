package com.jpexample.stockMarket.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trades {
	
	private String stockSymbol;
	private Integer noofshares;
	private Double tradePrice;
	private String tradeType;
	private Date tradeDate;
	public Trades(){}
	public  Trades(String stockSymbol,Integer noofshares,Double tradePrice, String tradeType, Date tradeDate){
	this.stockSymbol=stockSymbol;
	this.noofshares=noofshares;
	this.tradePrice = tradePrice;
	this.tradeType=tradeType;
	this.tradeDate=tradeDate;
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public Integer getNoofshares() {
		return noofshares;
	}
	public void setNoofshares(Integer noofshares) {
		this.noofshares = noofshares;
	}
	public Double getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(Double tradePrice) {
		this.tradePrice = tradePrice;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	//Input Trades 
	public  List<Trades> stocksTrade(){
		List<Trades> tradesval = new ArrayList<Trades>();	
		Date currentD = new Date();
		tradesval.add(new Trades("TEA",3,18.0,"BUY",new Date(currentD .getTime() - (20 * 60 * 1000))));
		tradesval.add(new Trades("TEA",2,17.5,"SELL",new Date(currentD .getTime() - (10 * 60 * 1000))));
		
		tradesval.add(new Trades("POP",6,23.0,"BUY",new Date()));
		tradesval.add(new Trades("POP",3,20.0,"SELL",new Date()));
		
		tradesval.add(new Trades("JOE",3,18.0,"BUY",new Date(currentD .getTime() - (45 * 60 * 1000))));
		tradesval.add(new Trades("JOE",3,29.6,"SELL",new Date()));
		
		tradesval.add(new Trades("ALE",10,10.0,"BUY",new Date()));
		tradesval.add(new Trades("ALE",3,15.28,"SELL",new Date()));
		
		tradesval.add(new Trades("GIN",15,18.4,"BUY",new Date()));
		tradesval.add(new Trades("GIN",10,24.4,"SELL",new Date()));
		
				
		return tradesval;
		
	}
}
