package com.jpexample.stockMarket.action;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jpexample.stockMarket.model.StockDetails;
import com.jpexample.stockMarket.model.Trades;

public class MainAction {

@SuppressWarnings("unchecked")
public static void main(String[] args) {
ApplicationContext context =  new AnnotationConfigApplicationContext(StockDetails.class);
Formulas formulas = new Formulas();
Trades trade = new Trades();
Double meanPrice =0.0;
int i =0;
List<Trades> stockTrades = trade.stocksTrade();
List<StockDetails> stocks = (List<StockDetails>) context.getBean("stocks");
SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss zzz");
for (StockDetails obj :stocks){
	// PE Ratio
	System.out.println("PERatio : "+formulas.getPERatio(12.5, obj.getLastDividend()));	
	// Dividend Yield
	System.out.println("Dividend Yield : "+formulas.getDividendYield(obj, 12.5));

	for (Trades trades :stockTrades){  
		if (obj.getStockSymbol().equalsIgnoreCase(trades.getStockSymbol()))
		{
	   if (trades.getTradeType().equalsIgnoreCase("BUY")){
		System.out.println(trades.getStockSymbol()+" bought "+trades.getNoofshares()+" shares for $"+trades.getTradePrice()+" on "+sdf.format(trades.getTradeDate()));
		meanPrice +=trades.getTradePrice();
		i+=1;
	   }else if (trades.getTradeType().equalsIgnoreCase("SELL")){
		System.out.println(trades.getStockSymbol()+" sold "+trades.getNoofshares()+" shares for $"+trades.getTradePrice()+" on "+sdf.format(trades.getTradeDate()));
		meanPrice +=trades.getTradePrice();
		i+=1;
	   }
	}
	}
	//Volume Weighted Stock Price for each Stock
	System.out.println("Volume Weighted Stock Price for "+obj.getStockSymbol()+": $"+formulas.getVolumeWeightedStockPrice(stockTrades,obj.getStockSymbol()));
	}
//GBCE All Share index
System.out.println("GBCE All Share index : $"+formulas.getGBCEIndex(meanPrice, i));
}

}