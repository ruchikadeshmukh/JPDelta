package com.jpexample.stockMarket.action;

import java.util.Date;
import java.util.List;

import com.jpexample.stockMarket.model.StockDetails;
import com.jpexample.stockMarket.model.Trades;

public class Formulas {
	//Calculate PE Ratio
	public Double getPERatio(Double price ,Double dividend){		
		return price/dividend;		
	}
	//Calculate Dividend Yield
	public  Double getDividendYield(StockDetails stocks, Double price ){
	    Double divYield =0.0;
		if (stocks.getType().equalsIgnoreCase("Common")){
			divYield = stocks.getLastDividend()/price;
		}else if(stocks.getType().equalsIgnoreCase("Preferred"))
		{
			divYield = stocks.getFixedDividend()*stocks.getParValue()/price;
		}
		return divYield;
	}
	//Calculate GBCE Index
	public Double getGBCEIndex(Double tradedPrice,int noofstocks){
		return tradedPrice/noofstocks;
	}
	
	//Calculate Volume Weighted Stock Price
	public Double getVolumeWeightedStockPrice(List<Trades> stocktrade,String ssymbol){
		Double volumeWeightedStockPrice=0.0;
		Integer totalQuant=0;
		Double volStockPrice=0.0;
		Date currentD = new Date();

				Date startTime = new Date(currentD.getTime() - (15 * 60 * 1000));
		   for(Trades strade :stocktrade){
			  if (strade.getStockSymbol().equalsIgnoreCase(ssymbol)){
		 	if(strade.getTradeDate().compareTo(startTime)==1){
		 		totalQuant+=strade.getNoofshares();
		 		volStockPrice += strade.getNoofshares()*strade.getTradePrice();
		 		volumeWeightedStockPrice =volStockPrice/totalQuant;
			}
			  } 	
		   }
		     	   
		   return volumeWeightedStockPrice;
		}
	
}
