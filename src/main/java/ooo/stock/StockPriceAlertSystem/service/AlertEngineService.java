package ooo.stock.StockPriceAlertSystem.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ooo.stock.StockPriceAlertSystem.model.AlertRule;
import ooo.stock.StockPriceAlertSystem.model.Status;
import ooo.stock.StockPriceAlertSystem.repository.AlertEventRepository;
import ooo.stock.StockPriceAlertSystem.repository.AlertRuleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Transactional
    public void processAlerts(){
        log.info("Starting alert processing...");

        List<AlertRule> activeAlertRules = alertRuleRepository.findByStatus(Status.ACTIVE);

        if (activeAlertRules.isEmpty()){
            log.info("No active rules found");
            return;
        }

        Map<String, List<AlertRule>> alertRulesByTicker = activeAlertRules.stream().collect(Collectors.groupingBy(AlertRule::getTicker));

        for (Map.Entry<String, List<AlertRule>> entry : alertRulesByTicker.entrySet()) {

        }
    }

    private void evaluateRules(List<AlertRule> alertRules, BigDecimal currentPrice){
    }

    private boolean shouldTrigger(AlertRule alertRule, BigDecimal currentPrice){
        return true;
    }

    private void triggerAlert(AlertRule alertRule, BigDecimal currentPrice){}



//    @Transactional
//    public void processAlerts(){
//        log.info("Starting alert processing...");
//
//        List<AlertRule> activeAlertRules = alertRuleRepository.findByStatus(Status.ACTIVE);
//
//        if (activeAlertRules.isEmpty()){
//            log.info("No active rules found");
//        }
//
//        Map<String, List<AlertRule>> alertRulesByTicker = activeAlertRules.stream().collect(Collectors.groupingBy(AlertRule::getTicker));
//
//        for (Map.Entry<String, List<AlertRule>> entry : alertRulesByTicker.entrySet()) {
//
//        }
//    }
//
//    private void evaluateRules(List<AlertRule> alertRules, BigDecimal currentPrice){
//    }
//
//    private boolean shouldTrigger(AlertRule alertRule, BigDecimal currentPrice){
//        return true;
//    }
//
//    private void triggerAlert(AlertRule alertRule, BigDecimal currentPrice){}

}
