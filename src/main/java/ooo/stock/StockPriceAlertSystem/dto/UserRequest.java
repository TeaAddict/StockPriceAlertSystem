package ooo.stock.StockPriceAlertSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import ooo.stock.StockPriceAlertSystem.model.Role;

public record UserRequest(

        @Size(min = 2, max = 200, message = "Label size should be 2 - 200 chars")
        String userName,

        @Email
        String email,

        String password
) {
}
