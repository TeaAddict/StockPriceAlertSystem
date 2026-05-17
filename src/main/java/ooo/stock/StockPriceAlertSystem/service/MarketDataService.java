package ooo.stock.StockPriceAlertSystem.service;

import lombok.extern.slf4j.Slf4j;
import ooo.stock.StockPriceAlertSystem.config.FinnhubClient;
import ooo.stock.StockPriceAlertSystem.config.FinnhubConfig;
import ooo.stock.StockPriceAlertSystem.dto.FinnhubQuoteResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
@Slf4j
public class MarketDataService {

    private final FinnhubClient finnhubClient;
    private final FinnhubConfig config;
    private final Executor executor;

    @Value("${market.use-fake-data}")
    private boolean useFakeData;

    public MarketDataService(FinnhubClient finnhubClient, FinnhubConfig config, @Qualifier("priceExecutor") Executor executor){
        this.finnhubClient = finnhubClient;
        this.config = config;
        this.executor = executor;
    }

    // TODO Move to another service, when same bean calls method it does not cache
    public BigDecimal getCurrentPrice(String ticker){

        log.info("Fetching real prices, for {}", ticker);
        FinnhubQuoteResponse response = finnhubClient.getQuote(ticker, config.getApiKey());
        return response.c();
    }

    public CompletableFuture<BigDecimal> getCurrentPriceAsync(String ticker){
        return useFakeData
                ? CompletableFuture.supplyAsync(() -> getCurrentPriceFake(ticker), executor)
                : CompletableFuture.supplyAsync(() -> getCurrentPrice(ticker), executor);
    }

    // TODO Move to another service, when same bean calls method it does not cache
    @Cacheable(value = "stockPrices", key = "#ticker")
    public BigDecimal getCurrentPriceFake(String ticker){
        log.info("Fetching fake prices, for {}", ticker);
        return switch (ticker){
            case "AAPL" -> BigDecimal.valueOf(501);
            case "TSLA" -> BigDecimal.valueOf(122);
            default -> BigDecimal.valueOf(100);
        };
    }
}
