package ooo.stock.StockPriceAlertSystem.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import ooo.stock.StockPriceAlertSystem.model.PriceCondition;

import java.math.BigDecimal;

public record AlertRuleRequest(
        @NotBlank(message = "Ticker is required")
        @Size(min = 2, max = 200, message = "Ticker size should be 2 - 200 chars")
        String ticker,

        @NotNull(message = "Price condition is required")
        PriceCondition priceCondition,

        @NotNull(message = "Target price is required")
        @DecimalMin(value = "0.01", message = "Target price be greater than 0")
        BigDecimal targetPrice,

        @NotNull(message = "User id is required")
        Long userId
) {
}
