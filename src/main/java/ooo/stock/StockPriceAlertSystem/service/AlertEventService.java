package ooo.stock.StockPriceAlertSystem.service;

import lombok.AllArgsConstructor;
import ooo.stock.StockPriceAlertSystem.exception.ResourceNotFoundException;
import ooo.stock.StockPriceAlertSystem.model.AlertEvent;
import ooo.stock.StockPriceAlertSystem.repository.AlertEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AlertEventService {
    private final AlertEventRepository alertEventRepository;

    public AlertEvent getAlertEvent(Long alertEventId){
        return alertEventRepository.findById(alertEventId).orElseThrow(()-> new ResourceNotFoundException("Alert event not found"));
    }

    public List<AlertEvent> getAlertEvents(){
        return alertEventRepository.findAll();
    }
}
