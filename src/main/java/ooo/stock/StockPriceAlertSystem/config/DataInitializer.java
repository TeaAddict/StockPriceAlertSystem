package ooo.stock.StockPriceAlertSystem.config;


import lombok.RequiredArgsConstructor;
import ooo.stock.StockPriceAlertSystem.model.Role;
import ooo.stock.StockPriceAlertSystem.model.User;
import ooo.stock.StockPriceAlertSystem.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args){
        if (userRepository.existsByEmail("admin@example.com")) {
            return;
        }

        User admin = new User();
        admin.setUserName("admin");
        admin.setEmail("admin@example.com");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole(Role.ADMIN);

        userRepository.save(admin);
        System.out.println("Default admin user created");
    }
}
