package ooo.stock.StockPriceAlertSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank
        @Size(min = 2, max = 50, message = "Username has to be of size 2 to 50")
        String userName,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 8, max = 100, message = "Password has to be longer than 8 characters")
        String password
) {
}
