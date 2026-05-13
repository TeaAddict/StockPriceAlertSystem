package ooo.stock.StockPriceAlertSystem.dto;

import ooo.stock.StockPriceAlertSystem.model.Alert;

public class AlertMapper {
    public static AlertResponse toAlertResponse(Alert alert){
        return new AlertResponse(alert.getId(), alert.getLabel());
    }
}
