package ooo.stock.StockPriceAlertSystem;

import ooo.stock.StockPriceAlertSystem.config.FinnhubConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableConfigurationProperties(FinnhubConfig.class)
@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
public class StockPriceAlertSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceAlertSystemApplication.class, args);
	}

}
