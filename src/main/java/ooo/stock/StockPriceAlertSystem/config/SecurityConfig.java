package ooo.stock.StockPriceAlertSystem.config;

import lombok.RequiredArgsConstructor;
import ooo.stock.StockPriceAlertSystem.security.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // TODO - remove later
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/alerts").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/alerts").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/alerts").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/alerts/*").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/alerts/*").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/*/sessions").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/*/sessions/*").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/*/sessions").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/sessions/*/registrations").hasAnyRole("USER", "ADMIN")
                        // TODO - allow user to only get his own registration
                        .requestMatchers(HttpMethod.GET, "/api/sessions/registrations/*").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/sessions/*/registrations").hasRole("ADMIN")
                        .requestMatchers("/api/auth/register").permitAll()
                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/api/auth/me").permitAll()
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .anyRequest().denyAll()
                ).addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
