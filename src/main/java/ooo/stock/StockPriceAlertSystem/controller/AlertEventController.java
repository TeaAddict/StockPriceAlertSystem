package ooo.stock.StockPriceAlertSystem.controller;

import lombok.AllArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.AlertEventMapper;
import ooo.stock.StockPriceAlertSystem.dto.AlertEventResponse;
import ooo.stock.StockPriceAlertSystem.service.AlertEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class AlertEventController {

    private final AlertEventService alertEventService;

    @GetMapping("/alertEvent")
    public ResponseEntity<List<AlertEventResponse>> getAlertEvents(){
        return ResponseEntity.ok(AlertEventMapper.toAlertEventResponses(alertEventService.getAlertEvents()));
    }

    @GetMapping("/alertEvent/{alertEventId}")
    public ResponseEntity<AlertEventResponse> getAlertEvent(@PathVariable Long alertEventId){
        return ResponseEntity.ok(AlertEventMapper.toAlertEventResponse(alertEventService.getAlertEvent(alertEventId)));
    }
}
