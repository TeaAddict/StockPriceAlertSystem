package ooo.stock.StockPriceAlertSystem.repository;

import ooo.stock.StockPriceAlertSystem.model.AlertRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRuleRepository extends JpaRepository<AlertRule, Long> {
}
