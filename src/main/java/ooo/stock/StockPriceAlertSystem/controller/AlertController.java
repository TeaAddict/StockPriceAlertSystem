package ooo.stock.StockPriceAlertSystem.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.AlertMapper;
import ooo.stock.StockPriceAlertSystem.dto.AlertRequest;
import ooo.stock.StockPriceAlertSystem.dto.AlertResponse;
import ooo.stock.StockPriceAlertSystem.model.User;
import ooo.stock.StockPriceAlertSystem.service.AlertService;
import ooo.stock.StockPriceAlertSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class AlertController {

    private AlertService alertService;
    private UserService userService;

    @GetMapping("/alerts")
    public ResponseEntity<?> getAlerts(){
        return ResponseEntity.ok("");
    }

    @GetMapping("/alerts/{id}")
    public ResponseEntity<?> getAlert(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

    @PostMapping("/alerts")
    public ResponseEntity<AlertResponse> createAlert(@Valid @RequestBody AlertRequest alertRequest){
        return ResponseEntity.ok(AlertMapper.toAlertResponse(alertService.createAlert(alertRequest)));
    }

    @PutMapping("/alerts/{id}")
    public ResponseEntity<?> updateAlert(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/alerts/{id}")
    public ResponseEntity<?> deleteAlert(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

}
