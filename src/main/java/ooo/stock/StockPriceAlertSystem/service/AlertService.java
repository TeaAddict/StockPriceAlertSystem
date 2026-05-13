package ooo.stock.StockPriceAlertSystem.service;

import lombok.AllArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.AlertRequest;
import ooo.stock.StockPriceAlertSystem.exception.ResourceNotFoundException;
import ooo.stock.StockPriceAlertSystem.model.Alert;
import ooo.stock.StockPriceAlertSystem.model.User;
import ooo.stock.StockPriceAlertSystem.repository.AlertRepository;
import ooo.stock.StockPriceAlertSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AlertService {

    private final AlertRepository alertRepository;
    private final UserRepository userRepository;

    public Alert createAlert(AlertRequest alertRequest){
        User user = userRepository.findById(alertRequest.userId()).orElseThrow(() -> new ResourceNotFoundException("User does not exist"));

        Alert alert = new Alert(alertRequest.label());
        alert.setUser(user);
        alertRepository.save(alert);
        return alert;
    }
}
