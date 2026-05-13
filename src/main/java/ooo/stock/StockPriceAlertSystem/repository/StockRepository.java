package ooo.stock.StockPriceAlertSystem.repository;

import ooo.stock.StockPriceAlertSystem.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository  extends JpaRepository<Stock, Long> {
}
