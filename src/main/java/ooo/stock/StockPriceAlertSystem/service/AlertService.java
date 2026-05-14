package ooo.stock.StockPriceAlertSystem.service;

import lombok.AllArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.AlertRequest;
import ooo.stock.StockPriceAlertSystem.exception.ResourceNotFoundException;
import ooo.stock.StockPriceAlertSystem.model.Alert;
import ooo.stock.StockPriceAlertSystem.model.User;
import ooo.stock.StockPriceAlertSystem.repository.AlertRepository;
import ooo.stock.StockPriceAlertSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AlertService {

    private final AlertRepository alertRepository;
    private final UserRepository userRepository;

    public Alert createAlert(AlertRequest alertRequest){
        User user = userRepository.findById(alertRequest.userId()).orElseThrow(() -> new ResourceNotFoundException("User does not exist"));

        Alert alert = new Alert();
        alert.setLabel(alertRequest.label());
        alert.setPriceCondition(alertRequest.priceCondition());
        alert.setTargetPrice(alertRequest.targetPrice());
        alert.setUser(user);
        alertRepository.save(alert);
        return alert;
    }

    public List<Alert> getAlerts(){
        return alertRepository.findAll();
    }

    public Alert getAlert(Long alertId){
        return alertRepository.findById(alertId).orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
    }

    public Alert updateAlert(Long alertId, AlertRequest alertRequest){
        Alert alert = alertRepository.findById(alertId).orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
        User user = userRepository.findById(alertRequest.userId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        alert.setLabel(alertRequest.label());
        alert.setPriceCondition(alertRequest.priceCondition());
        alert.setTargetPrice(alertRequest.targetPrice());
        alert.setUser(user);
        alertRepository.save(alert);
        return alert;
    }

    public void deleteAlert(Long alertId){
        Alert alert = alertRepository.findById(alertId).orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
        alertRepository.deleteById(alertId);
    }
}
