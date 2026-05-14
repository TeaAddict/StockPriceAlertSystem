package ooo.stock.StockPriceAlertSystem.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import ooo.stock.StockPriceAlertSystem.model.PriceCondition;

import java.math.BigDecimal;

public record AlertResponse(
        Long id,
        String label,
        PriceCondition priceCondition,
        BigDecimal targetPrice,
        Long userId
) {
}
