package ooo.stock.StockPriceAlertSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class AsyncConfig {

    @Bean
    public Executor priceExecutor(){
        return Executors.newFixedThreadPool(10);
    }
}
