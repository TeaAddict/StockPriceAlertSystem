package ooo.stock.StockPriceAlertSystem.service;

import lombok.AllArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.AlertRuleRequest;
import ooo.stock.StockPriceAlertSystem.exception.ResourceNotFoundException;
import ooo.stock.StockPriceAlertSystem.model.AlertRule;
import ooo.stock.StockPriceAlertSystem.model.Status;
import ooo.stock.StockPriceAlertSystem.model.User;
import ooo.stock.StockPriceAlertSystem.repository.AlertRuleRepository;
import ooo.stock.StockPriceAlertSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AlertRuleService {

    private final AlertRuleRepository alertRuleRepository;
    private final UserRepository userRepository;

    public AlertRule createAlert(AlertRuleRequest alertRuleRequest){
        User user = userRepository.findById(alertRuleRequest.userId()).orElseThrow(() -> new ResourceNotFoundException("User does not exist"));

        AlertRule alertRule = new AlertRule();
        alertRule.setTicker(alertRuleRequest.ticker());
        alertRule.setPriceCondition(alertRuleRequest.priceCondition());
        alertRule.setTargetPrice(alertRuleRequest.targetPrice());
        alertRule.setStatus(Status.ACTIVE);
        alertRule.setUser(user);
        alertRuleRepository.save(alertRule);
        return alertRule;
    }

    public List<AlertRule> getAlertRules(){
        return alertRuleRepository.findAll();
    }

    public AlertRule getAlertRule(Long alertId){
        return alertRuleRepository.findById(alertId).orElseThrow(() -> new ResourceNotFoundException("AlertRule not found"));
    }

    public AlertRule updateAlertRule(Long alertId, AlertRuleRequest alertRuleRequest){
        AlertRule alertRule = alertRuleRepository.findById(alertId).orElseThrow(() -> new ResourceNotFoundException("AlertRule not found"));
        User user = userRepository.findById(alertRuleRequest.userId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        alertRule.setTicker(alertRuleRequest.ticker());
        alertRule.setPriceCondition(alertRuleRequest.priceCondition());
        alertRule.setTargetPrice(alertRuleRequest.targetPrice());
        alertRule.setUser(user);
        alertRuleRepository.save(alertRule);
        return alertRule;
    }

    public void deleteAlertRule(Long alertId){
        AlertRule alertRule = alertRuleRepository.findById(alertId).orElseThrow(() -> new ResourceNotFoundException("AlertRule not found"));
        alertRuleRepository.deleteById(alertId);
    }
}
