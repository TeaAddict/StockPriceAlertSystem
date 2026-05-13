package ooo.stock.StockPriceAlertSystem.service;

import ooo.stock.StockPriceAlertSystem.dto.AlertRequest;
import ooo.stock.StockPriceAlertSystem.model.Alert;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

    public Alert createAlert(AlertRequest alertRequest){
        Alert alert = new Alert(alertRequest.label());
        return alert;
    }
}
