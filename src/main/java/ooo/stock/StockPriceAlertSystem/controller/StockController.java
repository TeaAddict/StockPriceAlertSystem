package ooo.stock.StockPriceAlertSystem.controller;

import lombok.AllArgsConstructor;
import ooo.stock.StockPriceAlertSystem.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/stocks")
@RestController
public class StockController {

    private final StockService stockService;

    @GetMapping("/")
    public ResponseEntity<?> getStocks(){
        return ResponseEntity.ok("");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStock(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

    @PostMapping("/")
    public ResponseEntity<?> createStock(){
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStock(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

}
