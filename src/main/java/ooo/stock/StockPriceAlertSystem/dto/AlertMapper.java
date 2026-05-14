package ooo.stock.StockPriceAlertSystem.dto;

import ooo.stock.StockPriceAlertSystem.model.Alert;

import java.util.List;

public class AlertMapper {
    public static AlertResponse toAlertResponse(Alert alert){
        return new AlertResponse(alert.getId(), alert.getLabel(), alert.getPriceCondition(), alert.getTargetPrice(), alert.getUser().getId());
    }

    public static List<AlertResponse> toAlertResponses(List<Alert> alerts){
        return alerts.stream().map((a) -> new AlertResponse(a.getId(), a.getLabel(), a.getPriceCondition(), a.getTargetPrice(), a.getUser().getId())).toList();
    }
}
