package ooo.stock.StockPriceAlertSystem.dto;

import ooo.stock.StockPriceAlertSystem.model.AlertRule;

import java.util.List;

public class AlertRuleMapper {
    public static AlertRuleResponse toAlertResponse(AlertRule alertRule){
        return new AlertRuleResponse(alertRule.getId(), alertRule.getTicker(), alertRule.getPriceCondition(), alertRule.getTargetPrice(), alertRule.getUser().getId());
    }

    public static List<AlertRuleResponse> toAlertResponses(List<AlertRule> alertRules){
        return alertRules.stream().map((a) -> new AlertRuleResponse(a.getId(), a.getTicker(), a.getPriceCondition(), a.getTargetPrice(), a.getUser().getId())).toList();
    }
}
