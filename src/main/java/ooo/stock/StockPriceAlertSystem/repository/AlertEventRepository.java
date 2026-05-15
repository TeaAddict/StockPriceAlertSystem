package ooo.stock.StockPriceAlertSystem.repository;

import ooo.stock.StockPriceAlertSystem.model.AlertEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertEventRepository extends JpaRepository<AlertEvent, Long> {
}
