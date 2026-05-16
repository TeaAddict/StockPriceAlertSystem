package ooo.stock.StockPriceAlertSystem.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "finnhub")
@Getter
@Setter
public class FinnhubConfig {
    private String apiKey;
    private String baseUrl;
}
