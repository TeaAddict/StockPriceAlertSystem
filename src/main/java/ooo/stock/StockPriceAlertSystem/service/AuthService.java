package ooo.stock.StockPriceAlertSystem.service;


import lombok.RequiredArgsConstructor;
import ooo.stock.StockPriceAlertSystem.dto.LoginRequest;
import ooo.stock.StockPriceAlertSystem.dto.LoginResponse;
import ooo.stock.StockPriceAlertSystem.dto.RegisterResponse;
import ooo.stock.StockPriceAlertSystem.exception.ResourceNotFoundException;
import ooo.stock.StockPriceAlertSystem.model.User;
import ooo.stock.StockPriceAlertSystem.repository.UserRepository;
import ooo.stock.StockPriceAlertSystem.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserService userService;

    public LoginResponse login(LoginRequest loginRequest){
        User user = userRepository.findUserByEmail(loginRequest.email()).orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));

        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())){
            throw new ResourceNotFoundException("Invalid email or password");
        }

        String token = jwtService.generateToken(user.getEmail(), user.getRole(), user.getId());
        return new LoginResponse(token);
    }

    public RegisterResponse register(User user){
        userService.saveUser(user);
        return new RegisterResponse(jwtService.generateToken(user.getEmail(), user.getRole(), user.getId()));
    }
}
