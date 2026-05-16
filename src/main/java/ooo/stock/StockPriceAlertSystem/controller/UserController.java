package ooo.stock.StockPriceAlertSystem.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.UserMapper;
import ooo.stock.StockPriceAlertSystem.dto.UserRequest;
import ooo.stock.StockPriceAlertSystem.dto.UserResponse;
import ooo.stock.StockPriceAlertSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribe(){
        return ResponseEntity.ok("");
    }

    @PostMapping("/unsubscribe")
    public ResponseEntity<?> unsubscribe(){
        return ResponseEntity.ok("");
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> getUsers(){
        return ResponseEntity.ok(UserMapper.toUserResponses(userService.getUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId){
        return ResponseEntity.ok(UserMapper.toUserResponse(userService.getUserById(userId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequest userRequest){
        return ResponseEntity.ok(UserMapper.toUserResponse(userService.updateUser(id, userRequest)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok("");
    }

}
