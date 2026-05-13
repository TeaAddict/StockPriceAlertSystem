package ooo.stock.StockPriceAlertSystem.controller;

import lombok.RequiredArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.*;
import ooo.stock.StockPriceAlertSystem.model.User;
import ooo.stock.StockPriceAlertSystem.service.AuthService;
import ooo.stock.StockPriceAlertSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest){
        User user = RegisterMapper.toUser(registerRequest);
        return ResponseEntity.ok(authService.register(user));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMe(Authentication authentication){
        return ResponseEntity.ok(UserMapper.toUserResponse(userService.getUserByEmail(authentication.getName())));
    }
}
