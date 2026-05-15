package ooo.stock.StockPriceAlertSystem.dto;

import ooo.stock.StockPriceAlertSystem.model.AlertEvent;

import java.util.List;

public class AlertEventMapper {
    public static List<AlertEventResponse> toAlertEventResponses(List<AlertEvent> alertEvents){
        return alertEvents.stream().map(a -> new AlertEventResponse(a.getId(), a.getPrice(), a.getTriggeredAt())).toList();
    }

    public static AlertEventResponse toAlertEventResponse(AlertEvent alertEvent){
        return new AlertEventResponse(alertEvent.getId(), alertEvent.getPrice(), alertEvent.getTriggeredAt());
    }
}
