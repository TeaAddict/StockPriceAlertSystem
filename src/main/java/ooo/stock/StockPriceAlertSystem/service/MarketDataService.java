package ooo.stock.StockPriceAlertSystem.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MarketDataService {

    public BigDecimal getCurrentPrice(String ticker){
        return switch (ticker){
            case "AAPL" -> BigDecimal.valueOf(111);
            case "TSLA" -> BigDecimal.valueOf(122);
            default -> BigDecimal.valueOf(100);
        };
    }
}
