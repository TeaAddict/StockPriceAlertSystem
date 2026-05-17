package ooo.stock.StockPriceAlertSystem.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ooo.stock.StockPriceAlertSystem.model.AlertEvent;
import ooo.stock.StockPriceAlertSystem.model.AlertRule;
import ooo.stock.StockPriceAlertSystem.model.Status;
import ooo.stock.StockPriceAlertSystem.repository.AlertEventRepository;
import ooo.stock.StockPriceAlertSystem.repository.AlertRuleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class AlertEngineService {

    private final AlertRuleRepository alertRuleRepository;
    private final AlertEventRepository alertEventRepository;
    private final MarketDataService marketDataService;

    @Value("${market.use-fake-data}")
    private boolean useFakeData;

    @Transactional
    public void processAlerts(){
        List<AlertRule> activeAlertRules = alertRuleRepository.findByStatus(Status.ACTIVE);

        Map<String, List<AlertRule>> groupedAlertRules = activeAlertRules.stream().collect(Collectors.groupingBy(AlertRule::getTicker));

        for (Map.Entry<String, List<AlertRule>> entry : groupedAlertRules.entrySet()){
            log.info("Getting price for {}", entry.getKey());
            BigDecimal price = useFakeData
                    ? marketDataService.getCurrentPriceFake(entry.getKey())
                    : marketDataService.getCurrentPrice(entry.getKey());
            evaluateRules(price, entry.getValue());
        }
    }

    private void evaluateRules(BigDecimal currentPrice, List<AlertRule> alertRules){
        for (AlertRule alertRule : alertRules){
            if (shouldTrigger(currentPrice, alertRule)){
                triggerAlert(currentPrice, alertRule);
            }
        }
    }

    private boolean shouldTrigger(BigDecimal currentPrice, AlertRule alertRule){
        return switch (alertRule.getPriceCondition()){
            case GREATER_THAN -> currentPrice.compareTo(alertRule.getTargetPrice()) > 0;
            case LESS_THAN -> currentPrice.compareTo(alertRule.getTargetPrice()) < 0;
        };
    }

    private void triggerAlert(BigDecimal currentPrice, AlertRule alertRule){
        log.info("!!!!!!!!! Alert triggered at price: {},\tTicker: {},\tRule id: {}", currentPrice, alertRule.getTicker(), alertRule.getId());

        alertRule.setStatus(Status.TRIGGERED);

        AlertEvent alertEvent = new AlertEvent();
        alertEvent.setAlertRule(alertRule);
        alertEvent.setTriggeredAt(LocalDateTime.now());
        alertEvent.setPrice(currentPrice);
        alertEvent.setCreatedBy("system");
        alertEventRepository.save(alertEvent);
    }
}
