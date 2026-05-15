package ooo.stock.StockPriceAlertSystem.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.AlertRuleMapper;
import ooo.stock.StockPriceAlertSystem.dto.AlertRuleRequest;
import ooo.stock.StockPriceAlertSystem.dto.AlertRuleResponse;
import ooo.stock.StockPriceAlertSystem.service.AlertRuleService;
import ooo.stock.StockPriceAlertSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class AlertRuleController {

    private AlertRuleService alertRuleService;
    private UserService userService;

    @GetMapping("/alerts")
    public ResponseEntity<List<AlertRuleResponse>> getAlerts(){
        return ResponseEntity.ok(AlertRuleMapper.toAlertResponses(alertRuleService.getAlerts()));
    }

    @GetMapping("/alerts/{id}")
    public ResponseEntity<AlertRuleResponse> getAlert(@PathVariable Long id){
        return ResponseEntity.ok(AlertRuleMapper.toAlertResponse(alertRuleService.getAlert(id)));
    }

    @PostMapping("/alerts")
    public ResponseEntity<AlertRuleResponse> createAlert(@Valid @RequestBody AlertRuleRequest alertRuleRequest){
        return ResponseEntity.ok(AlertRuleMapper.toAlertResponse(alertRuleService.createAlert(alertRuleRequest)));
    }

    @PutMapping("/alerts/{id}")
    public ResponseEntity<?> updateAlert(@PathVariable Long id, @Valid @RequestBody AlertRuleRequest alertRuleRequest){
        alertRuleService.updateAlert(id, alertRuleRequest);
        return ResponseEntity.ok(AlertRuleMapper.toAlertResponse(alertRuleService.updateAlert(id, alertRuleRequest)));
    }

    @DeleteMapping("/alerts/{id}")
    public ResponseEntity<?> deleteAlert(@PathVariable Long id){
        alertRuleService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }

}
