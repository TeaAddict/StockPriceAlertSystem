package ooo.stock.StockPriceAlertSystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RestController
public class UserController {

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribe(){
        return ResponseEntity.ok("");
    }

    @PostMapping("/unsubscribe")
    public ResponseEntity<?> unsubscribe(){
        return ResponseEntity.ok("");
    }

    @GetMapping("/")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok("");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(){
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

}
