package ooo.stock.StockPriceAlertSystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/stocks")
@RestController
public class StockController {

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
