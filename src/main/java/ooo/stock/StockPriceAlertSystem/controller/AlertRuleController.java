package ooo.stock.StockPriceAlertSystem.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.AlertRuleMapper;
import ooo.stock.StockPriceAlertSystem.dto.AlertRuleRequest;
import ooo.stock.StockPriceAlertSystem.dto.AlertRuleResponse;
import ooo.stock.StockPriceAlertSystem.service.AlertRuleService;
import ooo.stock.StockPriceAlertSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class AlertRuleController {

    private final AlertRuleService alertRuleService;
    private final UserService userService;

    @GetMapping("/alert-rules")
    public ResponseEntity<List<AlertRuleResponse>> getAlertRules(){
        return ResponseEntity.ok(AlertRuleMapper.toAlertRuleResponses(alertRuleService.getAlertRules()));
    }

    @GetMapping("/alert-rules/{id}")
    public ResponseEntity<AlertRuleResponse> getAlertRule(@PathVariable Long id){
        return ResponseEntity.ok(AlertRuleMapper.toAlertRuleResponse(alertRuleService.getAlertRule(id)));
    }

    @PostMapping("/alert-rules")
    public ResponseEntity<AlertRuleResponse> createAlert(@Valid @RequestBody AlertRuleRequest alertRuleRequest){
        return ResponseEntity.ok(AlertRuleMapper.toAlertRuleResponse(alertRuleService.createAlert(alertRuleRequest)));
    }

    @PutMapping("/alert-rules/{id}")
    public ResponseEntity<?> updateAlert(@PathVariable Long id, @Valid @RequestBody AlertRuleRequest alertRuleRequest){
        return ResponseEntity.ok(AlertRuleMapper.toAlertRuleResponse(alertRuleService.updateAlertRule(id, alertRuleRequest)));
    }

    @DeleteMapping("/alert-rules/{id}")
    public ResponseEntity<?> deleteAlert(@PathVariable Long id){
        alertRuleService.deleteAlertRule(id);
        return ResponseEntity.noContent().build();
    }

}
