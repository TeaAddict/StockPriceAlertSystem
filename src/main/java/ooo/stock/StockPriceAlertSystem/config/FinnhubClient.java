package ooo.stock.StockPriceAlertSystem.config;

import ooo.stock.StockPriceAlertSystem.dto.FinnhubQuoteResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class FinnhubClient {
    private final WebClient webClient;

    public FinnhubClient(@Qualifier("finnhubWebClient") WebClient webClient){
        this.webClient = webClient;
    }

    public FinnhubQuoteResponse getQuote(String ticker, String apiKey){
        return webClient.get()
                .uri(uri -> uri
                        .path("/quote")
                        .queryParam("symbol", ticker)
                        .queryParam("token", apiKey)
                        .build()
                ).retrieve()
                .bodyToMono(FinnhubQuoteResponse.class)
                .block();
    }

}
