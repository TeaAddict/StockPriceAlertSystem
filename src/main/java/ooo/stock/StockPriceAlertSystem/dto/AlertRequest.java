package ooo.stock.StockPriceAlertSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AlertRequest(
        @NotBlank
        @Size(min = 2, max = 200, message = "Label size should be 2 - 200 chars")
        String label,

        @NotNull(message = "User id is required")
        Long userId
) {
}
