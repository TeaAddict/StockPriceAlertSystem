package ooo.stock.StockPriceAlertSystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ooo.stock.StockPriceAlertSystem.config.FinnhubClient;
import ooo.stock.StockPriceAlertSystem.config.FinnhubConfig;
import ooo.stock.StockPriceAlertSystem.dto.FinnhubQuoteResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
@Slf4j
public class MarketDataService {

    private final FinnhubClient finnhubClient;
    private final FinnhubConfig config;

    public BigDecimal getCurrentPrice(String ticker){
        FinnhubQuoteResponse response = finnhubClient.getQuote(ticker, config.getApiKey());
        return response.c();
    }

    public BigDecimal getCurrentPriceFake(String ticker){
        return switch (ticker){
            case "AAPL" -> BigDecimal.valueOf(501);
            case "TSLA" -> BigDecimal.valueOf(122);
            default -> BigDecimal.valueOf(100);
        };
    }
}
