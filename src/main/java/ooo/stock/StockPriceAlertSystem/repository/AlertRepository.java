package ooo.stock.StockPriceAlertSystem.repository;

import ooo.stock.StockPriceAlertSystem.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
}
