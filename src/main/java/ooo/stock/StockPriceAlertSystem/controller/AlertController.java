package ooo.stock.StockPriceAlertSystem.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.AlertMapper;
import ooo.stock.StockPriceAlertSystem.dto.AlertRequest;
import ooo.stock.StockPriceAlertSystem.dto.AlertResponse;
import ooo.stock.StockPriceAlertSystem.service.AlertService;
import ooo.stock.StockPriceAlertSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class AlertController {

    private AlertService alertService;
    private UserService userService;

    @GetMapping("/alerts")
    public ResponseEntity<List<AlertResponse>> getAlerts(){
        return ResponseEntity.ok(AlertMapper.toAlertResponses(alertService.getAlerts()));
    }

    @GetMapping("/alerts/{id}")
    public ResponseEntity<AlertResponse> getAlert(@PathVariable Long id){
        return ResponseEntity.ok(AlertMapper.toAlertResponse(alertService.getAlert(id)));
    }

    @PostMapping("/alerts")
    public ResponseEntity<AlertResponse> createAlert(@Valid @RequestBody AlertRequest alertRequest){
        return ResponseEntity.ok(AlertMapper.toAlertResponse(alertService.createAlert(alertRequest)));
    }

    @PutMapping("/alerts/{id}")
    public ResponseEntity<?> updateAlert(@PathVariable Long id, @Valid @RequestBody AlertRequest alertRequest ){
        alertService.updateAlert(id, alertRequest);
        return ResponseEntity.ok(AlertMapper.toAlertResponse(alertService.updateAlert(id, alertRequest)));
    }

    @DeleteMapping("/alerts/{id}")
    public ResponseEntity<?> deleteAlert(@PathVariable Long id){
        alertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }

}
