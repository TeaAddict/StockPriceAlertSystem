package ooo.stock.StockPriceAlertSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@ConfigurationPropertiesScan
@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
public class StockPriceAlertSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceAlertSystemApplication.class, args);
	}

}
