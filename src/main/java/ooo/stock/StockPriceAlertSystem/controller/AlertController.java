package ooo.stock.StockPriceAlertSystem.controller;

import lombok.AllArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.AlertRequest;
import ooo.stock.StockPriceAlertSystem.service.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/alerts")
@RestController
public class AlertController {

    private AlertService alertService;

    @GetMapping("/")
    public ResponseEntity<?> getAlerts(){
        return ResponseEntity.ok("");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAlert(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

    @PostMapping("/")
    public ResponseEntity<?> createAlert(@RequestBody AlertRequest alertRequest){
        alertService.createAlert(alertRequest);

        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlert(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlert(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

}
