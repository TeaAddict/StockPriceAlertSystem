package ooo.stock.StockPriceAlertSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StockPriceAlertSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceAlertSystemApplication.class, args);
	}

}
