package ooo.stock.StockPriceAlertSystem.repository;

import ooo.stock.StockPriceAlertSystem.model.AlertRule;
import ooo.stock.StockPriceAlertSystem.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRuleRepository extends JpaRepository<AlertRule, Long> {
    List<AlertRule> findByStatus(Status status);
}
